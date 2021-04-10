package com.example.softwareengineering.controller;

import com.example.softwareengineering.entity.Employee;
import com.example.softwareengineering.entity.Products;
import com.example.softwareengineering.entity.SearchTerm;
import com.example.softwareengineering.repository.EmployeeRepository;
import com.example.softwareengineering.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public ResponseEntity<List<Products>> GetAllProducts(@RequestBody SearchTerm searchTerm) {
        try {
            List<Products> AllProductList;
            AllProductList = repo.findAll();
            String search = searchTerm.getTerm().toLowerCase();
            for(int i = 0; i < AllProductList.size(); i++)
            {
                Products item = AllProductList.get(i);
                if(!(item.getName().toLowerCase().contains(search)|| item.getProductID().toString().contains(search)) && !search.equals(""))
                {
                    AllProductList.remove(i);
                    i--;
                }
            }
            for(int i = 0; i < searchTerm.getItems() * (searchTerm.getPage() - 1); i++)
            {
                AllProductList.remove(0);
            }
            while(AllProductList.size() > searchTerm.getItems())
            {
                AllProductList.remove(AllProductList.get(searchTerm.getItems()));
            }
            return new ResponseEntity(AllProductList, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
