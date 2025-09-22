import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accNum, String holderName, double balance) {
        this.accountNumber = accNum;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    protected void setBalance(double balance) { this.balance = balance; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) setBalance(getBalance() + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    public abstract double calculateInterest();
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility(); // returns max eligible
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double bal) { super(acc, name, bal); }

    @Override public double calculateInterest() {
        return getBalance() * 0.04; // 4% simple example
    }

    @Override public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    @Override public double calculateLoanEligibility() {
        return getBalance() * 5; // 5x balance
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String acc, String name, double bal) { super(acc, name, bal); }

    @Override public double calculateInterest() {
        return 0; // usually no interest
    }
}

public class BankDemo {
    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
                new SavingsAccount("SB001", "Geeta", 50000),
                new CurrentAccount("CA001", "Rohan", 20000)
        );

        for (BankAccount a : accounts) {
            System.out.printf("%s - Balance: %.2f Interest: %.2f%n",
                    a.getHolderName(), a.getBalance(), a.calculateInterest());
            if (a instanceof Loanable) {
                Loanable l = (Loanable)a;
                System.out.printf("  Loan eligibility: %.2f%n", l.calculateLoanEligibility());
            }
        }
    }
}
