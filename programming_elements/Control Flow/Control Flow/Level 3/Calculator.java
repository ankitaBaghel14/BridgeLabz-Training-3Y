import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        String op = scanner.next();

        double result;

        switch (op) {
            case "+":
                result = first + second;
                System.out.printf("%.2f + %.2f = %.2f\n", first, second, result);
                break;
            case "-":
                result = first - second;
                System.out.printf("%.2f - %.2f = %.2f\n", first, second, result);
                break;
            case "*":
                result = first * second;
                System.out.printf("%.2f * %.2f = %.2f\n", first, second, result);
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.printf("%.2f / %.2f = %.2f\n", first, second, result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
                break;
        }
        scanner.close();
    }
}
