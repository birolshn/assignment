package com.example.assignment.business.dtos.responses;

import com.example.assignment.entities.Driver;
import com.example.assignment.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDriversWithVehiclesResponse {
    private List<Driver> drivers;

    private List<GetAllVehiclesResponse> vehicles;
}
