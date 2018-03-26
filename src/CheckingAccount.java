import java.util.Scanner;

public class CheckingAccount extends BankAccount{

    private double monthlyFee;
    private int noOfChecksAllowed;

    protected CheckingAccount(double accountBalance, BankBranch homeBranch) throws IllegalBankAccountOperation {
        super(accountBalance, homeBranch);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter monthly fee: ");
        this.monthlyFee = sc.nextDouble();

        System.out.print("Enter number of checks/month: ");
        this.noOfChecksAllowed = sc.nextInt();
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
