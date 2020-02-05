package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate (Product product){
        checkNotNull(product);
        final BigDecimal maxValue = new BigDecimal("100");
        final BigDecimal minPriceValue = new BigDecimal("20");
        if (product.getDiscount().compareTo(maxValue) == 1){
            throw new IllegalArgumentException("Discount should not be more than " + maxValue + "!");
        }

        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Discount must not be less than 0!");
        }

        if ((product.getDiscount().compareTo(BigDecimal.ZERO) > 0) && (product.getPrice().compareTo(minPriceValue) < 0)){
            throw new IllegalArgumentException("You can not make a discount at a price of less than " + minPriceValue + "!");
        }
    }
}
