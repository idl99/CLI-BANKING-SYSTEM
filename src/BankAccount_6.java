import java.util.Scanner;

public class BankAccount_6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount[] arrayOfBankAccounts = new BankAccount[10];
        int count = 0; // Count variable to count the number of existing
        // Bank Account objects in arrayOfBankAccounts

        while (true) { // Program Main Loop

            System.out.println(
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

            if(opt == 0){
                break;
            } else{
                System.out.println();
                switch (opt) {
                    case 1:
                        while (count != 10) {
                            try {

                                System.out.println("===================================\n" +
                                        "       NEW BANK ACCOUNT FORM \n" +
                                        "===================================\n");

                                BankAccount account = BankAccount.enterAccountData();

                                if(account == null){
                                    break;
                                }

                                arrayOfBankAccounts[count] = account;

                                count++;

                                System.out.println("\nBank Account successfully created. Details are as follows: \n");

                                account.displayAccount();

                            } catch (IllegalBankAccountOperation e) {
                                System.out.println(e.getMessage());
                            }

                            if (count == 10) break;

                        }

                        int term = 0;
                        while (true) {
                            System.out.print("\nEnter no. of years for which you wish to compute interest: ");
                            term = sc.nextInt();
                            if (term < 1 || term > 40) System.out.println("Invalid input. Number of years should be in 1-40");
                            else break;
                        }

                        System.out.println();

                        for (BankAccount account : arrayOfBankAccounts) {
                            if (account != null)
                                account.computeInterest(term);
                        }

                        break; // End of switch case 1

                    case 2:

                        try {

                            System.out.println("TRANSFERRER DETAILS");
                            BankAccount transferrer = BankAccount.findAccount(arrayOfBankAccounts);
                            if(transferrer == null) {
                                System.out.println("The transferrer's account number is invalid");
                                break;
                            }

                            System.out.println("RECIPIENT DETAILS");
                            BankAccount recipient = BankAccount.findAccount(arrayOfBankAccounts);
                            if(recipient == null) {
                                System.out.println("The recipient's account number is invalid");
                                break;
                            }

                            System.out.print("Enter amount to transfer: ");
                            double amount = sc.nextDouble();

                            System.out.println();

                            MoneyTransfer transfer = new MoneyTransfer(transferrer,recipient,amount);

                            transfer.process();


                        } catch (IllegalBankAccountOperation e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 3:

                        try{

                            System.out.println("" +
                                    "===================================\n" +
                                    "       VIEW ACCOUNT BALANCE\n" +
                                    "===================================\n");

                            BankAccount account = BankAccount.findAccount(arrayOfBankAccounts);

                            account.displayAccount();

                        } catch (IllegalBankAccountOperation e){
                            System.out.println("No accounts exist for the account number you've entered");
                        }

                        break;

                } // End of switch case

            } // End of else statement

        } // End of Program Main Loop

    } // End of main method

} // End of class
