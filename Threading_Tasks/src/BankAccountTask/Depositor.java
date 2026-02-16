package BankAccountTask;

public class Depositor implements Runnable {
    private BankAccount account;

    public Depositor(BankAccount account){
        this.account=account;
    }

    @Override
    public void run() {
        for(int i =1;i<=5;i++){
            account.deposit(100);  // deposit 100 each time
            try {
                Thread.sleep(2000);  // wait between each deposit 2 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
