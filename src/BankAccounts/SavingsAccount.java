package BankAccounts;

public class SavingsAccount extends BankAccount {

    private double interestRate = 0.03;

    public SavingsAccount(double balance, BankBranch homeBranch){
        super(balance,homeBranch);
    }

    public SavingsAccount(double balance, BankBranch homeBranch, double interestRate){
        this(balance,homeBranch);
        this.interestRate = interestRate;
    }

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
        System.out.printf("Interest rate: %.2f%% ",this.interestRate*100);
    }

}
