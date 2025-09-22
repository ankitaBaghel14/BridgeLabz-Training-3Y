import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber; // sensitive
    public Car(String num, double rate, String policyNumber) {
        super(num, "Car", rate);
        this.policyNumber = policyNumber;
    }
    // sensitive info restricted: only getter (no public setter)
    public String getPolicyNumber() { return policyNumber; }

    @Override public double calculateRentalCost(int days) { return getRentalRate() * days + 500; } // fixed cleaning fee
    @Override public double calculateInsurance() { return 1500; }
    @Override public String getInsuranceDetails() { return "Comprehensive"; }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String num, double rate, String policyNumber) {
        super(num, "Bike", rate);
    }
    @Override public double calculateRentalCost(int days) { return getRentalRate() * days; }
    @Override public double calculateInsurance() { return 300; }
    @Override public String getInsuranceDetails() { return "Third-party"; }
}

class Truck extends Vehicle {
    public Truck(String num, double rate) { super(num, "Truck", rate); }
    @Override public double calculateRentalCost(int days) { return getRentalRate() * days * 1.5; } // heavier cost
}

public class VehicleRental {
    public static void main(String[] args) {
        List<Vehicle> fleet = Arrays.asList(
                new Car("KA01AB1234", 2500, "POL123"),
                new Bike("KA02XY9999", 500, "POL456"),
                new Truck("KA05TR0001", 4000)
        );

        for (Vehicle v : fleet) {
            double rental = v.calculateRentalCost(3);
            System.out.printf("%s %s -> Rental for 3 days: %.2f%n",
                    v.getType(), v.getVehicleNumber(), rental);
            if (v instanceof Insurable) {
                Insurable ins = (Insurable)v;
                System.out.printf("  Insurance: %.2f (%s)%n", ins.calculateInsurance(), ins.getInsuranceDetails());
            }
        }
    }
}
