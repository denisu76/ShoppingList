package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) throws IllegalArgumentException{
        validationService.validate(product);

        if (!repository.isUnique(product)){
            throw new IllegalArgumentException("Product name is not unique!");
        }

        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProduct(Long id){
        return repository.findProductById(id);
    }

    public void deletProduct(Long id) {
        repository.deletProductById(id);
    }
}
