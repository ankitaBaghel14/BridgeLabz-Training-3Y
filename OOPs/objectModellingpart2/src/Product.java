public class Product {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public Product(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return pricePerUnit * quantity;
    }
}
