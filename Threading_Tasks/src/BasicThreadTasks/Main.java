package BasicThreadTasks;

import ThreadSleepAndJoin.PrintNumbersThread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //*********************************************************** (CreateThreadWithExtend) ********************************************************************************//
        CreateThreadWithExtend thread1=new CreateThreadWithExtend();
        thread1.start();

        //*********************************************************** (CreateThreadWithRunnable) ********************************************************************************//
        CreateThreadWithRunnable r1= new CreateThreadWithRunnable();
        Thread thread2=new Thread(r1);
        thread2.start();


        //*********************************************************** (ThreadJoin) ********************************************************************************//
        PrintNumbersThread r3= new PrintNumbersThread();

    }
}