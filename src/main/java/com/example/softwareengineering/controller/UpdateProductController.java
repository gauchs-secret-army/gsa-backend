package com.example.softwareengineering.controller;
import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.entity.Products;
import com.example.softwareengineering.repository.EmployeeRepository;
import com.example.softwareengineering.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UpdateProductController {
    private final ProductsRepository repo;

    @Autowired

    public UpdateProductController(ProductsRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/products/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Products> UpdateProduct(@RequestBody Products prod) {
        if (repo.findById(prod.getProductID()).isPresent()){
            Products oldProd = repo.findById(prod.getProductID()).get();
            oldProd.setName(prod.getName());
            oldProd.setImage(prod.getImage());
            oldProd.setPrice(prod.getPrice());
            repo.save(oldProd);
            return new ResponseEntity(oldProd, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}



