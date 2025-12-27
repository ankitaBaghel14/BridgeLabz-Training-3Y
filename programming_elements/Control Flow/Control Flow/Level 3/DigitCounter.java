import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int count = 0;
        int tempNumber = number;

        if (tempNumber == 0) {
            count = 1;
        } else {
            while (tempNumber != 0) {
                tempNumber /= 10;
                count++;
            }
        }

        System.out.println("The number of digits in " + number + " is: " + count);
        scanner.close();
    }
}
