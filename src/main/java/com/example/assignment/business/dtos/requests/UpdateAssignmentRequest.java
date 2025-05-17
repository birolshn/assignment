package com.example.assignment.business.dtos.requests;

import com.example.assignment.business.validations.annotations.ReturnDateGreaterThanAssignedDate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ReturnDateGreaterThanAssignedDate
public class UpdateAssignmentRequest {
    @NotNull
    private int id;

    @NotNull(message = "Choose a Driver")
    private int driverId;

    @NotNull(message = "Choose a Brand")
    private int vehicleId;

    @NotNull(message = "Choose a Assigned Date")
    @FutureOrPresent
    private Date assignedDate;

    @NotNull(message = "Choose a Return Date")
    @Future
    private Date returnDate;
}
