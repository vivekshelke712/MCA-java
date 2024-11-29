// Interface for operations
interface Operations {
    void deposit(double amount);

    void withdraw(double amount);

    double calculateInterest();
}

// Abstract Account class
abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// SavingsAccount implementing Operations
class SavingsAccount extends Account implements Operations {
    private static final double INTEREST_RATE = 0.04; // 4% interest rate

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " to Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings Account.");
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// CurrentAccount implementing Operations
class CurrentAccount extends Account implements Operations {
    private static final double OVERDRAFT_LIMIT = 500.0;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " to Current Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Current Account.");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit in Current Account.");
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for Current Account
    }
}

// Main class to test functionality
public class BankApplication {
    public static void main(String[] args) {
        // Create a Savings Account
        SavingsAccount savings = new SavingsAccount("SA12345", 1000);
        savings.displayDetails();
        savings.deposit(500);
        savings.withdraw(200);
        System.out.println("Interest earned: $" + savings.calculateInterest());
        savings.displayDetails();

        System.out.println();

        // Create a Current Account
        CurrentAccount current = new CurrentAccount("CA54321", 500);
        current.displayDetails();
        current.deposit(300);
        current.withdraw(1000);
        current.withdraw(200); // This should exceed the limit
        System.out.println("Interest earned: $" + current.calculateInterest());
        current.displayDetails();
    }
}
