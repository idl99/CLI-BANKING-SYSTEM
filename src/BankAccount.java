import java.io.IOException;
import java.util.Scanner;

public class BankAccount {
    // Class defining Bank account object construct

    private static Scanner sc = new Scanner(System.in);

    // Instance variables for Bank Account objects
    private int accountNumber;
    private double accountBalance;

    // Static variables for Bank Account objects
    public static double interestRate = 3;

    private BankAccount(int accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static BankAccount enterAccountData() throws IOException{

        int accountNumber = 0;
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        if(accountNumber == 0)
            return null;
        else if(accountNumber<1000 || accountNumber > 9999)
            throw new IOException("Invalid Account number. Value should be in " +
                    "1000-9999");

        double accountBalance = 0.0;
        System.out.print("Enter account balance: ");
        accountBalance = sc.nextDouble();

        if(accountBalance<0 || accountBalance>100000)
            throw new IOException("Invalid Account balance. Value should be in " +
                    "$0.00-$100,000.00");

        return new BankAccount(accountNumber,accountBalance);

    }

    public void computeInterest(int years){

        System.out.printf("Account number: %d \n",this.accountNumber);

        double balance = this.accountBalance;

        for(int i=1; i<=years;i++){
            double interest = balance * BankAccount.interestRate/100;
            balance += interest;
            System.out.printf("Balance at the end of year %d = %,.2f \n",i/12,balance);
        }

    }

    public void displayAccount(){
        System.out.printf("Account number: %d \n",this.accountNumber);

        System.out.printf("Account balance: %,.2f \n",this.accountBalance);
    }

}
