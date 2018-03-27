package BankAccounts;

public class BankBranch {

    private int BSB_Number;
    private String address;
    private int postcode;

    public BankBranch(int BSB_Number, String address, int postcode) {
        this.BSB_Number = BSB_Number;
        this.address = address;
        this.postcode = postcode;
    }

    public int getBSB_Number() {
        return BSB_Number;
    }

    public void setBSB_Number(int BSB_Number) {
        this.BSB_Number = BSB_Number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" +
                "       Bank Branch Details         " +
                "\nBSB Number = " + BSB_Number +
                "\nAddress = " + address + '\'' +
                "\nPostcode = " + postcode;
    }
}
