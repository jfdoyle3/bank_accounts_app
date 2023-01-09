package objects;

public abstract class Account {

    private String name;

    private String accountNumber;
    protected double balance;

    public Account() {
    }

    public Account(String name, String accountNumber) {
        this.name=name;
        this.accountNumber = accountNumber;
        balance=0;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
