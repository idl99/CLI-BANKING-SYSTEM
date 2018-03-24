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

                } // End of switch case

            } // End of else statement

        } // End of Program Main Loop

    } // End of main method

} // End of class
