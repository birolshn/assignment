package com.example.assignment.business.abstracts;

import com.example.assignment.business.dtos.requests.*;
import com.example.assignment.business.dtos.responses.*;

import java.util.List;

public interface VehicleService {
    CreatedVehicleResponse add(CreateVehicleRequest request);
    UpdatedVehicleResponse update(UpdateVehicleRequest request);
    DeletedVehicleResponse delete(DeleteVehicleRequest request);
    List<GetAllVehiclesResponse> getAll();
    GetVehicleByIdResponse getById(GetVehicleByIdRequest request);
    GetVehicleByBrandResponse getByBrand(GetVehicleByBrandRequest request);
}
