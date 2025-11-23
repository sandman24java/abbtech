package PizzaBakery;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationKitchen {
    public static void main(String[] args) {
        BackgroundMagic backgroundMagic = new BackgroundMagic();
        HashMap<String,Long> start_end_times = new HashMap<>();
        try(ExecutorService executor = Executors.newFixedThreadPool(5)){
            for (int i = 1; i <= 5; i++) {
                int taskNumber = i;
                executor.submit(()-> {
                    LocalTime start = LocalTime.now();
                    try {
                        backgroundMagic.preparePizza("[Order #" + taskNumber + "]");
                        backgroundMagic.bakePizza("[Order #" + taskNumber + "]");
                        backgroundMagic.deliverPizza("[Order #" + taskNumber + "]");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    LocalTime end = LocalTime.now();
                    var duration = Duration.between(start, end).getSeconds();
                    System.out.println("[Order #" + taskNumber + "] Duration: " + duration + " seconds");
                    start_end_times.put("[Order #" + taskNumber + "]", duration);
                    });
            };
        }
        System.out.println("All orders completed");
        var fastest_order = start_end_times.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue()).orElseThrow();;
        System.out.println("The fastest order is " + fastest_order.getKey() + " with duration " + fastest_order.getValue() + " seconds");
    }
}










