interface Payable {
    double calcPay();
}

class Patient {
    private String n;
    private int a;
    private String mh; // medical history

    Patient(String n, int a) {
        this.n = n;
        this.a = a;
    }

    Patient(String n, int a, String mh) {
        this(n, a);
        this.mh = mh;
    }

    public String getSummary() {
        return "Name: " + n + ", Age: " + a;
    }
}

class InPatient extends Patient {
    private int rn; // room number

    InPatient(String n, int a, String mh, int rn) {
        super(n, a, mh);
        this.rn = rn;
    }

    @Override
    public String getSummary() {
        return super.getSummary() + ", Room: " + rn;
    }
}

class OutPatient extends Patient {
    private String ad; // appointment date

    OutPatient(String n, int a, String mh, String ad) {
        super(n, a, mh);
        this.ad = ad;
    }

    @Override
    public String getSummary() {
        return super.getSummary() + ", Appt: " + ad;
    }
}

class Doctor {
    private String n;
    private String spec;

    Doctor(String n, String spec) {
        this.n = n;
        this.spec = spec;
    }

    public void info() {
        System.out.println("Dr. " + n + " [" + spec + "]");
    }
}

class Bill implements Payable {
    private double cf; // consultation fee
    private double mc; // medicine cost
    private double disc;

    Bill(double cf, double mc, double disc) {
        this.cf = cf;
        this.mc = mc;
        this.disc = disc;
    }

    @Override
    public double calcPay() {
        return (cf + mc) - disc;
    }
}

public class Scenario1_Hospital {
    public static void main(String[] args) {
        Patient p1 = new InPatient("Ravi", 45, "Heart", 101);
        Patient p2 = new OutPatient("Ankita", 30, "Checkup", "23-09-25");

        Doctor d1 = new Doctor("Sharma", "Cardio");
        Bill b1 = new Bill(500, 1500, 200);

        System.out.println(p1.getSummary());
        System.out.println(p2.getSummary());

        d1.info();
        System.out.println("Bill: ₹" + b1.calcPay());

        if (p1 instanceof Patient) {
            System.out.println("p1 is a valid patient.");
        }
    }
}
