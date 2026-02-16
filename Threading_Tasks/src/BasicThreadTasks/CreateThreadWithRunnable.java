package BasicThreadTasks;

public class CreateThreadWithRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("hello from thread 2");
    }
}
