import java.util.Scanner;

class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter perimeter of square: ");
        double perimeter = input.nextDouble();

        // Calculation
        double side = perimeter / 4;

        // Output
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}
