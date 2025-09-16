import java.util.*;

class Employee {
    String name;
    Employee(String name) { this.name = name; }
}

class Department {
    String deptName;
    ArrayList<Employee> employees = new ArrayList<>();
    Department(String deptName) { this.deptName = deptName; }
    void addEmployee(Employee e) { employees.add(e); }
}

class Company {
    String name;
    ArrayList<Department> depts = new ArrayList<>();
    Company(String name) { this.name = name; }
    void addDepartment(Department d) { depts.add(d); }
    void show() {
        System.out.println("Company: " + name);
        for (Department d : depts) {
            System.out.println(" Dept: " + d.deptName);
            for (Employee e : d.employees) {
                System.out.println("   Emp: " + e.name);
            }
        }
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Company c = new Company("Infosys");
        Department d1 = new Department("HR");
        d1.addEmployee(new Employee("Ankita"));
        d1.addEmployee(new Employee("Ravi"));

        c.addDepartment(d1);
        c.show();
    }
}
