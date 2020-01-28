package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductService {

    public void checkName(String name) throws IllegalArgumentException{
        if (name.length() < 3 || name.length() > 32){
            throw new IllegalArgumentException("Name length is incorrect!");
        }
    }

    public void checkPrice(BigDecimal price) throws IllegalArgumentException{
        if (price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price must be greater than 0!");
        }
    }

    public void checkCategory(String stringCategory) throws IllegalArgumentException{
        //try{
            Category category = Category.valueOf(stringCategory);
        //} catch (Exception e) {
        //    throw new IllegalArgumentException("Category is incorrect!");
        //}
    }

    public void checkDiscount(BigDecimal discount) throws IllegalArgumentException{
        final BigDecimal maxValue = BigDecimal.valueOf(100);
        if (discount.compareTo(maxValue) == 1){
            throw new IllegalArgumentException("Discount should not be more than " + maxValue + "!");
        }
    }

}
