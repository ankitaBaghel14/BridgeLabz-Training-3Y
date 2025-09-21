interface ITransaction { void deposit(double amt); void withdraw(double amt); void checkBal(); }

class Account {
    private String acc;
    protected double bal;
    Account(String acc, double bal){ this.acc=acc; this.bal=bal; }
}

class SavingsAccount extends Account {
    double rate = 5;
    SavingsAccount(String acc, double bal){ super(acc, bal);}
    void calcInterest(){ System.out.println("Interest: "+bal*rate/100); }
}

class CurrentAccount extends Account {
    CurrentAccount(String acc, double bal){ super(acc, bal); }
}

class BankTrans extends SavingsAccount implements ITransaction {
    BankTrans(String acc, double bal){ super(acc, bal);}
    public void deposit(double amt){ bal+=amt; }
    public void withdraw(double amt){ bal-=amt; }
    public void checkBal(){ System.out.println("Balance: "+bal); }
}

// ---------------- Main ----------------
public class Scenario7_MyBank{
    public static void main(String[] args){
        BankTrans b = new BankTrans("ACC101", 5000);
        b.checkBal();
        b.deposit(2000);
        b.checkBal();
        b.withdraw(1000);
        b.checkBal();
        b.calcInterest();
    }
}
