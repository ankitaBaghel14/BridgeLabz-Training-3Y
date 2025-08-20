import java.util.Scanner;

public class CountdownFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown start number: ");
        int startNumber = scanner.nextInt();
        System.out.println("Rocket launch countdown initiated!");
        for (int i = startNumber; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");
        scanner.close();
    }
}
