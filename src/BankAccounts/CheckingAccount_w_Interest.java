package BankAccounts;

public class CheckingAccount_w_Interest extends CheckingAccount{

    private final static double INTEREST_RATE = 0.02;

    public CheckingAccount_w_Interest(double balance, BankBranch homeBranch,
                                      double monthlyFee, int noOfChecksAllowed){
        super(balance,homeBranch, monthlyFee, noOfChecksAllowed);
    }

    public static double getInterestRate() {
        return INTEREST_RATE;
    }

    @Override
    public void displayAccount() {
        System.out.println("" +
                "========================================\n" +
                "CHECKING ACCOUNT W/ INTEREST DETAILS\n" +
                "========================================");
        super.displayAccount();
        System.out.printf("Interest rate: %.2f%% \n",this.INTEREST_RATE *100);

    }

}