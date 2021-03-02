package com.example.softwareengineering.controller;
import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.entity.EmployeeSignIn;
import com.example.softwareengineering.repository.EmployeeRepository;
import com.google.gson.JsonObject;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class SignInRouteController {
    private final EmployeeRepository repo;

    public SignInRouteController(EmployeeRepository repo)
    {
        this.repo = repo;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> VerifyCreds(@RequestBody EmployeeSignIn empSignIn){
        Predicate<Employee> byEmpId = emp -> emp.getEmployeeID() == empSignIn.getEmployeeID();
        Employee emp = ((List<Employee>) repo.findAll()).stream().filter(byEmpId).collect(Collectors.toList()).get(0);
        if(emp.getPassword().equals(empSignIn.getPassword())){
            String role = emp.getRole();
            if(role.equals("Shift Manager") || role.equals("General Manager")) {
                return new ResponseEntity("{'isManager': true}", HttpStatus.OK);
            } else return new ResponseEntity("{'isManager': false}", HttpStatus.OK);
        }
        return new ResponseEntity("{'isManager': false}", HttpStatus.UNAUTHORIZED);
    }
}
