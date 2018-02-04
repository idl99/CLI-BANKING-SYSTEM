public class BankAccount {

    public int accountNumber;
    public double accountBalance;
    public String customerName;
    public char[] password;

    public BankAccount(int accountNumber, double accountBalance, String customerName, char[] password) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.password = password;
    }
}