package com.example.assignment.api.controllers;

import com.example.assignment.business.abstracts.AssignmentService;
import com.example.assignment.business.abstracts.DriverService;
import com.example.assignment.business.abstracts.VehicleService;
import com.example.assignment.business.dtos.requests.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/assignments")
@AllArgsConstructor
public class AssignmentController {
    private AssignmentService assignmentService;

    @PostMapping("/add")

    public ResponseEntity<?> add(@RequestBody CreateAssignmentRequest request) {

        return ResponseEntity.ok(assignmentService.add(request));

    }

    @DeleteMapping("/delete")

    public ResponseEntity<?> delete(@RequestBody DeleteAssignmentRequest request) {
        return ResponseEntity.ok(assignmentService.delete(request));

    }

    @PutMapping("/update")

    public ResponseEntity<?> update(@Valid @RequestBody UpdateAssignmentRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError());

        }
        return ResponseEntity.ok(assignmentService.update(request));

    }


}
