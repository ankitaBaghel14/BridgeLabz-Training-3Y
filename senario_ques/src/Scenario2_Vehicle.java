// Interface for abstraction
interface Rentable {
    double calcRent(int d);
}

// Base Vehicle class
class Vehicle {
    protected String n; // name/model
    protected String t; // type
    protected int cap;  // capacity

    Vehicle(String n, String t, int cap){ this.n=n; this.t=t; this.cap=cap; }

    public void info(){
        System.out.println("Vehicle: "+n+", Type: "+t+", Cap: "+cap);
    }
}

// Bike class
class Bike extends Vehicle implements Rentable {
    private double rate;

    Bike(String n, int cap, double rate){ super(n,"Bike",cap); this.rate=rate; }

    public double calcRent(int d){ return rate*d; }
}

// Car class
class Car extends Vehicle implements Rentable {
    private double rate;
    Car(String n, int cap, double rate){ super(n,"Car",cap); this.rate=rate; }
    public double calcRent(int d){ return rate*d*1.1; } // 10% extra for car
}

// Truck class
class Truck extends Vehicle implements Rentable {
    private double rate;
    Truck(String n, int cap, double rate){ super(n,"Truck",cap); this.rate=rate; }
    public double calcRent(int d){ return rate*d*1.2; } // 20% extra for truck
}

// Customer class
class Customer {
    private String n;
    private Vehicle v;
    private int days;

    Customer(String n, Vehicle v, int days){ this.n=n; this.v=v; this.days=days; }

    public void rentInfo(){
        v.info();
        if(v instanceof Rentable){
            System.out.println(n+" pays ₹"+((Rentable)v).calcRent(days)+" for "+days+" day(s)");
        }
    }
}

// Main class
public class Scenario2_Vehicle {
    public static void main(String[] args){
        Vehicle b1 = new Bike("Pulsar",2,500);
        Vehicle c1 = new Car("Swift",4,1000);
        Vehicle t1 = new Truck("Tata",8,3000);

        Customer cu1 = new Customer("Ravi",b1,3);
        Customer cu2 = new Customer("Ankita",c1,2);
        Customer cu3 = new Customer("Rahul",t1,1);

        cu1.rentInfo();
        System.out.println();
        cu2.rentInfo();
        System.out.println();
        cu3.rentInfo();
    }
}
