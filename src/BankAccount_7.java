import BankAccounts.*;
import Exceptions.IllegalBankAccountOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount_7 {

    static BankBranch branch;

    public static void main(String[] args) {

        // TODO: add validations

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
                "==============================\n");
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
                            "4 - GENERATE REPORT\n" +
                            "0 - EXIT\n"
            );

            System.out.print("ENTER OPTION >>> ");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 0) break;

            System.out.println();

            switch (opt) {
                case 1:
                    while (count != 5) {

                        // TODO: support any type of accounts?

                        System.out.println("" +
                                "===================================\n" +
                                "       NEW BANK ACCOUNT FORM \n" +
                                "===================================\n");

                        System.out.print("Enter starting balance: ");
                        double balance = sc.nextDouble();

                        System.out.print("Enter monthly fee: ");
                        double monthlyFee = sc.nextDouble();

                        System.out.print("Enter numbers of checks allowed: ");
                        int noOfChecks = sc.nextInt();

                        BankAccount account = new CheckingAccount_W_Interest(balance,branch,
                                monthlyFee, noOfChecks);

                        arrayOfBankAccounts[count] = account;

                        account.displayAccount();

                        count++;
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

                        CheckingAccount_W_Interest account =
                                (CheckingAccount_W_Interest) BankAccount.findAccount(search,arrayOfBankAccounts);

                        if (account == null)
                            throw new IllegalBankAccountOperation("No accounts exist " +
                                    "for the account number you've entered");

                        account.displayAccount();

                    } catch (IllegalBankAccountOperation e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    List<BankAccount> list = new ArrayList<>();

                    System.out.print("Enter title of report: ");
                    String title = sc.nextLine();
                    System.out.println();

                    // TEST DATA
                    /*list.add(new CheckingAccount_W_Interest(2000,
                            new BankBranch(1,"Dehiwala", 10350),
                            200,10));
                    list.add(new SavingsAccount(2000,
                            new BankBranch(1,"Dehiwala", 10350)));
                    list.add(new CheckingAccount(10000,
                            new BankBranch(1,"Dehiwala", 10350),
                            200,10));
                    list.add(new CheckingAccount(10000,
                            new BankBranch(1,"Dehiwala", 10350),
                            200,10));
                    list.add(new SavingsAccount(2000,
                            new BankBranch(1,"Dehiwala", 10350)));
                    list.add(new CheckingAccount_W_Interest(2000,
                            new BankBranch(1,"Dehiwala", 10350),
                            200,10));
                    */


                    while(true){

                        System.out.print("Enter account number to be reported: ");
                        int accountNumber = sc.nextInt();
                        sc.nextLine();
                        BankAccount account = BankAccount.findAccount(accountNumber,arrayOfBankAccounts);
                        list.add(account);

                        System.out.print("Any more accounts? [Y]/[N] : ");
                        String _continue = sc.nextLine();
                        if(_continue.equalsIgnoreCase("N"))
                            break;

                    }

                    produceReport(title,list);

                    break;

            } // End of switch case

        } // End of Program Main Loop

    } // End of main method

    public static <T extends BankAccount> void produceReport(String title, List<T> accountsOfCustomer) {
        // TODO: method to handle generating of report

        System.out.printf("" +
                "===========================================================\n" +
                "          REPORT: %-50s\n" +
                "===========================================================\n\n\n",title);

        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n" +
                        "===================================================================================================================\n",
                "Account Number","Branch","Balance","Interest%","Monthly Fee","No Of Checks");

        for(BankAccount account:accountsOfCustomer){
            System.out.printf("" +
                    "%-20d%-20s%,-20.2f",
                    account.getAccountNumber(),account.getHomeBranch().getAddress(),account.getAccountBalance());

            if(account instanceof SavingsAccount){
                System.out.printf("%-20.2f",((SavingsAccount)account).getInterestRate()*100);
            } else if(account instanceof CheckingAccount_W_Interest){
                System.out.printf("%-20.2f",((CheckingAccount_W_Interest)account).getInterestRate()*100);
            } else{
                System.out.printf("%-20s","-");
            }

            if(account instanceof CheckingAccount){
                System.out.printf("%,-20.2f%-20d",((CheckingAccount)account).getMonthlyFee(),
                        ((CheckingAccount)account).getNoOfChecksAllowed());
            } else{
                System.out.printf("%-20s%-20s","-","-");
            }

            System.out.println("\n" +
                    "-------------------------------------------------------------------------------------------------------------------");

        }

        System.out.println("\n" +
                "============================== END OF REPORT ==============================\n");

    } // End of produceReport method

} // End of class
