import java.util.*;

class Customer {
    String name;
    ArrayList<Account> accounts = new ArrayList<>();
    Customer(String name) { this.name = name; }
    void viewBalance() {
        for (Account a : accounts) {
            System.out.println(name + " -> Account " + a.accNo + " Balance: " + a.balance);
        }
    }
}

class Account {
    int accNo;
    double balance;
    Account(int accNo, double balance) {
        this.accNo = accNo; this.balance = balance;
    }
}

class Bank {
    String name;
    ArrayList<Customer> customers = new ArrayList<>();
    Bank(String name) { this.name = name; }
    void openAccount(Customer c, int accNo, double bal) {
        Account a = new Account(accNo, bal);
        c.accounts.add(a);
        if (!customers.contains(c)) customers.add(c);
        System.out.println("Account opened for " + c.name + " in " + name);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer c1 = new Customer("Ankita");

        bank.openAccount(c1, 101, 5000);
        bank.openAccount(c1, 102, 8000);

        c1.viewBalance();
    }
}
