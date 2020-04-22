package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.Category;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ShoppingCartProductService;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartProductService shoppingCartProductService;

    public ConsoleUI(ProductService productService, ShoppingCartService shoppingCartService,
                     ShoppingCartProductService shoppingCartProductService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartProductService = shoppingCartProductService;
    }

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Delete product by id");
                System.out.println("4. Create shopping cart");
                System.out.println("5. Find shopping cart by id");
                System.out.println("6. Assign product to shopping cart");
                System.out.println("7. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product category: ");
                        String stringCategory = scanner.nextLine();
                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(Category.valueOf(stringCategory));
                        product.setDiscount(discount);
                        product.setDescription(description);
                        Long productId = productService.createProduct(product);

                        System.out.println("Result: " + productId);
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productService.findProduct(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        long deleteId = scanner.nextLong();
                        productService.deletProduct(deleteId);
                        break;
                    case 4:
                        System.out.println("Enter shopping cart name: ");
                        String cartName = scanner.nextLine();
                        System.out.println("Enter shopping cart description: ");
                        String cartDescription = scanner.nextLine();

                        ShoppingCart shoppingCart = new ShoppingCart();
                        shoppingCart.setName(cartName);
                        shoppingCart.setDescription(cartDescription);

                        Long shoppingCartId = shoppingCartService.createShoppingCart(shoppingCart);
                        System.out.println("Result: " + shoppingCartId);
                        break;
                    case 5:
                        System.out.println("Enter shopping cart id: ");
                        long cartId = scanner.nextLong();
                        ShoppingCart findShoppingCartResult = shoppingCartService.findShoppingCart(cartId);
                        System.out.println(findShoppingCartResult);
                        break;
                    case 6:
                        System.out.println("Enter product id: ");
                        long createdProductId = scanner.nextLong();
                        System.out.println("Enter shopping cart id: ");
                        long createdCartId = scanner.nextLong();
                        System.out.println("Enter products amount in shopping cart : ");
                        long productsAmount = scanner.nextLong();
                        shoppingCartProductService.assignProductToShoppingCart(createdProductId, createdCartId, productsAmount);
                        break;
                    case 7:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! " + e.getMessage() + " Please try again.");
            }
        }
    }
}
