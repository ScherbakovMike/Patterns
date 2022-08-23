package observer;

import java.util.concurrent.ConcurrentLinkedQueue;

public class UrlsQueue extends ConcurrentLinkedQueue<String> {
    private UrlsQueue() {
    }

    private static UrlsQueue instance;

    public static UrlsQueue create() {
        synchronized (UrlsQueue.class) {
            if (instance == null) {
                instance = new UrlsQueue();
            }
        }
        return instance;
    }
}
