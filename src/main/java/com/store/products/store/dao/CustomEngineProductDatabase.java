package com.store.products.store.dao;

import com.store.products.store.dto.EngineProduct;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomEngineProductDatabase {

    public static  List<EngineProduct> getAllEngineProduct(){
        return Stream.of(
                new EngineProduct("2002","Tata","4","Piston","Car")
                ,new EngineProduct("2001","Ashoka","40","RIM","Jeep")
                ,new EngineProduct("2003","SEL","3","Nozel","Bike")

        ).collect(Collectors.toList());
    }
}
