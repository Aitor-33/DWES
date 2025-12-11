package com.example.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empleados.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
