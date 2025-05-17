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
public class GetAllAssignmentsWithDriverNameAndVehicleBrandResponse {
    private int id;

    private String name;

    private String brand;

    private Date assignedDate;

    private Date returnDate;
}
