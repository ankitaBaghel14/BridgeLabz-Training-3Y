import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName; this.price = price; this.quantity = quantity;
    }

    // Encapsulation
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return String.format("%s x%d -> %.2f", itemName, quantity, calculateTotalPrice());
    }
}

interface Discountable {
    double applyDiscount(); // absolute
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }
    @Override public double calculateTotalPrice() { return getPrice() * getQuantity(); }
    @Override public double applyDiscount() { return getPrice() * getQuantity() * 0.05; } // 5% veg discount
    @Override public String getDiscountDetails() { return "Veg 5%"; }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }
    @Override public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double extra = 20 * getQuantity(); // extra handling fee per non-veg item
        return base + extra;
    }
    @Override public double applyDiscount() { return 0; }
    @Override public String getDiscountDetails() { return "No discount"; }
}

public class FoodOrderDemo {
    public static double calculateOrderTotal(List<FoodItem> items) {
        double total = 0;
        for (FoodItem f : items) {
            double itemTotal = f.calculateTotalPrice();
            double discount = (f instanceof Discountable) ? ((Discountable)f).applyDiscount() : 0;
            total += itemTotal - discount;
            System.out.printf("%s | Discount: %.2f%n", f.getItemDetails(), discount);
        }
        return total;
    }

    public static void main(String[] args) {
        List<FoodItem> order = Arrays.asList(
                new VegItem("Paneer Tikka", 200, 2),
                new NonVegItem("Chicken Biryani", 250, 1)
        );

        double finalAmount = calculateOrderTotal(order);
        System.out.printf("Order total: %.2f%n", finalAmount);
    }
}
