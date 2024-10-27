Ques 3:

import java.util.Scanner;

// Enum for product categories
enum Category {
    ELECTRONICS, CLOTHING, GROCERIES
}

// Interface for discountable products
interface Discountable {
    double applyDiscount();
}

// Abstract Product class
abstract class Product implements Discountable {
    String name;
    double price;
    Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product: " + name);
        System.out.println("Category: " + category);
        System.out.println(String.format("Original Price: ₹%.2f", price));
        System.out.println(String.format("Discounted Price: ₹%.2f", applyDiscount()));
    }
}

// Electronics class that implements a discount strategy
class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price, Category.ELECTRONICS);
    }

    // 10% discount for electronics
    @Override
    public double applyDiscount() {
        return price * 0.90; // 10% off
    }
}

// Clothing class that implements a discount strategy
class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price, Category.CLOTHING);
    }

    // 20% discount for clothing
    @Override
    public double applyDiscount() {
        return price * 0.80; // 20% off
    }
}

// Groceries class that implements a discount strategy
class Groceries extends Product {
    public Groceries(String name, double price) {
        super(name, price, Category.GROCERIES);
    }

    // 5% discount for groceries
    @Override
    public double applyDiscount() {
        return price * 0.95; // 5% off
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input product details
        
        String categoryInput = scanner.nextLine().trim().toUpperCase();

        
        String productName = scanner.nextLine();

        
        double productPrice = scanner.nextDouble();

        Product product = null;

        // Create product based on the category
        switch (Category.valueOf(categoryInput)) {
            case ELECTRONICS:
                product = new Electronics(productName, productPrice);
                break;
            case CLOTHING:
                product = new Clothing(productName, productPrice);
                break;
            case GROCERIES:
                product = new Groceries(productName, productPrice);
                break;
            default:
                System.out.println("Invalid category!");
                break;
        }

        // If a valid product is created, display its details
        if (product != null) {
            product.displayProductDetails();
        }

        scanner.close();
    }
}

