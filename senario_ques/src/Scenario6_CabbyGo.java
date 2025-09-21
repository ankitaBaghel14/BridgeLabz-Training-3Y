interface IRideService { void bookRide(); void endRide(); }

class VehicleC {
    String n, t;
    int cap;
    VehicleC(String n, String t, int cap) { this.n = n; this.t = t; this.cap = cap; }
}

class Mini extends VehicleC {
    Mini(String n) { super(n,"Mini",4); }
}

class Sedan extends VehicleC {
    Sedan(String n) { super(n,"Sedan",4); }
}

class SUV extends VehicleC {
    SUV(String n) { super(n,"SUV",6); }
}

class Driver {
    String n;
    Driver(String n) { this.n = n; }
}

class Ride implements IRideService {
    VehicleC v;
    Driver d;
    Ride(VehicleC v, Driver d){ this.v=v; this.d=d; }
    public void bookRide(){ System.out.println(d.n + " booked " + v.t); }
    public void endRide(){ System.out.println(d.n + " ended ride"); }
}

// ---------------- Main ----------------
public class Scenario6_CabbyGo {
    public static void main(String[] args){
        VehicleC v1 = new Mini("Car1");
        Driver dr = new Driver("Ravi");
        Ride r = new Ride(v1, dr);
        r.bookRide();
        r.endRide();
    }
}
