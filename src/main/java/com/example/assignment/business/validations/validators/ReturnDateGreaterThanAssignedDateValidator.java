package com.example.assignment.business.validations.validators;

import com.example.assignment.business.dtos.requests.UpdateAssignmentRequest;
import com.example.assignment.business.validations.annotations.ReturnDateGreaterThanAssignedDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ReturnDateGreaterThanAssignedDateValidator implements ConstraintValidator<ReturnDateGreaterThanAssignedDate, UpdateAssignmentRequest> {
    @Override
    public boolean isValid(UpdateAssignmentRequest request, ConstraintValidatorContext context) {
        return request.getReturnDate().after(request.getAssignedDate());
    }
}
