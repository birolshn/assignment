package com.example.assignment.api.controllers;

import com.example.assignment.business.abstracts.DriverService;
import com.example.assignment.business.abstracts.VehicleService;
import com.example.assignment.business.dtos.requests.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
    private VehicleService vehicleService;

    @PostMapping("/add")

    public ResponseEntity<?> add(@RequestBody CreateVehicleRequest request) {

        return ResponseEntity.ok(vehicleService.add(request));

    }

    @DeleteMapping("/delete")

    public ResponseEntity<?> delete(@RequestBody DeleteVehicleRequest request) {
        return ResponseEntity.ok(vehicleService.delete(request));

    }

    @PutMapping("/update")

    public ResponseEntity<?> delete(@RequestBody UpdateVehicleRequest request) {
        return ResponseEntity.ok(vehicleService.update(request));

    }
}
