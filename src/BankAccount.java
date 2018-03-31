public abstract class BankAccount {

    // Abstract class that defines the abstract behavior of Bank Accounts of any type

    /*
    * Contains the abstract attributes of any Bank Account type, which is
    *   Account Number
    *   Account Balance
    *   Details of the Branch at which the account was opened - "homeBranch"
    */

    // Instance attributes for Bank Accounts
    private int accountNumber;
    private double accountBalance;
    private BankBranch homeBranch;

    /*
    * Constructor to initialize abstract Bank Account attributes
    * Accepts 2 parameters: accountBalance, and homeBranch
    * accountNumber is automatically generated at time of object creation
    */

    protected BankAccount(double accountBalance, BankBranch homeBranch) {
        this.accountNumber = (int)(1001 + (Math.random()*(9999-1001))+1);
        this.accountBalance = accountBalance;
        this.homeBranch = homeBranch;
    }

    // Getter methods for Bank account object
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public BankBranch getHomeBranch() {
        return homeBranch;
    }

    // Methods to increment balance or delete methods
    public void incrementBalance(double amount){
        this.accountBalance+=amount;
    }

    public void decrementBalance(double amount){
        this.accountBalance-=amount;
    }

    public static <T extends BankAccount> T findAccount(int search, T[] listOfBankAccounts){
        T toFind = null;
        for(T account: listOfBankAccounts){
            if(account == null) break;

            if(account.getAccountNumber() == search){
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
