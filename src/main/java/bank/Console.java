package bank;

import java.util.Scanner;

public class Console {

    // Console
    public static int accountMenu(Scanner keyboard) {
        System.out.println("Select Account type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;

        do {
            System.out.print("Enter Choice: ");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 2);

        return choice;
    }

    public static int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw funds");
        System.out.println("4. Apply Interest");
        System.out.println("22: Search Accounts db");
        System.out.println("99. Quit");

        int choice;

        do {
            System.out.print("Enter Choice: ");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 99);

        return choice;
    }
}
