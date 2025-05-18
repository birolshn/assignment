pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDS = credentials('docker-hub')
        APP_IMAGE = "birol29/assignment:latest"
        PATH = "/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:${env.PATH}"
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
                /*sh '''
                  export PATH=/usr/local/bin:$PATH
                  docker buildx build --platform linux/arm64 -t ${APP_IMAGE} --load .
                '''*/
                sh "docker buildx build --platform linux/arm64 -t ${APP_IMAGE} --load ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                /*sh '''
                  export PATH=/usr/local/bin:$PATH
                  echo ${DOCKER_HUB_CREDS_PSW} | docker login -u ${DOCKER_HUB_CREDS_USR} --password-stdin
                  docker push ${APP_IMAGE}
                '''*/

                sh "echo ${DOCKER_HUB_CREDS_PSW} | docker login -u ${DOCKER_HUB_CREDS_USR} --password-stdin"
                sh "docker push ${APP_IMAGE}"

            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                echo "minikube starting..."
                /*sh '''
                  export PATH=/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH
                  which docker
                  which minikube
                  which kubectl
                  minikube start
                '''*/
                sh "minikube start"

                echo "Deploying application to Kubernetes..."
                /*sh '''
                  export PATH=/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH
                  which docker
                  which minikube
                  which kubectl
                  kubectl apply -f kubernetes/webapp-deployment.yml
                '''*/
                sh "kubectl apply -f kubernetes/webapp-deployment.yml"

                echo "Checking pod status..."
                /*sh '''
                  export PATH=/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH
                  which docker
                  which minikube
                  which kubectl
                  kubectl get pods
                '''*/
                sh "kubectl get pods"

                echo "Creating service..."
                /*sh '''
                  export PATH=/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH
                  which docker
                  which minikube
                  which kubectl
                  kubectl apply -f kubernetes/webapp-service.yml
                '''*/
                sh "kubectl apply -f kubernetes/webapp-service.yml"

                echo "Checking service status..."
                /*sh '''
                  export PATH=/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH
                  which docker
                  which minikube
                  which kubectl
                  kubectl get services
                '''*/
                sh "kubectl get services"

                echo "Displaying node information..."
                /*sh '''
                  export PATH=/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH
                  which docker
                  which minikube
                  which kubectl
                  kubectl get nodes -o wide
                '''*/
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