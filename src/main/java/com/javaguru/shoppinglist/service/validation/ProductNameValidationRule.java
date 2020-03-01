package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule{

    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 32;

    @Override
    public void validate (Product product){
        checkNotNull(product);
        if (product.getName().length() < MIN_VALUE || product.getName().length() > MAX_VALUE){
            throw new IllegalArgumentException("Name length is incorrect!");
        }
    }

}
