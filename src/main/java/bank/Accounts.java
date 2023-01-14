package bank;

import database.AddRecords;
import objects.Account;
import objects.BankTransactions;
import objects.CheckingAccount;
import objects.SavingsAccount;

import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

public class Accounts {

    private static final Random randNumber = new Random(System.currentTimeMillis());
    private long millis=System.currentTimeMillis();
    private Date date=new Date(millis);
    private  Account account=null;

    private static BankTransactions bank = new BankTransactions();
    public static Account createAccount(Scanner keyboard) {


        System.out.printf("Enter Name: ");
        String name = keyboard.next();
        int accountNumberChecking=Math.abs((1 + randNumber.nextInt(2)) * (int)Math.pow(10,9) + randNumber.nextInt((int)Math.pow(10,9)));
        int accountNumberSavings=Math.abs(accountNumberChecking+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));


        Account checkingAccount = new CheckingAccount(name, Integer.toString(accountNumberChecking), bank.getCheckingFee());
        Account savingsAccount = new SavingsAccount(name, Integer.toString(accountNumberSavings), bank.getInterestRate());

        String createAccount = "INSERT INTO accounts (NAME,SAVINGS,CHECKING) " +
                "VALUES('" + checkingAccount.getName() + "','" +
                savingsAccount.getAccountNumber() + "','"+
                checkingAccount.getAccountNumber()+"');";

        AddRecords.addRecord(createAccount);


        System.out.println("Your Account Numbers:\nSavings: "+savingsAccount.getAccountNumber()+
                "\nChecking: "+checkingAccount.getAccountNumber());

        return null;
    }

    public static void createSavingsAccountTransactions(SavingsAccount savingsAccount) {
        String generateSavingsBalanceTable = "INSERT INTO savings (ACCOUNT,AMOUNT,INTEREST,BALANCE) " +
                "VALUES ('" + savingsAccount.getAccountNumber() + bank.getInterestRate()+"',0,0);";
        AddRecords.addRecord(generateSavingsBalanceTable);
    }

    public static void createCheckingAccountTransactions(CheckingAccount checkingAccount) {
        String generateCheckingBalanceTable = "INSERT INTO checking (ACCOUNT,AMOUNT,BALANCE) " +
                "VALUES ('" + checkingAccount.getAccountNumber() + bank.getCheckingFee()+"',0,0);";
        AddRecords.addRecord(generateCheckingBalanceTable);
    }
}
