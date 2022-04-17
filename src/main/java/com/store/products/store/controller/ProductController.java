package com.store.products.store.controller;

import com.store.products.store.customexception.BusinessException;
import com.store.products.store.customexception.ControllerException;
import com.store.products.store.dto.EngineProduct;
import com.store.products.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*
 * Global Exception handler example using advice controller
 *
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    // This api will be accessible to all
    @GetMapping("/")
    public String welcomeToStore(){

        return "Welcome to store";


    }


    // This api will be accessible to some user
    @GetMapping("/api/engProduct")
    public ResponseEntity<?> getEngineProduct(){

            EngineProduct tata = productService.getEngineProduct("Tata");
            ResponseEntity<EngineProduct> re = new ResponseEntity<>(tata,HttpStatus.OK);
            return re;


    }

    // This api will accessible only to admin
    @PostMapping("/api/saveEngProduct")
    public ResponseEntity<?> saveEngProduct(@RequestBody EngineProduct engineProduct){


            ResponseEntity<EngineProduct> respEntity = new ResponseEntity<>(productService.addEngineProduct(engineProduct).get(0), HttpStatus.OK);

            return respEntity;

    }
}
