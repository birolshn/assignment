package com.example.assignment.business.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedAssignmentResponse {
    private int id;

    private int driverId;

    private int vehicleId;

    private Date assignedDate;

    private Date returnDate;
}
