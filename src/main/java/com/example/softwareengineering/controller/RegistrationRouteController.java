package com.example.softwareengineering.controller;
import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationRouteController {
    private final EmployeeRepository repo;

    @Autowired

    public RegistrationRouteController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity CreateEmployee(@RequestBody Employee emp) {
        try {
            repo.save(emp);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}