package main.java;

public class Worker implements Runnable {
    private final SharedFlag my_flag;
    private int workerNumber;
    public Worker(SharedFlag my_flag, int workerNumber) {
        this.my_flag = my_flag;
        this.workerNumber = workerNumber;
    }


    @Override
    public void run() {
        while (my_flag.isRunning()) {
            try {
                Thread.sleep(2000);
                System.out.println("Worker " + workerNumber+ " is running");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
