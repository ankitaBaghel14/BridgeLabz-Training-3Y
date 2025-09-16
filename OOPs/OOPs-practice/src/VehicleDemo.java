class Vehicle {
    static double registrationFee = 5000;
    final String registrationNumber;
    String owner;

    Vehicle(String registrationNumber, String owner) {
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    void display() {
        if (this instanceof Vehicle) {
            System.out.println("Registration No: " + registrationNumber);
            System.out.println("Owner: " + owner);
            System.out.println("Fee: " + registrationFee);
        }
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MP-20-1234", "Ankita");
        Vehicle v2 = new Vehicle("DL-05-6789", "Rahul");

        v1.display();
        v2.display();
    }
}
