package com.example.softwareengineering.commands;

import com.example.softwareengineering.repository.EmployeeRepository;
import javassist.NotFoundException;

public class ActiveEmployeeExistsQuery {
    private EmployeeRepository employeeRepository;

    public void ActiveEmployeeExists() throws NotFoundException {
        if (this.employeeRepository.existsByActive(false)) {
            throw new NotFoundException("No employees found");
        }
    }
}
