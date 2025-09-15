import java.util.Scanner;
import java.util.ArrayList;

public class FactorAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors of " + number + " are: ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Sum of square of factors: " + sumOfSquareFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));

        scanner.close();
    }

    public static int[] findFactors(int number) {
        ArrayList<Integer> factorList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factorList.add(i);
            }
        }
        int[] factors = new int[factorList.size()];
        for (int i = 0; i < factorList.size(); i++) {
            factors[i] = factorList.get(i);
        }
        return factors;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double sumOfSquareFactors(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }
}