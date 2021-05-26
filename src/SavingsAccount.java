public class SavingsAccount extends BankAccount {

    // Instance attribute for Savings Account
    // Defined as instance, to allow flexibility in varied interest rates
    // for different Savings Account instances
    private double interestRate = 0.03;

    // Non-default constructor which allows user to initialize balance and branch details
    // for a given bank account
    public SavingsAccount(double balance, BankBranch homeBranch){
        super(balance,homeBranch);
    }

    // Overloaded constructor which allows to initialize Savings Account with user defined
    // interest rate
    public SavingsAccount(double balance, BankBranch homeBranch, double interestRate){
        this(balance,homeBranch);
        this.interestRate = interestRate;
    }

    // Getters and setters
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccount() {
        System.out.println("" +
                "==============================\n" +
                "   SAVINGS ACCOUNT DETAILS\n" +
                "==============================");
        super.displayAccount();
        System.out.printf("Interest rate: %.2f%% \n",this.interestRate*100);
    }

}
