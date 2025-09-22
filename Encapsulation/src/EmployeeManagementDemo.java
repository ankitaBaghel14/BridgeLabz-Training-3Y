import java.util.*;

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.printf("ID: %s | Name: %s | Salary: %.2f%n", employeeId, name, calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(String id, String name, double baseSalary, double allowance) {
        super(id, name, baseSalary);
        this.allowance = allowance;
    }

    public double getAllowance() { return allowance; }
    public void setAllowance(double allowance) { this.allowance = allowance; }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + allowance;
    }
}

class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, double hourlyRate, double hoursWorked) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class EmployeeManagementDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("FT001", "Asha", 30000, 5000));
        employees.add(new PartTimeEmployee("PT001", "Ravi", 200, 80));

        // Polymorphism: treat all as Employee
        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}
