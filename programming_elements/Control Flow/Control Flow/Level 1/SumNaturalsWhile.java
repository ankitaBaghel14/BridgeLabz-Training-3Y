import java.util.Scanner;

public class SumNaturalsWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();
        if (number > 0) {
            long sumFromFormula = (long) number * (number + 1) / 2;
            System.out.println("Result from formula n*(n+1)/2: " + sumFromFormula);
            long sumFromWhileLoop = 0;
            int i = 1;
            while (i <= number) {
                sumFromWhileLoop += i;
                i++;
            }
            System.out.println("Result from while loop: " + sumFromWhileLoop);
            if (sumFromFormula == sumFromWhileLoop) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There was an error in computation.");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
        scanner.close();
    }
}
