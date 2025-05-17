package com.example.assignment.api.controllers;

import com.example.assignment.business.abstracts.AssignmentService;
import com.example.assignment.business.abstracts.DriverService;
import com.example.assignment.business.abstracts.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class HomeController {
    private AssignmentService assignmentService;
    private DriverService driverService;
    private VehicleService vehicleService;
    @GetMapping("/")
    public String index() {
        return "home/index.html";
    }

    @GetMapping("/drivers")
    public String drivers(Model model) {
        var drivers = driverService.getAll();
        var vehicles = vehicleService.getAll();
        model.addAttribute("drivers", drivers);
        model.addAttribute("vehicles", vehicles);
        return "home/drivers.html";
    }

    @GetMapping("/vehicles")
    public String vehicles(Model model) {

        var vehicles = vehicleService.getAll();
        var drivers = driverService.getAll();
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("drivers", drivers);
        return "home/vehicles.html";
    }

    @GetMapping("/assignments")
    public String assignments(Model model) {
        var assignments = assignmentService.getAll();
        var drivers = driverService.getAll();
        var vehicles = vehicleService.getAll();

        model.addAttribute("assignments", assignments);
        model.addAttribute("drivers", drivers);
        model.addAttribute("vehicles", vehicles);

        return "home/assignments.html";
    }
}
