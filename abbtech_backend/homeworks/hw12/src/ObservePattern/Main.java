package ObservePattern;

public class Main {
    public static void main(String[] args) {

        NewsPublisher publisher = new NewsPublisher();


        Subscriber subscriber1 = new Subscriber("Subscriber-1", publisher);
        Subscriber subscriber2 = new Subscriber("Subscriber-2", publisher);
        Subscriber subscriber3 = new Subscriber("Subscriber-3", publisher);


        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);
        publisher.addSubscriber(subscriber3);


        new Thread(subscriber1).start();
        new Thread(subscriber2).start();
        new Thread(subscriber3).start();


        int newsCounter = 1;
        while (true) {
            String news = "Xəbər #" + newsCounter++;
            publisher.publishNews(news);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

