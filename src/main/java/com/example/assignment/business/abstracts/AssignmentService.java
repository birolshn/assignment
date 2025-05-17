package com.example.assignment.business.abstracts;

import com.example.assignment.business.dtos.requests.CreateAssignmentRequest;
import com.example.assignment.business.dtos.requests.DeleteAssignmentRequest;
import com.example.assignment.business.dtos.requests.UpdateAssignmentRequest;
import com.example.assignment.business.dtos.responses.DeletedAssignmentResponse;
import com.example.assignment.business.dtos.responses.CreatedAssignmentResponse;
import com.example.assignment.business.dtos.responses.GetAllAssignmentsWithDriverNameAndVehicleBrandResponse;
import com.example.assignment.business.dtos.responses.UpdatedAssignmentResponse;

import java.util.List;

public interface AssignmentService {
    CreatedAssignmentResponse add(CreateAssignmentRequest request);
    UpdatedAssignmentResponse update(UpdateAssignmentRequest request);
    DeletedAssignmentResponse delete(DeleteAssignmentRequest request);
    List<GetAllAssignmentsWithDriverNameAndVehicleBrandResponse> getAll();
}
