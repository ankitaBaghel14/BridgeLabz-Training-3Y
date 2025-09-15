import java.util.Random;

public class EmployeeBonus {

    public static double[][] getEmployeeData() {
        double[][] employees = new double[10][2];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            employees[i][0] = 10000 + random.nextDouble() * 90000; // 5-digit salary
            employees[i][1] = 1 + random.nextInt(15); // Years of service
        }
        return employees;
    }

    public static double[][] calculateBonus(double[][] employees) {
        double[][] newEmployeeData = new double[10][3]; // Old salary, New salary, Bonus
        for (int i = 0; i < 10; i++) {
            double oldSalary = employees[i][0];
            double yearsOfService = employees[i][1];
            double bonusPercentage = (yearsOfService > 5) ? 0.05 : 0.02;
            double bonusAmount = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonusAmount;

            newEmployeeData[i][0] = oldSalary;
            newEmployeeData[i][1] = newSalary;
            newEmployeeData[i][2] = bonusAmount;
        }
        return newEmployeeData;
    }

    public static void displayReport(double[][] employees, double[][] newEmployeeData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("\n--- Employee Bonus Report ---");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-5s | %-15s | %-15s | %-15s | %-15s\n", "ID", "Old Salary", "Years of Service", "New Salary", "Bonus Amount");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            double oldSalary = newEmployeeData[i][0];
            double newSalary = newEmployeeData[i][1];
            double bonusAmount = newEmployeeData[i][2];
            double yearsOfService = employees[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonusAmount;

            System.out.printf("%-5d | %-15.2f | %-15.0f | %-15.2f | %-15.2f\n",
                    i + 1, oldSalary, yearsOfService, newSalary, bonusAmount);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("Total   | %-15.2f | %-15s | %-15.2f | %-15.2f\n",
                totalOldSalary, "", totalNewSalary, totalBonus);
        System.out.println("-------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        double[][] employees = getEmployeeData();
        double[][] newEmployeeData = calculateBonus(employees);
        displayReport(employees, newEmployeeData);
    }
}