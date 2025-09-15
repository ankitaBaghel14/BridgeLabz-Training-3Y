import java.util.Scanner;

class SquareSide {
    public static void main(String[] args) {

        double perimeter;
        double side;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the perimeter of square: ");
        perimeter = input.nextDouble();

        side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}
