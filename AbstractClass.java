package practicals;

interface Operations {
    void deposit(double amount);
    void withdraw(double amount);
}

interface Interest {
    double calculateInterest();
}

abstract class Account {
    double balance;
    Account(double balance) { this.balance = balance; }
}

class SavingsAccount extends Account implements Operations, Interest {
    SavingsAccount(double balance) { super(balance); }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
    public double calculateInterest() { return balance * 0.04; }
}

class CurrentAcccount extends Account implements Operations {
    CurrentAcccount(double balance) { super(balance); }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
}

 class Main1 {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(1000);
        sa.deposit(500);
        System.out.println("Savings Account Interest: " + sa.calculateInterest());

        CurrentAcccount ca = new CurrentAcccount(2000);
        ca.withdraw(300);
        System.out.println("Current Account Balance: " + ca.balance);
    }
}

