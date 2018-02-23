import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount_3 {

    // Tester class for Bank Account objects

    static List<BankAccount> listOfBankAcc; // Arraylist to store BankAccount objects

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        if(new File("Accounts.txt").exists()){
            listOfBankAcc = readFromFile();
        } else {
            listOfBankAcc = new ArrayList<>();
        }

        while (true) {

            char opt;

            System.out.print(
                    "========================================\n"+
                    "WELCOME TO INTERBANKING PTY SYSTEM\n"+
                    "========================================\n"+
                    "1. CREATE NEW BANK ACCOUNT \n"+
                    "2. VIEW ACCOUNT BALANCE \n" +
                    "3. ACCOUNT MONEY TRANSFER \n" +
                    "4. DISPLAY ALL ACCOUNTS \n" +
                    "5. SHOW BANK A/C BALANCE FORECAST \n" +
                    "\nPLEASE ENTER MENU OPTION NUMBER OR 0 TO EXIT: "
            );

            opt = sc.nextLine().toCharArray()[0];

            if(opt=='0') break;

            System.out.println();

            switch (opt){

                case '1':

                    while (true) {
                        try {

                            System.out.println(
                                    "==============================\n" +
                                    "NEW BANK ACCOUNT FORM\n" +
                                    "==============================\n");

                            // =============================================
                            // Getting input for account number
                            // =============================================

                            System.out.print("Enter Account number: ");
                            int accountNumber = sc.nextInt();
                            sc.nextLine();
                            if(!(accountNumber>1000 && accountNumber<9999)){
                                throw new Exception("\nInvalid account number. Account number should be between" +
                                        " 1000 and 10000\n");
                            }
                            System.out.println("The account number is "+accountNumber+"\n");

                            // =============================================
                            // Getting input for starting account balance
                            // =============================================

                            System.out.print("Enter starting A/C balance: ");
                            double accountBalance = sc.nextDouble();
                            if(accountBalance<0) {
                                sc.nextLine();
                                throw new Exception("\nInvalid Starting A/C balance. Balance should be positive\n");
                            }
                            else {
                                sc.nextLine();
                                System.out.print("The starting account balance is $");
                                System.out.printf("%,.2f \n\n", accountBalance);
                            }

                            // =============================================
                            // Getting input for customer name
                            // =============================================

                            System.out.print("Enter Customer name: ");
                            String customerName = sc.nextLine();
                            System.out.println("The customer's name is "+customerName+"\n");

                            // =============================================
                            // Getting input for account password
                            // =============================================

                            System.out.print("Enter Account password: ");
                            char[] password = sc.next().toCharArray();
                            System.out.print("Your password is ");

                            for (int i=0; i<password.length; i++){
                                System.out.print(password[i]);
                            }

                            System.out.println("\n");

                            // =============================================
                            // Getting input for account password
                            // =============================================

                            System.out.print("Enter Account interest rate: ");
                            double interestRate = sc.nextDouble();
                            if(interestRate < 0.01 || interestRate > 15)
                                throw new Exception("Invalid Account interest rate. Rate should be between 0.01%" +
                                        " and 15%");
                            else System.out.printf("The account interest rate is %,.2f %% \n\n",interestRate);

                            // =============================================
                            // Getting input for aut deposit amount
                            // =============================================

                            System.out.print("Enter monthly auto deposit amount: ");
                            double autoDeposit = sc.nextDouble();
                            System.out.printf("The monthly auto deposit amount is %,.2f \n\n",autoDeposit);

                            // =============================================
                            // Getting input for auto withdraw amount
                            // =============================================

                            System.out.print("Enter monthly withdraw amount: ");
                            double autoWithdraw = sc.nextDouble();
                            System.out.printf("The monthly auto withdraw amount is %,.2f \n",autoWithdraw);

                            BankAccount account = new BankAccount(accountNumber, accountBalance, customerName,
                                    password, interestRate, autoDeposit, autoWithdraw);

                            listOfBankAcc.add(account); // Adding newly created BankAccount to list of existing Bank Accounts

                            writeToFile();

                            System.out.printf("\nBANK ACCOUNT NUMBER %d SUCCESSFULLY CREATED.\n\n",accountNumber);

                            sc.nextLine();

                            break;

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case '2':

                    System.out.print("Enter account number: ");
                    int input_accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter customer full name(in upper Camelcase): ");
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

                case '5':

                    BankAccount account = null;

                    try {

                        System.out.print("Enter bank account number: ");
                        int accountNumber;
                        accountNumber = sc.nextInt();
                        sc.nextLine();

                        boolean accIsExist = false;
                        for(BankAccount searchAcc: listOfBankAcc){
                            if (searchAcc.accountNumber == accountNumber) {
                                account = searchAcc;
                                accIsExist = true;
                            }
                        }

                        if(!accIsExist) {
                            throw new Exception("THE ACCOUNT NUMBER YOU ENTERED DOESN'T EXIST");
                        } else {
                            System.out.print("Enter the number of months for forecast: ");
                            int term = sc.nextInt();
                            sc.nextLine();
                            System.out.println();
                            showAccBalForecast(account, term);
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                default:
                    System.out.println("Invalid Input. Please re-enter menu option below.");
                    break;
            }
        }

    }

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

        System.out.printf("AMOUNT OF %,.2f SUCCESSFULLY TRANSFERRED FROM ACCOUNT NUMBER %d to %d.\n\n" +
                        "TRANSFERRER'S NEW ACCOUNT BALANCE IS %,.2f\n\n" +
                        "RECIPIENT'S NEW ACCOUNT BALANCE IS %,.2f",
                transactVal,paramFrom,paramToAcc,fromBankAcc.accountBalance, toBankAcc.accountBalance);

    }

    public static void showAccBalForecast(BankAccount account, int months){

        System.out.println("THE BANK ACCOUNT BALANCE FORECAST IS AS FOLLOWS: \n");

        int year = 0;

        double newBal = account.accountBalance;

        for(int i=0; i<months; i++){

            if(i%12==0){
                year++;
                System.out.printf("" +
                        "=========================\n" +
                        "YEAR NUMBER %d \n" +
                        "=========================\n" +
                        "\n",year);
            }

            double principal = newBal+account.autoDeposit-account.autoWithdraw;

            double interest = principal * ((account.interestRate/12)/100) ;

            newBal = principal + interest;

            System.out.printf("Month %d : %,.2f \n",(i%12)+1,newBal);

        }

        System.out.println();

    }

    public static void writeToFile(){

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(new File("Accounts.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listOfBankAcc);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static ArrayList<BankAccount> readFromFile(){

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<BankAccount> listOfBankAcc = null;

        try {
            fis = new FileInputStream(new File("Accounts.txt"));
            ois = new ObjectInputStream(fis);
            listOfBankAcc = (ArrayList<BankAccount>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        return listOfBankAcc;

    }

}
