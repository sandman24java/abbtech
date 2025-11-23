package PizzaBakery;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BackgroundMagic {

    public void preparePizza(String order) throws InterruptedException {
        synchronized (this) {
            System.out.println(order + " Starting... ");
            System.out.println(order + " Preparing pizza...");
        }
        int random_time = ThreadLocalRandom.current().nextInt(1, 4) * 1000;
        Thread.sleep(random_time);
        System.out.println(order + " Pizza prepared...");

    }
        public void bakePizza (String order) throws InterruptedException {
            synchronized (this) {
                System.out.println(order + " Baking pizza...");
            }
            int random_time = ThreadLocalRandom.current().nextInt(2, 7) * 1000;
            Thread.sleep(random_time);
            System.out.println(order + " Pizza baked!");

        }
        public void deliverPizza (String order) throws InterruptedException {
            synchronized (this) {
                System.out.println(order + " Delivering pizza...");
            }
            int random_time = ThreadLocalRandom.current().nextInt(2, 6) * 1000;
            Thread.sleep(random_time);
            System.out.println(order + " Pizza delivered!");

        }
    }
