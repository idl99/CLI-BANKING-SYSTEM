import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount_1_2 {

    // Tester class for Bank Account objects

    static List<BankAccount> listOfBankAcc; // Arraylist to store BankAccount objects

    public static void processMoneyTransfer (int paramFrom, int paramToAcc, double transactVal)
            throws Exception{

        if(paramFrom == paramToAcc){
            throw new Exception("Both account numbers are same");
        }

        BankAccount fromBankAcc = null;
        BankAccount toBankAcc = null;

        for(BankAccount acc : listOfBankAcc){
            if(acc.accountNumber == paramFrom) fromBankAcc = acc;
            else if(acc.accountNumber == paramToAcc) toBankAcc = acc;
        }

        if(fromBankAcc == null) {
            throw new Exception("THE ACCOUNT NUMBER FROM WHICH YOU ARE " +
                    "TRANSFERRING FUNDS DOESN'T EXIST");
        } else if(toBankAcc == null) {
            throw new Exception("THE ACCOUNT NUMBER TO YOU ARE " +
                    "TRANSFERRING FUNDS DOESN'T EXIST");
        }

        // 4.    If fromAccount balance falls below $0 after deduction
        //          then cancel transaction
        if(fromBankAcc.accountBalance - transactVal < 0) throw new Exception("Insufficient funds in account. " +
                "Account Balance is "+String.valueOf(fromBankAcc.accountBalance));

        // 5.    If fromAccount balance falls below $10
        //          then issue warning message about low a/c balance
        if(fromBankAcc.accountBalance - transactVal <= 10) System.out.println("WARNING: The balance of the account " +
                "from which you are transferring funds to has dropped below $10.\n");

        // 6.    If toAccount balance falls above $100,000
        //          then issue warning message about federal insurance
        if (toBankAcc.accountBalance + transactVal > 100000) System.out.println("WARNING: The balance of the account " +
                "to which you are transferring funds to has gone beyond the maximum federally insured value.\n");

        // 7.    Display the ending messages
        //
        // NOTE: For errors, program should terminate GRACEFULLY, for warning
        //          messages, the program continues to execute

        fromBankAcc.accountBalance -= transactVal;
        toBankAcc.accountBalance += transactVal;

        System.out.printf("AMOUNT OF %.2f SUCCESSFULLY TRANSFERRED FROM ACCOUNT NUMBER %d to %d.\n\n" +
                "TRANSFERRER'S NEW ACCOUNT BALANCE IS %.2f\n\n" +
                "RECIPIENT'S NEW ACCOUNT BALANCE IS %.2f",
                transactVal,paramFrom,paramToAcc,fromBankAcc.accountBalance, toBankAcc.accountBalance);

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        listOfBankAcc = new ArrayList<BankAccount>(){};
        listOfBankAcc.add(new BankAccount(
                9998, 85000, "Ihan Lelwala", new char[]{'i','h','a','n'}
        ));
        listOfBankAcc.add(new BankAccount(
                9999, 25000, "John Doe", new char[]{'j','o','h','n'}
        ));

        while (true) {

            char opt;

            System.out.print(
                    "========================================\n"+
                    "WELCOME TO INTERBANKING PTY SYSTEM\n"+
                    "========================================\n"+
                    "1. CREATE NEW BANK ACCOUNT \n"+
                    "2. VIEW ACCOUNT BALANCE \n" +
                    "3. ACCOUNT MONEY TRANSFER \n" +
                    "4. DISPLAY ALL ACCOUNTS \n"+
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
                    if(accountBalance<0) {
                        System.out.println("Invalid Starting A/C balance. Balance should be positive\n");
                        sc.nextLine();
                        break;
                    }
                    else{
                        sc.nextLine();
                        System.out.print("Your starting account balance is $");
                        System.out.printf("%,.2f",accountBalance);
                        System.out.println("\n");
                    }

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
                            System.out.print("Your account balance is: $");
                            System.out.printf("%,.2f",bankAccount.accountBalance);
                            System.out.println("\n");
                            isFound = true;
                        }
                    }

                    //existing BankAccount not found for input account number and name
                    if(!isFound) System.out.println("Invalid account number or customer name. Please try again.\n");

                    break;

                case '3':
                    // 1. Get account to transfer money from as fromAccount

                    System.out.print("ENTER A/C NUMBER OF ACCOUNT TO TRANSFER MONEY FROM: ");
                    int fromAccount = sc.nextInt();

                    System.out.println();

                    // 2. Get account to transfer money to as toAccount

                    System.out.print("ENTER A/C NUMBER OF ACCOUNT TO TRANSFER MONEY TO: ");
                    int toAccount = sc.nextInt();

                    System.out.println();

                    // 3. Get amount to transfer

                    System.out.print("ENTER AMOUNT OF FUNDS TO TRANSFER: ");
                    double transferVal = sc.nextDouble();
                    sc.nextLine();

                    System.out.println();

                    try {
                        processMoneyTransfer(fromAccount,toAccount,transferVal);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.exit(0);
                    } finally{
                        System.out.println();
                    }

                    break;

                case '4':

                    for(BankAccount acc: listOfBankAcc){
                        System.out.printf(
                                "Account Number: %s \n" +
                                "Account Balance: %,.2f \n" +
                                "Customer Name: %s \n" +
                                "Customer Password: %s \n\n",
                                acc.accountNumber, acc.accountBalance, acc.customerName,String.valueOf(acc.password)
                        );
                    }

                    break;

                default:
                    System.out.println("Invalid Input. Please re-enter menu option below.");
                    break;
            }
        }

    }

}
