package ObservePattern;

class Subscriber implements Runnable {

    private final String subscriberName;
    private final NewsPublisher publisher;

    public Subscriber(String subscriberName, NewsPublisher publisher) {
        this.subscriberName = subscriberName;
        this.publisher = publisher;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String receivedNews = publisher.waitAndGetNews();
                System.out.println(subscriberName + " xəbər aldı: " + receivedNews);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}