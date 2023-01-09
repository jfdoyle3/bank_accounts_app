package objects;

public class CheckingAccount extends Account{

    private static double FEE=2.5;

    public CheckingAccount(){
        super();
    }

    public CheckingAccount(String name, String  accountNumber,double fee) {
        super(name,accountNumber);
        FEE=fee;
    }

    @Override
    public void deposit(double amount) {
        if(amount>0){
            balance+=amount;
            System.out.printf("Amount %.2f deposited%n",amount);
            balance-=FEE;
            System.out.printf("Fee %.2f Applied%n",FEE);
            System.out.printf("Current Balance is: %.2f%n",balance);
        }
        else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount>0){
            if((amount+FEE)<=balance){
                System.out.printf("Amount %.2f withdrawn from Account%n",amount);
                balance-=amount;
                balance-=FEE;
                System.out.printf("Fee %.2f Applied%n",FEE);
                System.out.printf("Current Balance is: %.2f%n",balance);
            }
        }
        else {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}
