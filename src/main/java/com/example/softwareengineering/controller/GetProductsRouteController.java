package com.example.softwareengineering.controller;

import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class GetProductsRouteController {
    private final ProductRepository repo;

    @Autowired

    public GetProductsRouteController(ProductRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<Product>> GetAllProducts() {
        try {
//            List<Employee> AllProductList;
//            AllProductList = repo.findAll();
            return new ResponseEntity(repo.findAll(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(new List<Product>(), HttpStatus.BAD_REQUEST);
        }
//        if (repo.findById(employee.getEmployeeID()).isPresent()) {
//            String password = repo.findById(employee.getEmployeeID()).get().getPassword();
//            if (password.equals(employee.getPassword())) {
//                String role = repo.findById(employee.getEmployeeID()).get().getRole();
//                if (role.equals("Shift Manager") || role.equals("General Manager")) {
//                    return new ResponseEntity(true, HttpStatus.OK);
//                } else {
//                    return new ResponseEntity(false, HttpStatus.OK);
//                }
//            }
//            return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
//        } else {
//            return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
//        }
    }
}
