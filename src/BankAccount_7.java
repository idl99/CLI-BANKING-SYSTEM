import BankAccounts.BankAccount;
import BankAccounts.BankBranch;
import Exceptions.IllegalBankAccountOperation;
import java.util.Scanner;

public class BankAccount_7 {

    static BankBranch branch;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount[] arrayOfBankAccounts = new BankAccount[10];
        int count = 0; // Count variable to count the number of existing
        // Bank Account objects in arrayOfBankAccounts

        System.out.println("" +
                "===================================\n" +
                "   INTERBANKING PTY SYSTEM LOGIN\n" +
                "===================================\n");
        System.out.print("LOGIN: ");
        String user = sc.nextLine();
        System.out.print("PASSWORD: ");
        String password = sc.nextLine();

        if (!(user.equals("admin") && password.equals("123"))) {
            System.out.println("Invalid login or password. Try again later");
            System.exit(0);
        }

        System.out.println("\n" +
                "==============================\n" +
                "   DETAILS OF BANK BRANCH\n" +
                "==============================");
        System.out.print("BSB Number: ");
        int BSB_Number = sc.nextInt();
        sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Postcode: ");
        int postcode = sc.nextInt();

        branch = new BankBranch(BSB_Number, address, postcode);

        while (true) { // Program Main Loop

            System.out.println("\n"+
                    "===================================\n" +
                            "WELCOME TO INTERBANKING PTY SYSTEM\n" +
                            "===================================\n" +
                            "1 - CREATE BANK ACCOUNTS\n" +
                            "2 - MONEY TRANSFER\n" +
                            "3 - VIEW ACCOUNT BALANCE\n" +
                            "0 - EXIT\n"
            );

            System.out.print("ENTER OPTION >>> ");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 0) break;

            System.out.println();

            switch (opt) {
                case 1:
                    while (count != 10) {
                        // TODO: add functionality to add any type of BankAccounts
                        count++;
                        if (count == 10) break;
                    }

                    break; // End of switch case 1

                case 2:

                    try {

                        System.out.print("Enter transferrer's account number: ");
                        int number1 = sc.nextInt();
                        BankAccount transferrer = BankAccount.findAccount(number1,arrayOfBankAccounts);
                        if (transferrer == null) {
                            System.out.println("The transferrer's account number is invalid");
                            break;
                        }

                        System.out.print("Enter account number: ");
                        int number2 = sc.nextInt();
                        BankAccount recipient = BankAccount.findAccount(number2,arrayOfBankAccounts);
                        if (recipient == null) {
                            System.out.println("The recipient's account number is invalid");
                            break;
                        }

                        System.out.print("Enter amount to transfer: ");
                        double amount = sc.nextDouble();

                        System.out.println();

                        MoneyTransfer transfer = new MoneyTransfer(transferrer, recipient, amount);

                        transfer.process();

                    } catch (IllegalBankAccountOperation e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:

                    try {

                        System.out.println("" +
                                "===================================\n" +
                                "       VIEW ACCOUNT BALANCE\n" +
                                "===================================\n");

                        System.out.print("Enter account number: ");
                        int search = sc.nextInt();

                        BankAccount account = BankAccount.findAccount(search,arrayOfBankAccounts);

                        if (account == null)
                            throw new IllegalBankAccountOperation("No accounts exist " +
                                    "for the account number you've entered");

                        account.displayAccount();

                    } catch (IllegalBankAccountOperation e) {
                        System.out.println(e.getMessage());
                    }

                    break;

            } // End of switch case

        } // End of Program Main Loop

    } // End of main method

    public static void produceReport() {
        // TODO: method to handle generating of report
    }

} // End of class
