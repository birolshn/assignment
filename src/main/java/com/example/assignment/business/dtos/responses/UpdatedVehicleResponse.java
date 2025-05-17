package com.example.assignment.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedVehicleResponse {
    private int id;

    private String brand;

    private String model;

    private String color;

    private String type;
}
