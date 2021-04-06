package com.example.softwareengineering.controller;

import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.entity.Products;
import com.example.softwareengineering.repository.EmployeeRepository;
import com.example.softwareengineering.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateProductRouteController {

    private final ProductsRepository repo;

    @Autowired

    public CreateProductRouteController(ProductsRepository repo) {
        this.repo = repo;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity CreateProduct(@RequestBody Products prod) {
        try {
            repo.save(prod);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
