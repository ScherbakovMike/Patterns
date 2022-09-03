package iterator;

import java.io.IOException;
import java.net.URL;

public class IteratorSolution {
    public static void main(String[] args) throws IOException {
        var iterator = new LinksStorage(new URL("https://mikescherbakov.ru")).iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().attr("href"));
        }
    }
}
