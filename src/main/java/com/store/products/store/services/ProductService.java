package com.store.products.store.services;

import com.store.products.store.dto.EngineProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public EngineProduct getEngineProduct(String engineName);
    public List<EngineProduct> addEngineProduct(EngineProduct product);

}
