interface Graded { void assignGrade(String g); }

class Stu {
    private String n;
    private int id;
    private String g;

    Stu(String n, int id) { this.n = n; this.id = id; }

    public void assignGrade(String g) { this.g = g; }
    public void info() { System.out.println("Stu: " + n + ", ID: " + id + ", Grade: " + g); }
}

class UG extends Stu { UG(String n, int id) { super(n, id); } }
class PG extends Stu { PG(String n, int id) { super(n, id); } }

class Fac {
    private String n;
    Fac(String n) { this.n = n; }
    void info() { System.out.println("Fac: " + n); }
}

class Course {
    private String cn;
    private Fac f;
    Course(String cn, Fac f) { this.cn = cn; this.f = f; }
}

// ---------------- Main ----------------
public class Scenario3_University {
    public static void main(String[] args) {
        Fac f1 = new Fac("Dr. Sharma");
        Course c1 = new Course("Math", f1);

        UG s1 = new UG("Ankita", 101);
        PG s2 = new PG("Ravi", 102);

        s1.assignGrade("A+");
        s2.assignGrade("B");

        s1.info();
        s2.info();
        f1.info();
    }
}
