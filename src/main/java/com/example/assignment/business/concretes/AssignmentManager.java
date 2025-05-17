package com.example.assignment.business.concretes;

import com.example.assignment.business.abstracts.AssignmentService;
import com.example.assignment.business.abstracts.DriverService;
import com.example.assignment.business.abstracts.VehicleService;
import com.example.assignment.business.dtos.requests.*;
import com.example.assignment.business.dtos.responses.*;
import com.example.assignment.core.utilities.mappers.ModelMapperService;
import com.example.assignment.entities.Assignment;
import com.example.assignment.repositories.AssignmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AssignmentManager implements AssignmentService {
    private AssignmentRepository assignmentRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedAssignmentResponse add(CreateAssignmentRequest request) {
        Assignment assignment = this.modelMapperService.forRequest()
                .map(request, Assignment.class);

        Assignment savedAssignment = assignmentRepository.save(assignment);
        CreatedAssignmentResponse assignmentResponse = this.modelMapperService.forResponse()
                .map(savedAssignment, CreatedAssignmentResponse.class);
        return assignmentResponse;
    }

    @Override
    public UpdatedAssignmentResponse update(UpdateAssignmentRequest request) {
        Assignment assignment = this.modelMapperService.forRequest()
                .map(request, Assignment.class);
        Assignment updatedAssignment = assignmentRepository.save(assignment);

        UpdatedAssignmentResponse updatedAssignmentResponse = this.modelMapperService.forResponse()
                .map(updatedAssignment, UpdatedAssignmentResponse.class);
        return updatedAssignmentResponse;
    }

    @Override
    public DeletedAssignmentResponse delete(DeleteAssignmentRequest request) {
        Assignment assignment = assignmentRepository.findById(request.getId()).orElseThrow();
        assignmentRepository.deleteById(request.getId());
        DeletedAssignmentResponse deletedAssignmentResponse = this.modelMapperService.forResponse()
                .map(assignment, DeletedAssignmentResponse.class);
        return deletedAssignmentResponse;
    }

    @Override
    public List<GetAllAssignmentsWithDriverNameAndVehicleBrandResponse> getAll() {

        List<Assignment> assignments = assignmentRepository.findAll();

        List<GetAllAssignmentsWithDriverNameAndVehicleBrandResponse> assignmentListResponse =
                new ArrayList<>();

        for(var assignment : assignments){

            GetAllAssignmentsWithDriverNameAndVehicleBrandResponse assignmentResponse = new
                    GetAllAssignmentsWithDriverNameAndVehicleBrandResponse();

            assignmentResponse.setId(assignment.getId());
            assignmentResponse.setName(assignment.getDriver().getName());
            assignmentResponse.setBrand(assignment.getVehicle().getBrand());
            assignmentResponse.setAssignedDate(assignment.getAssignedDate());
            assignmentResponse.setReturnDate(assignment.getReturnDate());

            assignmentListResponse.add(assignmentResponse);

        }
        return assignmentListResponse;
    }
}
