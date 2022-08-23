package observer;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class JsoupUrlParser implements UrlParser {

    private final Set<Observer> observers = new HashSet<>();
    private final ConcurrentLinkedQueue<String> urlsQueue = UrlsQueue.create();

    private final URL url;

    public JsoupUrlParser(URL url) {
        this.url = url;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            Runnable task = observer::update;
            new Thread(task).start();
        });
    }

    @Override
    @SneakyThrows
    public void parse() {
        var doc = Jsoup.connect(url.toString()).get();
        var urls = doc.select("a");
        int counter = 1;
        int threshold = 5;
        for (var currentUrl : urls) {
            if (counter % threshold == 0) {
                notifyObservers();
            }
            urlsQueue.add(currentUrl.attr("href"));
            counter++;
        }
        notifyObservers();
    }
}
