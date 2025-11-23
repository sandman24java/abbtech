package ObservePattern;

import java.util.ArrayList;
import java.util.List;


class NewsPublisher {

    private final List<Subscriber> subscriberList = new ArrayList<>();
    private String latestNews;
    private boolean newsAvailable = false; // флаг: есть ли новая новость

    public synchronized void addSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }


    public synchronized String waitAndGetNews() throws InterruptedException {
        while (!newsAvailable) {
            wait();
        }

        String newsToDeliver = latestNews;
        newsAvailable = false;
        notifyAll();
        return newsToDeliver;
    }

    // Publisher публикует новость
    public void publishNews(String newsText) {
        synchronized (this) {


            while (newsAvailable) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            latestNews = newsText;
            newsAvailable = true;

            System.out.println("Publisher: Yeni xəbər yayımlandı -> " + newsText);

            notifyAll();
        }
    }
}