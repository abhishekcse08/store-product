package com.store.products.store.customexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BusinessException extends RuntimeException {

    private String errorCode;
    private String errorMsg;
}
