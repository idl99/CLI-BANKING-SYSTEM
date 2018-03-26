public class CheckingAccount_w_Interest extends SavingsAccount{

    public CheckingAccount_w_Interest(double balance, BankBranch homeBranch)
            throws IllegalBankAccountOperation{
        super(balance,homeBranch,0.02);
    }

}