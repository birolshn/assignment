package com.example.assignment.business.abstracts;

import com.example.assignment.business.dtos.requests.*;
import com.example.assignment.business.dtos.responses.*;

import java.util.List;

public interface DriverService {
    List<GetAllDriversResponse> getAll();
    GetAllDriversWithVehiclesResponse getAllWithVehicles();

    CreatedDriverResponse add(CreateDriverRequest request);
    UpdatedDriverResponse update(UpdateDriverRequest request);
    DeletedDriverResponse delete(DeleteDriverRequest request);
    GetDriverByIdResponse getById(GetDriverByIdRequest request);
    GetDriverByNameResponse getByName(GetDriverByNameRequest request);
}
