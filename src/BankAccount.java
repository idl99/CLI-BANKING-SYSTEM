import java.util.Scanner;

public class BankAccount {
    // Class defining Bank account object construct

    // Static variables for Bank Account objects
    private static double interestRate = 3;

    // Instance variables for Bank Account objects
    private int accountNumber;
    private double accountBalance;

    private BankAccount(int accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    private static boolean isAccountNumberValid(int accountNumber){
        return accountNumber>1000 && accountNumber < 9999;
    }

    private static boolean isAccountBalanceValid(double accountBalance){
        return accountBalance>=0 && accountBalance<=100000;
    }

    public static BankAccount enterAccountData() throws IllegalBankAccountOperation{

        Scanner sc = new Scanner(System.in);

        int accountNumber = 0;
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        if (accountNumber == 0)
            return null;
        else if(!isAccountNumberValid(accountNumber))
            throw new IllegalBankAccountOperation("Account number should be in the range of 1001-9999");

        double accountBalance = 0.0;
        System.out.print("Enter account balance: ");
        accountBalance = sc.nextDouble();
        if(!isAccountBalanceValid(accountBalance))
            throw new IllegalBankAccountOperation("Starting account balance should be in the range of $0 - $100,000");

        return new BankAccount(accountNumber,accountBalance);

    }

    public void computeInterest(int years){

        System.out.printf("<<<<<<<<<< ACCOUNT NUMBER : %d >>>>>>>>>>\n\n",this.accountNumber);

        System.out.println("YEAR \t\t STARTING BALANCE \t\t ENDING BALANCE\n");

        double balance = this.accountBalance;

        for(int i=1; i<=years;i++){
            System.out.printf("%d  \t\t\t %,.2f \t\t\t\t",i,balance);
            double interest = balance * BankAccount.interestRate/100;
            balance += interest;
            System.out.printf(" %,.2f\n\n",balance);
        }

    }

    public void displayAccount(){

        System.out.println("<<<<<<<<<< ACCOUNT DETAILS >>>>>>>>>>\n");

        System.out.printf("Account number: %d \n",this.accountNumber);

        System.out.printf("Account balance: %,.2f \n",this.accountBalance);

        System.out.println();

    }

}
