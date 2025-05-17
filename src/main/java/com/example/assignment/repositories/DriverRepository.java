package com.example.assignment.repositories;

import com.example.assignment.business.dtos.responses.GetAllDriversResponse;
import com.example.assignment.entities.Driver;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    Driver findByName(String name);
}
