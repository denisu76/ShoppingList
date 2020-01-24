package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        ProductService validationService = new ProductService();
        Long productIdSequence = 0L;
        boolean isOk = true;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Delete product by id");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        validationService.checkName(name);
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        validationService.checkPrice(price);
                        System.out.println("Enter product category: ");
                        String stringCategory = scanner.nextLine();
                        validationService.checkCategory(stringCategory);
                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        validationService.checkDiscount(discount);
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setId(productIdSequence);
                        product.setCategory(Category.valueOf(stringCategory));
                        product.setDiscount(discount);
                        product.setDescription(description);

                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        long del_id = scanner.nextLong();
                        productRepository.remove(del_id);
                        break; 
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! " + e.getMessage() + " Please try again.");
            }
        }
    }
}
