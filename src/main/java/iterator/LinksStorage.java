package iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class LinksStorage implements Iterable<Element> {
    private final Elements urls;

    public LinksStorage(URL url) throws IOException {
        var doc = Jsoup.connect(url.toString()).get();
        urls = doc.select("a");
    }

    @Override
    public Iterator<Element> iterator() {
        return urls.stream().iterator();
    }
}
