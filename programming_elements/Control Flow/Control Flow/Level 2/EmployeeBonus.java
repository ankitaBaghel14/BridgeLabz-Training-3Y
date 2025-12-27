import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("50000\n7"); // Custom input: salary and years
        
        System.out.println("Enter your salary:");
        double salary = scanner.nextDouble();

        System.out.println("Enter your years of service:");
        int yearsOfService = scanner.nextInt();

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Your bonus amount is: " + bonus);
        } else {
            System.out.println("You are not eligible for a bonus yet.");
        }
        scanner.close();
    }
}
