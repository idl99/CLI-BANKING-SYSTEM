package BankAccounts;

public class BankAccount {

    // Class defining Bank account object construct

    /*
    * Contains the abstract attributes of any Bank Account type, which is
    *   Account Number
    *   Account Balance
    *   Details of the Branch at which the account was opened - "homeBranch"
    */

    // Instance variables for Bank Account objects
    private int accountNumber;
    private double accountBalance;
    private BankBranch homeBranch;

    /*
    * Constructor for Bank Account class
    * Accepts 2 parameters: accountBalance, and homeBranch
    * accountNumber is automatically generated at time of object creation
    * Protected in order to avoid BankAccout objects being created from outer classes
    */
    protected BankAccount(double accountBalance, BankBranch homeBranch) {
        this.accountNumber = (int)(1001 + (Math.random()*(9999-1001))+1);
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

    public static BankAccount findAccount(int search, BankAccount[] listOfBankAccounts){
        BankAccount toFind = null;

        for(BankAccount account: listOfBankAccounts){
            if(account == null) break;

            if(account.accountNumber == search){
                toFind = account;
                break;
            }
        }
        return toFind; // returns null if account not found, else
                        // returns relevant Bank Account
    }

    public void displayAccount(){
        // TODO: fix displayAccount methods of all BankAccount types
        System.out.printf("Account number: %d \n",this.accountNumber);
        System.out.printf("Account balance: %,.2f \n",this.accountBalance);
        System.out.println(homeBranch.toString());
    }

}
