package com.store.products.store.controller;

import com.store.products.store.dto.EngineProduct;
import com.store.products.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/engProduct")
    public EngineProduct getEngineProduct(){

        return productService.getEngineProduct("Tata");

    }
}
