package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {
    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product insert(Product product){
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findProductById(Long id) {
        return productRepository.get(id);
    }

    public void deletProductById(Long id) {
        productRepository.remove(id);
    }

    public boolean isUnique(Product product){
        for(Product productInRepository : productRepository.values()){
            if (productInRepository.getName().equals(product.getName())){return false;}
        }
        return true;
    }

}