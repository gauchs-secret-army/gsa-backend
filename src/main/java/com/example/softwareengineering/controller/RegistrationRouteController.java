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

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Integer> CreateEmployee(@RequestBody Employee emp) {
        try {
            emp.setEmployeeID((int)(Math.random()*89999)+10000);
            emp.setActive(true);
            repo.save(emp);
            return new ResponseEntity(emp.getEmployeeID(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}