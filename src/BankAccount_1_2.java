import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount_1_2 {

    // Tester class for Bank Account objects

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<BankAccount> listOfBankAcc = new ArrayList<>(); // Arraylist to store BankAccount objects

        while (true) {

            char opt;

            System.out.print(
                    "========================================\n"+
                    "WELCOME TO INTERBANKING PTY SYSTEM\n"+
                    "========================================\n"+
                    "1. CREATE NEW BANK ACCOUNT \n"+
                    "2. VIEW ACCOUNT BALANCE \n" +
                    "3. ACCOUNT MONEY TRANSFER"+
                    "\nPLEASE ENTER MENU OPTION NUMBER OR 0 TO EXIT: "
            );

            opt = sc.nextLine().toCharArray()[0];

            if(opt=='0') break;

            System.out.println();

            switch (opt){

                case '1':

                    System.out.println(
                            "==============================\n" +
                            "NEW BANK ACCOUNT FORM\n" +
                            "==============================\n");

                    int accountNumber = 0;

                    while (true) {
                        try {
                            System.out.print("Enter Account number: ");
                            accountNumber = sc.nextInt();
                            sc.nextLine();
                            if(!(accountNumber>1000 && accountNumber<9999)){
                                throw new IOException();
                            }
                            System.out.println();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid account number");
                        }
                    }

                    System.out.println("Your account number is "+accountNumber+"\n");

                    System.out.print("Enter starting A/C balance: ");
                    double accountBalance = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Your starting account balance is ");
                    System.out.printf("%,.2f",accountBalance);
                    System.out.println("\n");

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

                    sc.nextLine();

                    break;

                case '2':

                    System.out.print("Enter your account number: ");
                    int input_accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your full name(in upper Camelcase): ");
                    String input_customerName = sc.nextLine();

                    System.out.println();

                    boolean isFound = false; // true if BankAccount exists for input account number and name

                    for(BankAccount bankAccount: listOfBankAcc){
                        // Loop to iterate through list of existing Bank Accounts
                        if(bankAccount.accountNumber == input_accNo
                                && bankAccount.customerName.equals(input_customerName)){
                            // Account exists
                            System.out.print("Your account balance is: ");
                            System.out.printf("%,.2f",bankAccount.accountBalance);
                            System.out.println("\n");
                            isFound = true;
                        }
                    }

                    //existing BankAccount not found for input account numebr and name
                    if(!isFound) System.out.println("Invalid account number or customer name. Please try again.\n");

                    break;

                case '3':
                    // 1. Get account to transfer money from as fromAccount
                    // 2. Get account to transfer money to as toAccount
                    // 3.    If fromAccount balance falls below $0 after deduction
                    //          then cancel transaction
                    // 4.    If fromAccount balance falls below $10
                    //          then issue warning message about low a/c balance
                    // 5.    If toAccount balance falls above $100,000
                    //          then issue warning message about federal insurance
                    // 6.    Display the ending messages
                    //
                    // NOTE: For errors, program should terminate GRACEFULLY, for warning
//                  //          messages, the program continues to execute
                    break;

                default:
                    System.out.println("Invalid Input. Please re-enter menu option below.");
                    break;
            }
        }

    }

}