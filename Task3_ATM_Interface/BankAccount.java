
public class BankAccount {

    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("$" + amount + "deposited successfully.");
    }

    public void Withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + "withdrawn successfully. ");

        } else {
            System.out.println("X Insufficient Balance!");

        }
    }

    public int getBalance() {
        return balance;
    }
}
