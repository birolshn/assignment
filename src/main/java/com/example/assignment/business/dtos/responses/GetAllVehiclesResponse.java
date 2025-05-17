package com.example.assignment.business.dtos.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllVehiclesResponse {
    private int id;

    private String brand;

    private String model;

    private String color;

    private String type;
}
