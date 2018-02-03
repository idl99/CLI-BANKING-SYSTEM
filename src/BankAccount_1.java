import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankAccount_1 {

    // Tester class for Bank Account objects

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<BankAccount> listOfBankAcc = new ArrayList<>(); // Arraylist to store BankAccount objects

        while (true) {

            int opt;

            while (true) {
                try {
                    System.out.print(
                            "========================================\n"+
                            "WELCOME TO INTERBANKING PTY SYSTEM\n"+
                            "========================================\n"+
                            "1. CREATE NEW BANK ACCOUNT \n"+
                            "2. VIEW ACCOUNT BALANCE \n"+
                            "\nPLEASE ENTER MENU OPTION NUMBER OR 0 TO EXIT: "
                    );

                    opt = sc.nextInt();

                    if(opt>2){
                        System.out.println("Non-existing option. Please re-enter menu option below.\n");
                    }
                    else break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please re-enter menu option number below.\n");
                }
                sc.nextLine();
            }

            if(opt==0) break;

            System.out.println();

            switch (opt){

                case 1:
                    System.out.println(
                            "==============================\n" +
                            "NEW BANK ACCOUNT FORM\n" +
                            "==============================\n");

                    System.out.print("Enter Account number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Your account number is "+accountNumber+"\n");

                    System.out.print("Enter starting A/C balance: ");
                    double accountBalance = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Your starting account balance is "+accountBalance+"\n");

                    System.out.print("Enter Customer name: ");
                    String customerName = sc.nextLine();
                    System.out.println("Your name is "+customerName+"\n");

                    System.out.print("Enter Account password: ");
                    char[] password = sc.next().toCharArray();
                    System.out.print("Your password is ");

                    for (int i=0; i<password.length; i++){
                        System.out.print(password[i]);
                    }

                    BankAccount account = new BankAccount(
                            accountNumber, accountBalance,
                            customerName, password);

                    listOfBankAcc.add(account); // Adding newly created BankAccount to list of existing Bank Accounts

                    System.out.println("\n\nBANK ACCOUNT NUMBER "+accountNumber+" SUCCESSFULLY CREATED"+"\n");

                    break;

                case 2:
                    System.out.print("Enter your account number: ");
                    int input_accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your full name(in upper Camelcase): ");
                    String input_customerName = sc.nextLine();

                    System.out.println();

                    boolean isFound = false; // true if BankAccount exists for input account number and name

                    for(BankAccount bankAccount: listOfBankAcc){
                        // Loop to iterate through list of existing Bank Accounts
                        if(bankAccount.getAccountNumber() == input_accNo
                                && bankAccount.getCustomerName().equals(input_customerName)){
                            // Account exists
                            System.out.println("Your account balance is: "+bankAccount.getAccountBalance());
                            isFound = true;
                        }
                    }

                    //existing BankAccount not found for input account numebr and name
                    if(!isFound) System.out.println("Invalid account number or customer name. Please try again.\n");

                    break;
            }
        }

    }

}
