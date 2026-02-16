package ThreadSleepAndJoin;

public class PrintNumbersThread extends Thread {
    @Override
    public void run() {
        for (int i=1;i<=5;i++){
            System.out.println("number "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
