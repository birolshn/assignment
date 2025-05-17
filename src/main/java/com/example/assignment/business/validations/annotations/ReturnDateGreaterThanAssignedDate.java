package com.example.assignment.business.validations.annotations;

import com.example.assignment.business.validations.validators.ReturnDateGreaterThanAssignedDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReturnDateGreaterThanAssignedDateValidator.class)
public @interface ReturnDateGreaterThanAssignedDate {
    String message() default "Return date must be greater than assigned date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
