pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDS = credentials('docker-hub')
        APP_IMAGE = "birol29/assignment:latest"
    }

    stages {
        stage('Pull the project from GitHub') {
            steps {
                echo "Pulling the project from GitHub..."
                git branch: 'main', url: 'https://github.com/birolshn/assignment.git'
            }
        }        

        stage('Build JAR') {
            steps {

                sh 'chmod +x ./gradlew'
                sh './gradlew clean bootJar'

            }
        }

        stage('Build Docker Image') {
            steps {

                sh "/usr/local/bin/docker build -t ${APP_IMAGE} ."

            }
        }

        stage('Push to Docker Hub') {
            steps {

                sh "echo ${DOCKER_HUB_CREDS_PSW} | docker login -u ${DOCKER_HUB_CREDS_USR} --password-stdin"
                sh "docker push ${APP_IMAGE}"

            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                echo "minikube starting..."
                sh "minikube start"

                echo "Deploying application to Kubernetes..."
                sh "kubectl apply -f kubernetes/webapp-deployment.yml"

                echo "Checking pod status..."
                sh "kubectl get pods"

                echo "Creating service..."
                sh "kubectl apply -f kubernetes/webapp-service.yml"

                echo "Checking service status..."
                sh "kubectl get services"

                echo "Displaying node information..."
                sh "kubectl get nodes -o wide"

            }
        }
    }

    post {
        success {
            echo "Pipeline başarıyla tamamlandı!"
        }
        failure {
            echo "Pipeline başarısız oldu. Logları kontrol edin."
        }
        always {
            sh "docker image prune -f"
        }
    }
}