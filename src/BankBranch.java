public class BankBranch {

    int BSB_number;
    String address;
    int postcode;

    public BankBranch(int BSB_number, String address, int postcode) {
        this.BSB_number = BSB_number;
        this.address = address;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" +
                "       Bank Branch Details         " +
                "\nBSB Number = " + BSB_number +
                "\nAddress = " + address + '\'' +
                "\nPostcode = " + postcode;
    }
}
