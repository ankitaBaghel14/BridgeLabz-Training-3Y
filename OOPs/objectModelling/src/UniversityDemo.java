import java.util.*;

class Faculty {
    String name;
    Faculty(String name) { this.name = name; }
}

class DepartmentU {
    String deptName;
    DepartmentU(String deptName) { this.deptName = deptName; }
}

class University {
    String name;
    ArrayList<DepartmentU> depts = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();
    University(String name) { this.name = name; }
    void addDepartment(DepartmentU d) { depts.add(d); }
    void addFaculty(Faculty f) { faculties.add(f); }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University u = new University("Delhi University");
        DepartmentU d1 = new DepartmentU("CSE");
        Faculty f1 = new Faculty("Dr. Sharma");

        u.addDepartment(d1);
        u.addFaculty(f1);

        System.out.println(u.name + " has dept " + d1.deptName + " and faculty " + f1.name);
    }
}
