import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId; this.driverName = driverName; this.ratePerKm = ratePerKm;
    }

    // Encapsulation
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public String getVehicleDetails() {
        return String.format("%s (%s) - Rs %.2f/km", vehicleId, driverName, ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLoc);
}

class Car extends Vehicle implements GPS {
    private String location = "Unknown";
    public Car(String id, String driver, double rate) { super(id, driver, rate); }
    @Override public double calculateFare(double distance) { return getRatePerKm() * distance + 50; } // base fee
    @Override public String getCurrentLocation() { return location; }
    @Override public void updateLocation(String newLoc) { location = newLoc; }
}

class Bike extends Vehicle implements GPS {
    private String location = "Unknown";
    public Bike(String id, String driver, double rate) { super(id, driver, rate); }
    @Override public double calculateFare(double distance) { return getRatePerKm() * distance; }
    @Override public String getCurrentLocation() { return location; }
    @Override public void updateLocation(String newLoc) { location = newLoc; }
}

class Auto extends Vehicle implements GPS {
    private String location = "Unknown";
    public Auto(String id, String driver, double rate) { super(id, driver, rate); }
    @Override public double calculateFare(double distance) { return getRatePerKm() * distance + 20; }
    @Override public String getCurrentLocation() { return location; }
    @Override public void updateLocation(String newLoc) { location = newLoc; }
}

public class RideHailDemo {
    public static void main(String[] args) {
        List<Vehicle> pool = Arrays.asList(
                new Car("CAR123","Siddharth",15),
                new Bike("BIK456","Neha",8),
                new Auto("AUT789","Kamal",10)
        );

        double distance = 12.5;
        for (Vehicle v : pool) {
            System.out.printf("%s -> Fare for %.1f km: %.2f%n", v.getVehicleDetails(), distance, v.calculateFare(distance));
            if (v instanceof GPS) {
                ((GPS)v).updateLocation("Downtown");
                System.out.println("  Location: " + ((GPS)v).getCurrentLocation());
            }
        }
    }
}
