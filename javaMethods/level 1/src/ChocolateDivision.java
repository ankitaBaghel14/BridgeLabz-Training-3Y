import java.util.Scanner;

public class ChocolateDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        if (numberOfChildren <= 0) {
            System.out.println("Number of children must be greater than zero.");
            scanner.close();
            return;
        }

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Each child gets " + result[0] + " chocolate(s).");
        System.out.println("Remaining chocolates: " + result[1]);
        scanner.close();
    }

    // The method name and signature were specified in the prompt
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        result[0] = number / divisor;
        result[1] = number % divisor;
        return result;
    }
}