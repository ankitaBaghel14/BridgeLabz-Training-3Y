class Student {
    static String universityName = "Delhi University";
    final int rollNumber;
    String name;

    Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    void show() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll: " + rollNumber + ", Name: " + name);
        }
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Ankita");
        Student s2 = new Student(102, "Ravi");

        s1.show();
        s2.show();
    }
}
