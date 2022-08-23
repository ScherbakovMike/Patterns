package observer;

import lombok.SneakyThrows;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentObserver implements Observer {

    private static int counter = 1;
    private final String name = String.valueOf(counter++);

    private final ConcurrentLinkedQueue<String> urlsQueue = UrlsQueue.create();

    @Override
    @SneakyThrows
    public void update() {
        var url = urlsQueue.poll();
        if (url != null) {
            System.out.printf("Observer #%s: %s%n", name, url);
        }
    }
}
