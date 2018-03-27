package BankAccounts;

public class CheckingAccount extends BankAccount{

    private double monthlyFee;
    private int noOfChecksAllowed;

    public CheckingAccount(double accountBalance, BankBranch homeBranch,
                              double monthlyFee, int noOfChecksAllowed ) {
        super(accountBalance, homeBranch);
        this.monthlyFee = monthlyFee;
        this.noOfChecksAllowed = noOfChecksAllowed;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public int getNoOfChecksAllowed() {
        return noOfChecksAllowed;
    }

    public void setNoOfChecksAllowed(int noOfChecksAllowed) {
        this.noOfChecksAllowed = noOfChecksAllowed;
    }

    @Override
    public void displayAccount() {
        System.out.println("" +
                "==============================\n" +
                "   CHECKING ACCOUNT DETAILS\n" +
                "==============================\n");
        super.displayAccount();
        System.out.printf("" +
                "Monthly fee: %,.2f\n" +
                "No of checks allowed monthly: %d\n",this.monthlyFee,this.noOfChecksAllowed);
    }

}