package com.example.assignment.api.controllers;

import com.example.assignment.business.abstracts.DriverService;
import com.example.assignment.business.abstracts.VehicleService;
import com.example.assignment.business.dtos.requests.CreateAssignmentRequest;
import com.example.assignment.business.dtos.requests.CreateDriverRequest;
import com.example.assignment.business.dtos.requests.DeleteDriverRequest;
import com.example.assignment.business.dtos.requests.UpdateDriverRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Map;

@Controller
@RequestMapping("/drivers")
@AllArgsConstructor
public class DriverController {
    private DriverService driverService;

    @PostMapping("/add")

    public ResponseEntity<?> add(@RequestBody CreateDriverRequest request) {

        return ResponseEntity.ok(driverService.add(request));

    }

    @DeleteMapping("/delete")

    public ResponseEntity<?> delete(@RequestBody DeleteDriverRequest request) {
        return ResponseEntity.ok(driverService.delete(request));

    }

    @PutMapping("/update")

    public ResponseEntity<?> delete(@RequestBody UpdateDriverRequest request) {
        return ResponseEntity.ok(driverService.update(request));

    }

}
