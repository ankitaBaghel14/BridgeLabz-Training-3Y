class Product {
    static double discount = 0.1;
    final int productID;
    String name;
    double price;

    Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    void showPrice() {
        if (this instanceof Product) {
            double finalPrice = price - (price * discount);
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + name);
            System.out.println("Price after discount: " + finalPrice);
        }
    }
}

public class CartDemo {
    public static void main(String[] args) {
        Product p1 = new Product(201, "Laptop", 50000);
        Product p2 = new Product(202, "Phone", 20000);

        p1.showPrice();
        p2.showPrice();
    }
}
