package BankAccounts;

public class CheckingAccount_w_Interest extends SavingsAccount{

    private final static double INTEREST_RATE = 0.02;

    public CheckingAccount_w_Interest(double balance, BankBranch homeBranch){
        super(balance,homeBranch, INTEREST_RATE);
    }

    @Override
    public void displayAccount() {
        System.out.println("" +
                "========================================\n" +
                "CHECKING ACCOUNT W/ INTEREST DETAILS" +
                "========================================");
        ((BankAccount)this).displayAccount();
        System.out.printf("Interest rate: %.2f%% ",this.INTEREST_RATE *100);

    }

}