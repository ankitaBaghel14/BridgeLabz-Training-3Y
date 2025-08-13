import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {

        double base;
        double height;
        double area;
        final double CM_TO_INCH = 2.54;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter base in cm: ");
        base = input.nextDouble();

        System.out.print("Enter height in cm: ");
        height = input.nextDouble();

        area = 0.5 * base * height;

        double baseInInches = base / CM_TO_INCH;
        double heightInInches = height / CM_TO_INCH;

        System.out.println("Area of triangle in cm²: " + area +
                " and in inches²: " + (0.5 * baseInInches * heightInInches));

        input.close();
    }
}
