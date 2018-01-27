import java.util.Scanner;

public class BankAccount_1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print(
                "========================================\n"+
                "WELCOME TO INTERBANKING PTY SYSTEM\n"+
                "========================================\n"+
                "1. CREATE NEW BANK ACCOUNT \n"+
                "2. VIEW ACCOUNT BALANCE \n"+
                "\nPLEASE ENTER THE NUMBER CORRESPONDING TO YOUR DESIRED COMMAND: "
        );

        int opt = sc.nextInt();

        System.out.println();

        switch (opt){

            case 1:
                System.out.println(
                        "==============================\n" +
                        "NEW BANK ACCOUNT FORM\n" +
                        "==============================\n");

                System.out.print("Enter Account number: ");
                int accountNumber = sc.nextInt();
                System.out.println("Your account number is "+accountNumber);

                System.out.println();

                System.out.print("Enter Customer name: ");
                String customerName = sc.next();
                sc.nextLine();
                System.out.println("Your name is "+customerName);

                System.out.println();

                System.out.print("Enter starting A/C balance: ");
                double accountBalance = sc.nextDouble();
                System.out.println("Your starting account balance is "+accountBalance);

                System.out.println();

                System.out.print("Enter Account password: ");
                char[] password = sc.next().toCharArray();
                System.out.print("Your password is ");
                for (int i=0; i<password.length; i++){
                    System.out.print(password[i]);
                }

                System.out.println("\n\nBANK ACCOUNT NUMBER "+accountNumber+" SUCCESSFULLY CREATED");

                BankAccount account = new BankAccount(
                        accountNumber, accountBalance,
                        customerName, password);
                break;

            case 2:
                break;
        }

    }

}
