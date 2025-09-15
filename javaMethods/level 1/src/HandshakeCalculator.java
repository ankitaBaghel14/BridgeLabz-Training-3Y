import java.util.Scanner;

public class HandshakeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        long handshakes = calculateHandshakes(numberOfStudents);

        System.out.println("The maximum number of possible handshakes is: " + handshakes);
        scanner.close();
    }

    public static long calculateHandshakes(int n) {
        if (n < 2) {
            return 0;
        }
        return (long) n * (n - 1) / 2;
    }
}