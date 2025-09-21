interface Controllable { void on(); void off(); }

class Appliance {
    protected String n;
    Appliance(String n) { this.n = n; }
    void info() { System.out.println("Appliance: " + n); }
}

class Light extends Appliance implements Controllable {
    Light(String n) { super(n); }
    public void on() { System.out.println(n + " Light ON"); }
    public void off() { System.out.println(n + " Light OFF"); }
}

class Fan extends Appliance implements Controllable {
    Fan(String n) { super(n); }
    public void on() { System.out.println(n + " Fan ON"); }
    public void off() { System.out.println(n + " Fan OFF"); }
}

class AC extends Appliance implements Controllable {
    AC(String n) { super(n); }
    public void on() { System.out.println(n + " AC ON"); }
    public void off() { System.out.println(n + " AC OFF"); }
}

// ---------------- Main ----------------
public class Scenario5_SmartHome {
    public static void main(String[] args) {
        Light l = new Light("LivingRoom");
        Fan f = new Fan("BedRoom");
        AC a = new AC("Office");

        l.on(); l.off();
        f.on(); f.off();
        a.on(); a.off();
    }
}
