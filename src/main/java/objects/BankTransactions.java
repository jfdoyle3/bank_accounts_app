package objects;

public class BankTransactions{

    private int interestRate=3;

    private int checkingFee=2;
    public BankTransactions() {}
    public BankTransactions(int interestRate, int checkingFee) {
        this.interestRate = interestRate;
        this.checkingFee = checkingFee;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public int getCheckingFee() {
        return checkingFee;
    }
}
