import java.util.Scanner;

public class NaturalNumberSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number (n): ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a positive natural number.");
            scanner.close();
            return;
        }

        long sumRecursive = sumUsingRecursion(n);
        long sumFormula = sumUsingFormula(n);

        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both computations yield the same result. The result is correct.");
        } else {
            System.out.println("The results from both computations do not match.");
        }

        scanner.close();
    }

    public static long sumUsingRecursion(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static long sumUsingFormula(int n) {
        return (long) n * (n + 1) / 2;
    }
}