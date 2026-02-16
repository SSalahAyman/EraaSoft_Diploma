package BankAccountTask;

public class BankAccount {
    private double balance;

    public BankAccount(int initialBalance){
        balance=initialBalance;
        System.out.println("Account created with initial balance: $" + balance);
    }

    public synchronized void deposit(int amount){
        balance=balance+amount;
        System.out.println("amount "+amount +" is deposited to your balance");
        notifyAll();   // Notify waiting threads that balance has increased
    }

    public synchronized void withDraw(int amount){
        // If the balance is insufficient to withDraw
        while(balance<amount){
            System.out.println("your balance is insufficient to withDraw from it");
            try {
                wait();  // Wait for deposit
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Withdraw the amount by (Sufficient balance - Amount withdrawn )
        balance=balance-amount;
        System.out.println(" withdraw: $" + amount + ", Current balance: $" + balance);
    }

    public synchronized double getBalance(){
        return balance;
    }
}
