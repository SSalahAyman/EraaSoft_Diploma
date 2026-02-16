package BankAccountTask;

public class Withdrawer implements Runnable{
    private BankAccount account;

    public Withdrawer(BankAccount account){
        this.account=account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withDraw(150); // Attempting to withdraw 150 each time
            try {
                Thread.sleep(1000); // wait between each withDraw 1 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
