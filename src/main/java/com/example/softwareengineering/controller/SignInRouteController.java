package com.example.softwareengineering.controller;
import com.example.softwareengineering.entity.EmployeeSignIn;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/")
public class SignInRouteController {
    private final EmployeeRepository repo;

    public SignInRouteController(EmployeeRepository repo)
    {
        this.repo = repo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> VerifyCreds(@RequestParam EmployeeSignIn empSignIn, @RequestParam HttpServletRequest reqId){
        if(repo.findById(empSignIn.getEmployeeID()).get().getPassword().equals(empSignIn.getPassword())){
            if(repo.findById(empSignIn.getEmployeeID()).get().getRole().equals("Manager")) {
                return new ResponseEntity(true, HttpStatus.OK);
            } else return new ResponseEntity(false, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
