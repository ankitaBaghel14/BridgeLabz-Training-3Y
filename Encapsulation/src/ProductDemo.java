import java.util.*;

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount(); // absolute amount

    public String getDetails() {
        return String.format("%s (%s) - %.2f", name, productId, price);
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) { super(id, name, price); }
    @Override public double calculateDiscount() { return getPrice() * 0.10; } // 10% discount
    @Override public double calculateTax() { return getPrice() * 0.18; } // 18% GST
    @Override public String getTaxDetails() { return "Electronics GST 18%"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) { super(id, name, price); }
    @Override public double calculateDiscount() { return getPrice() * 0.20; } // 20% sale
    @Override public double calculateTax() { return getPrice() * 0.05; } // 5% tax
    @Override public String getTaxDetails() { return "Clothing tax 5%"; }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) { super(id, name, price); }
    @Override public double calculateDiscount() { return 0; } // no discount
}

public class ProductDemo {
    public static void printFinalPrice(Product p) {
        double price = p.getPrice();
        double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
        double discount = p.calculateDiscount();
        double finalPrice = price + tax - discount;
        System.out.printf("%s -> Base: %.2f Tax: %.2f Discount: %.2f Final: %.2f%n",
                p.getDetails(), price, tax, discount, finalPrice);
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Electronics("E100", "Smartphone", 25000),
                new Clothing("C200", "T-Shirt", 499),
                new Groceries("G300", "Rice 5kg", 1200)
        );

        for (Product p : products) printFinalPrice(p);
    }
}
