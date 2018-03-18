import java.io.IOException;
import java.util.Scanner;

public class BankAccount_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount[] arrayOfBankAccounts = new BankAccount[10];
        int count = 0; // Count variable to count the number of existing
                        // Bank Account objects in arrayOfBankAccounts

        while (count!=10) {

            try {
                System.out.println("===================================\n" +
                        "NEW BANK ACCOUNT FORM \n" +
                        "===================================\n");

                BankAccount account = BankAccount.enterAccountData();

                arrayOfBankAccounts[count] = account;

                count++;

                if(account == null)
                    break;
                else {
                    System.out.println("\nBank Account successfully created. Details are as follows: \n");
                    account.displayAccount();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if(count == 10) break;

        }

        int term = 0;
        while (true) {
            System.out.print("\nEnter term for which you wish to compute interest: ");
            term = sc.nextInt();
            if(term<1||term>40) System.out.println("Invalid term. Term should be in 1-40");
            else break;
        }

        System.out.println();

        for(BankAccount account: arrayOfBankAccounts){
            if(account!=null)
                account.computeInterest(term);
        }

    }

}
