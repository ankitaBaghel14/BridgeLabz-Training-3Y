public class GroceryApp {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        customer.addProduct(new Product("Apples", 3.0, 2));
        customer.addProduct(new Product("Milk", 2.0, 1));

        BillGenerator billGen = new BillGenerator();
        double totalBill = billGen.generateBill(customer);

        System.out.println("Customer: " + customer.getName());
        for (Product p : customer.getProducts()) {
            System.out.println(p.getName() + " x " + p.getQuantity() + " = $" + p.getTotalPrice());
        }
        System.out.println("Total Bill: $" + totalBill);
    }
}
