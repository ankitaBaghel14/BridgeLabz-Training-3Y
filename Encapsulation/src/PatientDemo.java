import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId; this.name = name; this.age = age;
    }

    // Encapsulation
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public String getPatientDetails() {
        return String.format("%s - %s (%d)", patientId, name, age);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String entry);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, int days) {
        super(id,name,age); this.daysAdmitted = days;
    }

    @Override public double calculateBill() {
        return 2000 * daysAdmitted + 5000; // per day + room etc
    }

    @Override public void addRecord(String entry) { records.add(entry); }
    @Override public List<String> viewRecords() { return Collections.unmodifiableList(records); }
}

class OutPatient extends Patient implements MedicalRecord {
    private List<String> records = new ArrayList<>();
    public OutPatient(String id, String name, int age) { super(id,name,age); }

    @Override public double calculateBill() {
        return 500; // consultation flat
    }

    @Override public void addRecord(String entry) { records.add(entry); }
    @Override public List<String> viewRecords() { return Collections.unmodifiableList(records); }
}

public class PatientDemo {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new InPatient("P001","Sonal",30,5),
                new OutPatient("P002","Amit",40)
        );

        for (Patient p : patients) {
            System.out.printf("%s -> Bill: %.2f%n", p.getPatientDetails(), p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord)p;
                mr.addRecord("Checked on " + new Date());
                System.out.println("  Records: " + mr.viewRecords());
            }
        }
    }
}
