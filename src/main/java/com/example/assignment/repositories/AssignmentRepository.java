package com.example.assignment.repositories;

import com.example.assignment.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
}
