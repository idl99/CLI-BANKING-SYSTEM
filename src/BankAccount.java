import java.util.Scanner;

public class BankAccount {
    // Class defining Bank account object construct

    // Static variables for Bank Account objects

    // Instance variables for Bank Account objects
    private int accountNumber;
    private double accountBalance;
    private BankBranch homeBranch;

    protected BankAccount(double accountBalance, BankBranch homeBranch)
            throws IllegalBankAccountOperation{

        this.accountNumber = (int)(1001 + (Math.random()*(9999-1001))+1);

        if(isAccountBalanceValid(accountBalance))
            this.accountBalance = accountBalance;
        else
            throw new IllegalBankAccountOperation("Invalid starting balance. " +
                    "Value should be in $0 - $100,000");

        this.accountBalance = accountBalance;
        this.homeBranch = homeBranch;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public BankBranch getHomeBranch() {
        return homeBranch;
    }

    public void incrementBalance(double amount){
        this.accountBalance+=amount;
    }

    public void decrementBalance(double amount){
        this.accountBalance-=amount;
    }

    private static boolean isAccountNumberValid(int accountNumber){
        return accountNumber>1000 && accountNumber < 9999;
    }

    private static boolean isAccountBalanceValid(double accountBalance){
        return accountBalance>=0 && accountBalance<=100000;
    }

    public static BankAccount enterAccountData() throws IllegalBankAccountOperation{

        // TODO: Revise this method

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

        return new BankAccount(accountBalance,null);

    }


    public static BankAccount findAccount(BankAccount[] listOfBankAccounts)
            throws IllegalBankAccountOperation{

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bank Account number: ");
        int search = sc.nextInt();
        if(!isAccountNumberValid(search)){
            throw new IllegalBankAccountOperation("Account number should be in the range of 1001-9999");
        };

        BankAccount toFind = null;

        for(BankAccount account: listOfBankAccounts){

            if(account == null) break;

            if(account.accountNumber == search){
                toFind = account;
                break;
            }

        }

        return toFind;

    }

    public void displayAccount(){

        System.out.printf("Account number: %d \n",this.accountNumber);

        System.out.printf("Account balance: %,.2f \n",this.accountBalance);

        System.out.println(this.homeBranch.toString());

        System.out.println();

    }

}
