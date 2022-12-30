package objects;

public abstract class Account {

    private int accountNumber;
    protected double balance;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance=0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
