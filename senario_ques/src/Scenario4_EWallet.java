interface Transferrable { void transferTo(User r, double amt); }

class Wallet {
    private double bal;
    Wallet(double b) { bal = b; }
    double getBal() { return bal; }
    void add(double amt) { bal += amt; }
    void sub(double amt) { bal -= amt; }
}

class User implements Transferrable {
    private String n;
    private Wallet w;

    User(String n, Wallet w) { this.n = n; this.w = w; }

    public void showBal() { System.out.println(n + " balance: ₹" + w.getBal()); }

    public void transferTo(User r, double amt) {
        if (w.getBal() >= amt) { w.sub(amt); r.w.add(amt); System.out.println(n + " transferred ₹" + amt + " to " + r.n); }
        else System.out.println(n + " has insufficient balance!");
    }
}

// ---------------- Main ----------------
public class Scenario4_EWallet {
    public static void main(String[] args) {
        Wallet w1 = new Wallet(5000);
        Wallet w2 = new Wallet(2000);

        User u1 = new User("Ankita", w1);
        User u2 = new User("Ravi", w2);

        u1.showBal();
        u2.showBal();

        u1.transferTo(u2, 1500);

        u1.showBal();
        u2.showBal();
    }
}
