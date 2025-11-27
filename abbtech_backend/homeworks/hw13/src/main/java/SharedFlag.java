package main.java;

public class SharedFlag {
    private boolean running;
    public synchronized boolean isRunning() {
        return running;
    }
    public synchronized void setRunning(boolean running) {
        this.running = running;
    }
}
