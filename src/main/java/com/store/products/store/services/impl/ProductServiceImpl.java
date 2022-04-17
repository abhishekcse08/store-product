package com.store.products.store.services.impl;

import com.store.products.store.dao.CustomEngineProductDatabase;
import com.store.products.store.dto.EngineProduct;
import com.store.products.store.services.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public EngineProduct getEngineProduct(String engineName) {

        List<EngineProduct> products = CustomEngineProductDatabase.getAllEngineProduct()
                .stream().filter(EngineProduct -> EngineProduct.getEngMft().equalsIgnoreCase(engineName))
                //.map(e -> e)
                .collect(Collectors.toList());
        return products.get(0);
    }
}
