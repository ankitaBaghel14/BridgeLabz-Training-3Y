class BankAccount {
    static String bankName = "SBI";
    final int accountNumber;
    String holderName;
    double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account No: " + accountNumber);
            System.out.println("Holder: " + holderName);
            System.out.println("Balance: " + balance);
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(101, "Ankita", 5000);
        BankAccount acc2 = new BankAccount(102, "Rahul", 7000);

        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();
    }
}
