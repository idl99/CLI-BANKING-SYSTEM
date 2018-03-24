import java.util.Scanner;

public class BankAccount {
    // Class defining Bank account object construct

    // Instance variables for Bank Account objects
    private int accountNumber;
    private double accountBalance;

    // Static variables for Bank Account objects
    private static double interestRate = 3;

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

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            return true;
        } else return this.accountNumber == ((BankAccount) obj).accountNumber;
    }

    private static void validateAccountNumber(int accountNumber) throws
            IllegalBankAccountOperation{
        if(accountNumber<1000 || accountNumber > 9999)
            throw new IllegalBankAccountOperation("Invalid Account number. Value should be in " +
                    "1000-9999");
    }

    private static void validateAccountBalance(double accountBalance) throws
            IllegalBankAccountOperation{
        if(accountBalance<0 || accountBalance>100000)
            throw new IllegalBankAccountOperation("Invalid Account balance. Value should be in " +
                    "$0.00-$100,000.00");
    }

    public static BankAccount enterAccountData()
            throws IllegalBankAccountOperation{

        Scanner sc = new Scanner(System.in);

        int accountNumber = 0;
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        if(accountNumber == 0)
            return null;
        else
            validateAccountNumber(accountNumber);

        double accountBalance = 0.0;
        System.out.print("Enter account balance: ");
        accountBalance = sc.nextDouble();
        validateAccountBalance(accountBalance);

        return new BankAccount(accountNumber,accountBalance);

    }

    public static BankAccount findBankAccount(BankAccount[] listOfBankAccounts)
            throws IllegalBankAccountOperation{

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bank Account number: ");
        int search = sc.nextInt();
        validateAccountNumber(search);

        BankAccount toFind = null;

        for(BankAccount account: listOfBankAccounts){
            if(account.accountNumber == search){
                toFind = account;
                break;
            }
        }

        if(toFind == null){
            throw new IllegalBankAccountOperation("No Bank Accounts exist " +
                    "for the account number which you've entered");
        } else{
            return toFind;
        }

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
