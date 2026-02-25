import java.util.*;

class Patient {
    String name;
    Patient(String name) { this.name = name; }
}

class Doctor {
    String name;
    Doctor(String name) { this.name = name; }
    void consult(Patient p) {
        System.out.println("Doctor " + name + " consulting patient " + p.name);
    }
}

class Hospital {
    String name;
    Hospital(String name) { this.name = name; }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Hospital h = new Hospital("AIIMS");
        Doctor d1 = new Doctor("Dr. Amit");
        Patient p1 = new Patient("Ankita");

        d1.consult(p1);
    }
}
