package Exceptions;

public class IllegalBankAccountOperation extends Exception {

    public IllegalBankAccountOperation(String message) {
        super(message);
    }

}