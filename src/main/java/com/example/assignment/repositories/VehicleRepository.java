package com.example.assignment.repositories;

import com.example.assignment.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findByBrand(String brand);
}
