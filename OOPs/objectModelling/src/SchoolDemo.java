import java.util.*;

class Course {
    String name;
    ArrayList<Student> students = new ArrayList<>();
    Course(String name) { this.name = name; }
    void enroll(Student s) {
        students.add(s); s.courses.add(this);
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();
    Student(String name) { this.name = name; }
    void showCourses() {
        System.out.print(name + " enrolled in: ");
        for (Course c : courses) System.out.print(c.name + " ");
        System.out.println();
    }
}

class School {
    String name;
    ArrayList<Student> students = new ArrayList<>();
    School(String name) { this.name = name; }
    void addStudent(Student s) { students.add(s); }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School sch = new School("DPS");
        Student s1 = new Student("Ankita");
        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        sch.addStudent(s1);
        c1.enroll(s1);
        c2.enroll(s1);

        s1.showCourses();
    }
}
