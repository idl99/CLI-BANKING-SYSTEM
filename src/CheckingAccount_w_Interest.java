public class CheckingAccount_w_Interest extends SavingsAccount{

    public CheckingAccount_w_Interest(double balance, BankBranch homeBranch)
            throws IllegalBankAccountOperation{
        super(balance,homeBranch,0.02);
    }

    @Override
    public void displayAccount() {
        System.out.println("" +
                "========================================\n" +
                "CHECKING ACCOUNT W/ INTEREST DETAILS" +
                "========================================");
        ((BankAccount)this).displayAccount();
    }
}