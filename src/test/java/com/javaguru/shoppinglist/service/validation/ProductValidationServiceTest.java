package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.Category;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductValidationServiceTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentException(){
        ProductValidationService victim = new ProductValidationService();
        Product product = product();
        ProductInMemoryRepository repository = new ProductInMemoryRepository();
        repository.insert(product);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product name is not unique!");
        victim.validate(product, repository);
    }

    private Product product(){
        Product product = new Product();
        product.setName("Test name");
        product.setCategory(Category.valueOf("FISH"));
        product.setDescription("testing");
        product.setDiscount(BigDecimal.valueOf(50));
        product.setPrice(BigDecimal.valueOf(1000));
        product.setId(10L);
        return product;
    }
}