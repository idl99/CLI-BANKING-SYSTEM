import BankAccounts.BankAccount;
import Exceptions.IllegalBankAccountOperation;

public class MoneyTransfer {

    // Instance variables
    private BankAccount transferrer;
    private BankAccount recipient;
    private double amount;

    public MoneyTransfer(BankAccount transferrer, BankAccount recipient, double amount) {
        this.transferrer = transferrer;
        this.recipient = recipient;
        this.amount = amount;
    }

    public BankAccount getTransferrer() {
        return this.transferrer;
    }

    public BankAccount getRecipient() {
        return this.recipient;
    }

    public double getAmount() {
        return this.amount;
    }

    public void process() throws IllegalBankAccountOperation {

        if(transferrer.equals(recipient)){
            throw new IllegalBankAccountOperation("Both accounts are the same");
        }

        if(transferrer.getAccountBalance() - this.amount < 0) throw new IllegalBankAccountOperation("Insufficient funds in account. " +
                "Account Balance is "+String.valueOf(transferrer.getAccountBalance()));

        transferrer.decrementBalance(amount);

        recipient.incrementBalance(amount);

        System.out.printf("AMOUNT OF %,.2f SUCCESSFULLY TRANSFERRED FROM ACCOUNT NUMBER %d to %d.\n\n" +
                        "TRANSFERRER'S NEW ACCOUNT BALANCE IS %,.2f\n\n" +
                        "RECIPIENT'S NEW ACCOUNT BALANCE IS %,.2f\n",
                amount,transferrer.getAccountNumber(),recipient.getAccountNumber(),
                transferrer.getAccountBalance(), recipient.getAccountBalance());

    }

}