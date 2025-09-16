class Employee {
    static String companyName = "Infosys";
    static int count = 0;
    final int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        count++;
    }

    void show() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("ID: " + id + ", Name: " + name);
        }
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Ankita");
        Employee e2 = new Employee(2, "Ravi");

        e1.show();
        e2.show();
        System.out.println("Total Employees: " + Employee.count);
    }
}
