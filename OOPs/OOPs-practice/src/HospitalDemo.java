class Patient {
    static String hospitalName = "AIIMS";
    static int patientCount = 0;
    final int patientID;
    String name;

    Patient(int patientID, String name) {
        this.patientID = patientID;
        this.name = name;
        patientCount++;
    }

    void display() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID + ", Name: " + name);
        }
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Ankita");
        Patient p2 = new Patient(2, "Ravi");

        p1.display();
        p2.display();

        System.out.println("Total Patients: " + Patient.patientCount);
    }
}
