import java.util.*;

class Professor {
    String name;
    Professor(String name) { this.name = name; }
}

class CourseU {
    String name;
    Professor prof;
    ArrayList<StudentU> students = new ArrayList<>();
    CourseU(String name) { this.name = name; }
    void assignProfessor(Professor p) { this.prof = p; }
    void enroll(StudentU s) { students.add(s); s.courses.add(this); }
}

class StudentU {
    String name;
    ArrayList<CourseU> courses = new ArrayList<>();
    StudentU(String name) { this.name = name; }
    void enrollCourse(CourseU c) { c.enroll(this); }
}

public class UniversitySystemDemo {
    public static void main(String[] args) {
        StudentU s1 = new StudentU("Ankita");
        Professor p1 = new Professor("Dr. Kumar");
        CourseU c1 = new CourseU("Java");

        c1.assignProfessor(p1);
        s1.enrollCourse(c1);

        System.out.println(s1.name + " enrolled in " + c1.name + " taught by " + c1.prof.name);
    }
}
