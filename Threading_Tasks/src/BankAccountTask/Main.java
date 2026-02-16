package BankAccountTask;

public class Main {
    public static void main(String[] args) {
        // Create a shared bank account with initial balance of $100
        BankAccount account= new BankAccount(50);

        System.out.println("=================================");
        System.out.println("Starting banking operations...");
        System.out.println("=================================");

        // create threads one for deposit & other for withDraw , And the two threads doing his tasks on the same account at same time
        Thread depositerThread = new Thread(new Depositor(account));
        Thread withdrawerThread = new Thread(new Withdrawer(account));

        depositerThread.start();
        withdrawerThread.start();


    }
}
