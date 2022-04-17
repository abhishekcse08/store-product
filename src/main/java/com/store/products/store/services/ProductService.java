package com.store.products.store.services;

import com.store.products.store.dto.EngineProduct;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public EngineProduct getEngineProduct(String engineName);
}
