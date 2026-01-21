
import java.util.Scanner;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to ATM");
        do {
            System.out.println("\n ATM Menu");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4 Exit.");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;

                case 2:
                    System.out.println("Enter deposit amount: ");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter the withdrawal amount: ");
                    int WithdrawAmount = sc.nextInt();
                    account.Withdraw(WithdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000);
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
