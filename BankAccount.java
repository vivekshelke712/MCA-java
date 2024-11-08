package practicals;

class BankAccount {
    int accountNumber;
    float balance;

    public BankAccount(int accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void depositMoney(float amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". New Balance: " + balance);
    }

    public void withdrawMoney(float amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Current Balance: " + balance);
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

class SavingAccount extends BankAccount {
    public SavingAccount(int accountNumber, float balance) {
        super(accountNumber, balance);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account:");
        super.displayAccountDetails();
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(int accountNumber, float balance) {
        super(accountNumber, balance);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account:");
        super.displayAccountDetails();
    }
}

class Main {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(12345, 1000.0f);
        savingAccount.depositMoney(500.0f);
        savingAccount.withdrawMoney(300.0f);
        savingAccount.displayAccountDetails();

        CurrentAccount currentAccount = new CurrentAccount(54321, 2000.0f);
        currentAccount.depositMoney(1000.0f);
        currentAccount.withdrawMoney(2500.0f);
        currentAccount.displayAccountDetails();
    }
}
