import java.io.Serializable;

public class BankAccount implements Serializable {

    public int accountNumber;
    public double accountBalance;
    public String customerName;
    public char[] password;
    public double interestRate;
    public double autoDeposit;
    public double autoWithdraw;


    public BankAccount(int accountNumber, double accountBalance, String customerName,
                       char[] password, double interestRate, double autoDeposit, double autoWithdraw) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.password = password;
        this.interestRate = interestRate;
        this.autoDeposit = autoDeposit;
        this.autoWithdraw = autoWithdraw;
    }

}