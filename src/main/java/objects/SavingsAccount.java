package objects;

public class SavingsAccount extends Account{


    private double interestRate;


    public SavingsAccount(){
        super();
    }

    public SavingsAccount(String name, String accountNumber,double interestRate) {
        super(name, accountNumber);
        this.interestRate=interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest(){
        return balance*interestRate;
    }

    public void applyInterest(){
        double interest=calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n",interest);
        deposit(interest);
    }

    @Override
    public void deposit(double amount) {
        if(amount>0){
            balance+=amount;
            System.out.printf("Amount %.2f deposited%n",amount);
            System.out.printf("Current Balance is: %.2f%n",balance);
        }
        else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount>0){
            if((amount)<=balance){
                System.out.printf("Amount %.2f withdrawn from Account%n",amount);
                balance-=amount;
                System.out.printf("Current Balance is: %.2f%n",balance);
            }
        }
        else {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}
