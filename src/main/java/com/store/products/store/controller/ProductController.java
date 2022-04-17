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

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/engProduct")
    public ResponseEntity<?> getEngineProduct(){
        try {
            EngineProduct tata = productService.getEngineProduct("Tata");
            ResponseEntity<EngineProduct> re = new ResponseEntity<>(tata,HttpStatus.OK);
            return re;
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMsg());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);

        }
        catch (Exception e){
            ControllerException ce = new ControllerException("610","Something issue in controller");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/api/saveEngProduct")
    public ResponseEntity<?> saveEngProduct(@RequestBody EngineProduct engineProduct){

        try {
            ResponseEntity<EngineProduct> respEntity = new ResponseEntity<>(productService.addEngineProduct(engineProduct).get(0), HttpStatus.OK);

            return respEntity;
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMsg());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);

        }
        catch (Exception e){
            ControllerException ce = new ControllerException("610","Something issue in controller");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }
}
