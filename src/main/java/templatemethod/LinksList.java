package templatemethod;

import lombok.EqualsAndHashCode;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.AbstractList;

@EqualsAndHashCode(callSuper = true)
public class LinksList extends AbstractList<String> {

    private final Elements urls;

    public LinksList(URL url) throws IOException {
        var doc = Jsoup.connect(url.toString()).get();
        urls = doc.select("a");
    }

    @Override
    public String get(int index) {
        return urls.get(index).attr("href");
    }

    @Override
    public int size() {
        return urls.size();
    }
}
