package observer;

import lombok.SneakyThrows;

import java.net.URL;

public class ObserverSolution {
    @SneakyThrows
    public static void main(String[] args) {
        var url = new URL("http://mikescherbakov.ru");
        var parser = new JsoupUrlParser(url);
        var countOfObservers = 10;
        for (int i = 0; i < countOfObservers; i++) {
            parser.registerObserver(new ConcurrentObserver());
        }

        parser.parse();
    }
}
