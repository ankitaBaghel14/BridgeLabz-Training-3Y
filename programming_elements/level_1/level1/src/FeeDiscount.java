import java.util.Scanner;

class FeeDiscount {
    public static void main(String[] args) {

        double fee;
        double discountPercent;
        double discountAmount;
        double finalFee;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the course fee (INR): ");
        fee = input.nextDouble();

        System.out.print("Enter discount percentage: ");
        discountPercent = input.nextDouble();

        discountAmount = (discountPercent / 100) * fee;
        finalFee = fee - discountAmount;

        System.out.println("The discount amount is INR " + discountAmount +
                " and final discounted fee is INR " + finalFee);

        input.close();
    }
}
