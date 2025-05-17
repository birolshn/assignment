package com.example.assignment.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssignmentRequest {

    private int driverId;

    private int vehicleId;

    private Date assignedDate;

    private Date returnDate;
}
