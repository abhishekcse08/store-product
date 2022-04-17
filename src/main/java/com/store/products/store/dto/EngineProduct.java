package com.store.products.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EngineProduct {

    private String engModel;
    private String engMft;
    private String engineQty;
    private String engName;
    private String engType;
}
