/**
 * @author Ihan Lelwala
 */
public class MoneyTransfer {

    private BankAccount transferrer;

    private BankAccount recipient;

    private double amount;

    /**
     * @param transferrer
     * @param recipient
     * @param amount
     */
    public void MoneyTransfer(BankAccount transferrer, BankAccount recipient, double amount) {
        // TODO implement here
    }

    /**
     * @return
     */
    public BankAccount getTransferrer() {
        // TODO implement here
        return this.transferrer;
    }

    /**
     * @return
     */
    public BankAccount getRecipient() {
        // TODO implement here
        return this.recipient;
    }

    /**
     * @return
     */
    public double getAmount() {
        // TODO implement here
        return this.amount;
    }

    /**
     * @return
     */
    public void process() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void rollback() {
        // TODO implement here
    }

}