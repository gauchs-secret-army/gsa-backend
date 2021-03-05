package com.example.softwareengineering.controller;
import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignInRouteController {
    private final EmployeeRepository repo;

    @Autowired

    public SignInRouteController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> VerifyCreds(@RequestBody int employeeId, @RequestBody String password) {
        if (repo.findById(employeeId).isPresent())
        {
            String passwordFromRepo = repo.findById(employeeId).get().getPassword();
            if (passwordFromRepo.equals(password))
            {
                String role = repo.findById(employeeId).get().getRole();
                if (role.equals("Shift Manager")) {
                    return new ResponseEntity(true, HttpStatus.OK);
                } else if (role.equals("General Manager")) {
                    return new ResponseEntity(true, HttpStatus.OK);
                }
            }
        }
        else {
            return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
    }
}



