package PizzaBakery;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String,Long> start_end_times = new HashMap<>();
        BackgroundMagic backgroundMagic = new BackgroundMagic();
        Runnable process1 = () -> {
            try {
                LocalTime start = LocalTime.now();
                backgroundMagic.preparePizza("[Order #1]");
                backgroundMagic.bakePizza("[Order #1]");
                backgroundMagic.deliverPizza("[Order #1]");
                LocalTime end = LocalTime.now();
                var duration = Duration.between(start, end).getSeconds();
                System.out.println("[Order #1] Duration: " + duration + " seconds");
                start_end_times.put("[Order #1]", duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable process2 = () -> {
            try {
                LocalTime start = LocalTime.now();
                backgroundMagic.preparePizza("[Order #2]");
                backgroundMagic.bakePizza("[Order #2]");
                backgroundMagic.deliverPizza("[Order #2]");
                LocalTime end = LocalTime.now();
                var duration = Duration.between(start, end).getSeconds();
                System.out.println("[Order #2] Duration: " + duration + " seconds");
                start_end_times.put("[Order #2]", duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable process3 = () -> {
            try {
                LocalTime start = LocalTime.now();
                backgroundMagic.preparePizza("[Order #3]");
                backgroundMagic.bakePizza("[Order #3]");
                backgroundMagic.deliverPizza("[Order #3]");
                LocalTime end = LocalTime.now();
                var duration = Duration.between(start, end).getSeconds();
                System.out.println("[Order #3] Duration: " + duration + " seconds");
                start_end_times.put("[Order #3]", duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable process4 = () -> {
            try {
                LocalTime start = LocalTime.now();
                backgroundMagic.preparePizza("[Order #4]");
                backgroundMagic.bakePizza("[Order #4]");
                backgroundMagic.deliverPizza("[Order #4]");
                LocalTime end = LocalTime.now();
                var duration = Duration.between(start, end).getSeconds();
                System.out.println("[Order #4] Duration: " + duration + " seconds");
                start_end_times.put("[Order #4]", duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };
        Runnable process5 = () -> {
            try {
                LocalTime start = LocalTime.now();
                backgroundMagic.preparePizza("[Order #5]");
                backgroundMagic.bakePizza("[Order #5]");
                backgroundMagic.deliverPizza("[Order #5]");
                LocalTime end = LocalTime.now();
                var duration = Duration.between(start, end).getSeconds();
                System.out.println("[Order #5] Duration: " + duration + " seconds");
                start_end_times.put("[Order #5]", duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };
        Thread newThread = new Thread(process1);
        Thread newThread2 = new Thread(process2);
        Thread newThread3 = new Thread(process3);
        Thread newThread4 = new Thread(process4);
        Thread newThread5 = new Thread(process5);

        newThread.start();
        newThread2.start();
        newThread3.start();
        newThread4.start();
        newThread5.start();
        newThread.join();
        newThread2.join();
        newThread3.join();
        newThread4.join();
        newThread5.join();
        System.out.println("All pizzas delivered!");
        var fastest_order = start_end_times.entrySet().stream().min(Map.Entry.comparingByValue()).orElseThrow();
        System.out.println("The fastest order is " + fastest_order.getKey() + " with duration " + fastest_order.getValue() + " seconds");









    }
}
