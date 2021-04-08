package com.example.softwareengineering.controller;

import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.entity.Products;
import com.example.softwareengineering.repository.EmployeeRepository;
import com.example.softwareengineering.repository.ProductsRepository;
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
    private final ProductsRepository repo;

    @Autowired

    public GetProductsRouteController(ProductsRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<Products>> GetAllProducts(@RequestBody String searchTerm, @RequestBody int itemsPerPage, @RequestBody int pageNumber) {
        try {
            List<Products> AllProductList;
            AllProductList = repo.findAll();
            for(int i = 0; i < AllProductList.size(); i++)
            {
                if(!AllProductList.get(i).getName().contains(searchTerm))
                {
                    AllProductList.remove(i);
                    i--;
                }
            }
            for(int i = 0; i < itemsPerPage * (pageNumber - 1); i++)
            {
                AllProductList.remove(0);
            }
            while(AllProductList.size() > itemsPerPage)
            {
                AllProductList.remove(itemsPerPage);
            }
            return new ResponseEntity(AllProductList, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
