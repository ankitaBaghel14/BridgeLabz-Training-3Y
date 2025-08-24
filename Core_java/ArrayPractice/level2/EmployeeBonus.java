import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        // Loop to take input for 10 employees
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter data for Employee " + (i + 1));
            System.out.print("Enter salary: ");
            double salary = input.nextDouble();
            if (salary < 0) {
                System.out.println("Invalid salary. Please enter a positive value.");
                i--;
                continue;
            }
            salaries[i] = salary;

            System.out.print("Enter years of service: ");
            double years = input.nextDouble();
            if (years < 0) {
                System.out.println("Invalid years of service. Please enter a positive value.");
                i--;
                continue;
            }
            yearsOfService[i] = years;
        }

        // Loop to calculate bonus, new salary, and totals
        for (int i = 0; i < 10; i++) {
            double bonusPercentage;
            if (yearsOfService[i] > 5) {
                bonusPercentage = 0.05;
            } else {
                bonusPercentage = 0.02;
            }

            bonuses[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
            totalBonus += bonuses[i];
        }

        System.out.println("\n--- Employee Bonus Summary ---");
        System.out.printf("Total Old Salary: $%.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: $%.2f\n", totalNewSalary);
        System.out.printf("Total Bonus Payout: $%.2f\n", totalBonus);
    }
}