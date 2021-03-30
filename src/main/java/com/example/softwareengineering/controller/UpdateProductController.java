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
public class UpdateProductController {
    private final ProductRepository repo;

    @Autowired

    public UpdateProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/products/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity UpdateProduct(@RequestParam(name = "id") String id, @RequestBody Product prod) {
        Product oldProd = repo.findById(id);
        
    }
}



