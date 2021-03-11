package com.example.softwareengineering.controller;

import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CreateProductRouteController {

    private final ProductRepository repo;

    @Autowired

    public CreateProductRouteController(ProductRepository repo) {
        this.repo = repo;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity CreateProduct(@RequestBody Product prod) {
        try {
            repo.save(prod);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
