import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
