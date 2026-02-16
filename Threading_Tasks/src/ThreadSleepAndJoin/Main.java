package ThreadSleepAndJoin;

public class Main {
    public static void main(String[] args) {
        //*********************************************************** (ThreadSleepAndJoin) ********************************************************************************//
        PrintNumbersThread thread1= new PrintNumbersThread();
        PrintNumbersThread thread2= new PrintNumbersThread();
        thread1.start();
        thread2.start();
        try {
        // here with using join to thread , the main thread is wait for this two threads execute first then main thread is executed
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main program finished"); // this statement is executed after thread 2 & thread 3 printing numbers
    }

}
