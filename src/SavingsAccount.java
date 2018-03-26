public class SavingsAccount extends BankAccount {

    public double interestRate = 0.03;

    public SavingsAccount(double balance, BankBranch homeBranch)
                                throws IllegalBankAccountOperation{
        super(balance,homeBranch);
    }

    public SavingsAccount(double balance, BankBranch homeBranch, double interestRate)
                                throws IllegalBankAccountOperation{
        super(balance,homeBranch);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccount() {
        System.out.println("" +
                "==============================\n" +
                "   SAVINGS ACCOUNT DETAILS\n" +
                "==============================");
        System.out.printf("Interest rate: %.2f%% ",this.interestRate*100);
        super.displayAccount();
    }

}
