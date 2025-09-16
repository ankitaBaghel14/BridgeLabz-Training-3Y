import java.util.*;

class Product {
    String name;
    double price;
    Product(String name, double price) { this.name = name; this.price = price; }
}

class Order {
    ArrayList<Product> products = new ArrayList<>();
    void addProduct(Product p) { products.add(p); }
    void showOrder() {
        System.out.println("Order contains:");
        for (Product p : products) System.out.println(" - " + p.name + " : " + p.price);
    }
}

class Customer {
    String name;
    Customer(String name) { this.name = name; }
    Order placeOrder() {
        System.out.println(name + " placed an order");
        return new Order();
    }
}

public class EcommerceDemo {
    public static void main(String[] args) {
        Customer c1 = new Customer("Ankita");
        Order o1 = c1.placeOrder();

        o1.addProduct(new Product("Laptop", 50000));
        o1.addProduct(new Product("Mouse", 1000));

        o1.showOrder();
    }
}
