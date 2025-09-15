import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee's salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter the years of service: ");
        int yearsOfService = scanner.nextInt();
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Congratulations! You get a bonus of: " + bonus);
            System.out.println("Your new total salary is: " + (salary + bonus));
        } else {
            System.out.println("You are not eligible for a bonus this year.");
        }
        scanner.close();
    }
}
