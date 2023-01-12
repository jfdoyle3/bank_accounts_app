package bank;

import database.AddRecords;
import database.CreateDatabase;
import database.ReadRecords;
import objects.Account;
import objects.CheckingAccount;
import objects.SavingsAccount;

import java.util.Random;
import java.util.Scanner;

public class AccountDriver {

    private static int fee=1;
    private static int ir=1;

    public static void accountDriver() {

        // Create Tables
        CreateDatabase.createDatabase();



        // Scanner
        Scanner keyboard = new Scanner(System.in);

        // temp 'database'
        // Account accounts[] = new Account[10];
        // int numAccounts = 0;
        int choice = 0;


        // Menu input results loop.
        do {
            choice = Console.menu(keyboard);
            System.out.println();
            switch (choice) {
                case 1: {
                    createAccount(keyboard);
                    break;
                }
//                case 2: {
//                    doDeposit(accounts, numAccounts, keyboard);
//                    break;
//                }
//                case 3: {
//                    doWithdraw(accounts, numAccounts, keyboard);
//                    break;
//                }
//                case 4: {
//                    applyInterest(accounts, numAccounts, keyboard);
//                    break;
//                }
                case 5, 23646: {
       //             displayAccount();
                    break;
                }

                case 22: {
                    searchAccountSQL(keyboard);
                    break;
                }//                    adminMenu();
                case 99: {
                    System.out.println("Good-Bye");
                    break;
                }

                default: {
                    System.out.println("Invalid Selection");
                    break;
                }
            }
            System.out.println();
        } while (choice != 99);

    }

    // Search
//    public static int searchAccount(Account accounts[], int count, int accountNumber) {
//        for (int i = 0; i < count; i++) {
//            if (accounts[i].getAccountNumber() == accountNumber) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public static int searchAccountSQL(Scanner keyboard) {
        System.out.println("Enter account name: ");
        String name=keyboard.next();
       // int accountNumber = keyboard.nextInt();
    //    String accountNumberStr = Integer.toString(accountNumber);
        String findByNameQuery = "SELECT * FROM accounts WHERE name='" + name + "'";
        ReadRecords.readRecords(findByNameQuery);
        return -1;
    }


    // Bank Functions
    public static void doDeposit(Account accounts, int count, Scanner keyboard) {
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();
        int index = searchAccount(accounts, count, accountNumber);
        if (index >= 0) {
            System.out.print("Please enter Deposit Amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber " + accountNumber);
        }
    }

//    public static void doWithdraw(Account accounts[], int count, Scanner keyboard) {
//        System.out.print("\nPlease enter account number: ");
//        int accountNumber = keyboard.nextInt();
//        int index = searchAccount(accounts, count, accountNumber);
//        if (index >= 0) {
//            System.out.print("Please enter Withdraw Amount: ");
//            double amount = keyboard.nextDouble();
//            accounts[index].withdraw(amount);
//        } else {
//            System.out.println("No account exist with AccountNumber " + accountNumber);
//        }
//    }

//    public static void applyInterest(Account accounts[], int count, Scanner keyboard) {
//        System.out.print("\nPlease enter account number: ");
//        int accountNumber = keyboard.nextInt();
//        int index = searchAccount(accounts, count, accountNumber);
//        if (index >= 0) {
//            if (accounts[index] instanceof SavingsAccount) {
//                ((SavingsAccount) accounts[index]).applyInterest();
//            }
//        } else {
//            System.out.println("No account exist with AccountNumber " + accountNumber);
//        }
//    }

    // Create Account
    public static Account createAccount(Scanner keyboard) {
        Random randNumber = new Random(System.currentTimeMillis());
        Account account=null;
        System.out.printf("Enter Name: ");
        String name = keyboard.next();
        int accountNumberChecking=Math.abs((1 + randNumber.nextInt(2)) * (int)Math.pow(10,9) + randNumber.nextInt((int)Math.pow(10,9)));
        int accountNumberSavings=Math.abs(accountNumberChecking+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));


        Account checkingAccount = new CheckingAccount(name, Integer.toString(accountNumberChecking), fee);
        Account savingsAccount = new SavingsAccount(name, Integer.toString(accountNumberSavings), ir);

        String createAccount = "INSERT INTO accounts (NAME,SAVINGS,CHECKING) " +
                                        "VALUES('" + checkingAccount.getName() + "','" +
                                                     savingsAccount.getAccountNumber() + "','"+
                                                     checkingAccount.getAccountNumber()+"');";

        AddRecords.addRecord(createAccount);

        System.out.println("Your Account Numbers:\nSavings: "+savingsAccount.getAccountNumber());
        System.out.println("Checking: "+checkingAccount.getAccountNumber());


        return null;
        }
    }

