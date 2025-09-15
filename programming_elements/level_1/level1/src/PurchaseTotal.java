import java.util.Scanner;

class PurchaseTotal {
    public static void main(String[] args) {

        double unitPrice;
        int quantity;
        double totalPrice;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter unit price: ");
        unitPrice = input.nextDouble();

        System.out.print("Enter quantity: ");
        quantity = input.nextInt();

        totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice +
                " if the quantity is " + quantity + " and unit price is INR " + unitPrice);

        input.close();
    }
}
