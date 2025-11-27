package main.java;

import main.java.SharedFlag;
import main.java.Worker;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedFlag sharedFlag = new SharedFlag();
        sharedFlag.setRunning(true);
        Thread thread1 = new  Thread(new Worker(sharedFlag,1));
        Thread thread2 = new  Thread(new Worker(sharedFlag,2));
        Thread thread3 = new  Thread(new Worker(sharedFlag,3));

        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(10000);
        sharedFlag.setRunning(false);
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Worker is stopped");
    }
}
