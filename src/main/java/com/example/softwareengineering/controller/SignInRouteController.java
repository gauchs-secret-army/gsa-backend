package com.example.softwareengineering.controller;
import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class SignInRouteController {
    private final EmployeeRepository repo;

    @Autowired

    public SignInRouteController(EmployeeRepository repo) {
        this.repo = repo;
    }

    //reach this endpoint at url/signin
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> VerifyCreds(@RequestBody Employee employee) { //takes a single object with applicable parameters
        if (repo.findById(employee.getEmployeeID()).isPresent())
        { //use employeeId to check that it exists
            String password = repo.findById(employee.getEmployeeID()).get().getPassword(); //temp var to store database-stored password
            if (password.equals(employee.getPassword()))
            { //if database-stored pass equals object-passed pass
                String role = repo.findById(employee.getEmployeeID()).get().getRole(); //store employee role in temp var
                if (role.equals("Shift Manager") || role.equals("General Manager")) {
                    return new ResponseEntity(true, HttpStatus.OK); //if manager, return true in an OK HTTPStatus wrapper
                } else {
                    return new ResponseEntity(false, HttpStatus.OK); //if not, return false in an OK HTTPStatus wrapper
                }
            }
            return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
        } //if incorrect password or nonexistent employee ID, return UNAUTHORIZED HTTPStatus
    }
}



