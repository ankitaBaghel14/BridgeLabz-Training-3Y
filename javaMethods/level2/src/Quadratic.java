import java.util.Scanner;

public class Quadratic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        findRoots(a, b, c);

        scanner.close();
    }

    public static void findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("The two roots are: root1 = %.2f and root2 = %.2f\n", root1, root2);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.printf("There is one real root: %.2f\n", root);
        } else {
            System.out.println("The equation has no real roots (delta is negative).");
        }
    }
}