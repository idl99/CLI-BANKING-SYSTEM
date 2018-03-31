public class CheckingAccountWithInterest extends CheckingAccount {

    // Class defining construct for special Checking Accounts with Interest

    // Interest Rate to be forced for all Checking Accounts with Interest
    private final static double INTEREST_RATE = 0.02;

    // Non default constructor
    public CheckingAccountWithInterest(double balance, BankBranch homeBranch,
                                       double monthlyFee, int noOfChecksAllowed){
        super(balance,homeBranch, monthlyFee, noOfChecksAllowed);
    }

    // Getter method for interest rate
    public static double getInterestRate() {
        return INTEREST_RATE;
    }

    @Override
    public void displayAccount() {
        System.out.println("\n" +
                "========================================\n" +
                "CHECKING ACCOUNT W/ INTEREST DETAILS\n" +
                "========================================");
        super.displayAccount();
        System.out.printf("" +
                "Interest rate: %.2f%% \n" +
                "\n",this.INTEREST_RATE *100);

    }

}