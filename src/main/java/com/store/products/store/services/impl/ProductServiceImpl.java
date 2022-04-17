package com.store.products.store.services.impl;

import com.store.products.store.customexception.BusinessException;
import com.store.products.store.dao.CustomEngineProductDatabase;
import com.store.products.store.dto.EngineProduct;
import com.store.products.store.services.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    @Override
    public EngineProduct getEngineProduct(String engineName) {

        List<EngineProduct> products = CustomEngineProductDatabase.getAllEngineProduct()
                .stream().filter(EngineProduct -> EngineProduct.getEngMft().equalsIgnoreCase(engineName))
                .collect(Collectors.toList());
        try {
            if (products.isEmpty()) {
                throw new BusinessException("604","There is nothing in DB to show");
            }

            return products.get(0);
        }
        catch (NoSuchElementException e){
            throw new BusinessException("605","No such element present "+ e.getMessage());
        }
        catch (Exception e){
            throw new BusinessException("603","There is a issue in service level "+e.getMessage());
        }
    }

    @Override
    public List<EngineProduct> addEngineProduct(EngineProduct product) {

        if(product.getEngName().isEmpty() || product.getEngName().length()==0){
            throw new BusinessException("601","Product Engine Name is blank or Null");
        }
        try{

        CustomEngineProductDatabase.saveEngineProduct(product);
        return CustomEngineProductDatabase.getAllEngineProduct();
    }
        catch (IllegalArgumentException e){
            throw new BusinessException("602","given is null "+e.getMessage());
        }
        catch (Exception e){
            throw new BusinessException("603","Something went wrong in service level "+e.getMessage());
        }
    }
}
