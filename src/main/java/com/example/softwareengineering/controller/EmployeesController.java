package com.example.softwareengineering.controller;

import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeesController {
    private final EmployeeRepository employeeRepository;
    EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/employees")
    List<Employee> all() {
        return (List<Employee>) employeeRepository.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

}
