package com.example.assignment.business.concretes;

import com.example.assignment.business.abstracts.VehicleService;
import com.example.assignment.business.dtos.requests.*;
import com.example.assignment.business.dtos.responses.*;
import com.example.assignment.core.utilities.mappers.ModelMapperService;
import com.example.assignment.entities.Vehicle;
import com.example.assignment.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleManager implements VehicleService {
    private VehicleRepository vehicleRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedVehicleResponse add(CreateVehicleRequest request) {
        Vehicle vehicle = this.modelMapperService.forRequest()
                .map(request, Vehicle.class);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        CreatedVehicleResponse vehicleResponse = this.modelMapperService.forResponse()
                .map(savedVehicle, CreatedVehicleResponse.class);

        return vehicleResponse;
    }

    @Override
    public UpdatedVehicleResponse update(UpdateVehicleRequest request) {
        Vehicle vehicle = this.modelMapperService.forRequest()
                .map(request, Vehicle.class);

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        UpdatedVehicleResponse vehicleResponse = this.modelMapperService.forResponse()
                .map(updatedVehicle, UpdatedVehicleResponse.class);
        return vehicleResponse;
    }

    @Override
    public DeletedVehicleResponse delete(DeleteVehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findById(request.getId()).orElseThrow();
        vehicleRepository.deleteById(request.getId());

        DeletedVehicleResponse deletedVehicleResponse = this.modelMapperService.forResponse()
                .map(vehicle, DeletedVehicleResponse.class);
        return deletedVehicleResponse;
    }

    @Override
    public List<GetAllVehiclesResponse> getAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<GetAllVehiclesResponse> vehiclesResponse = vehicles.stream()
                .map(vehicle -> this.modelMapperService.forResponse()
                        .map(vehicle, GetAllVehiclesResponse.class))
                .collect(Collectors.toList());

        return vehiclesResponse;
    }


    @Override
    public GetVehicleByIdResponse getById(GetVehicleByIdRequest request) {
        var vehicle = vehicleRepository.findById(request.getId()).orElseThrow();
        GetVehicleByIdResponse vehicleResponse = this.modelMapperService.forResponse()
                .map(vehicle, GetVehicleByIdResponse.class);
        return vehicleResponse;
    }

    @Override
    public GetVehicleByBrandResponse getByBrand(GetVehicleByBrandRequest request) {
        return null;
    }
}
