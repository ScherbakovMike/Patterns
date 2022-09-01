package templatemethod;

import java.io.IOException;
import java.net.URL;

public class TemplateMethodSolution {

    public static void main(String[] args) throws IOException {
        var list = new LinksList(new URL("https://mikescherbakov.ru"));
        System.out.printf("Count of URLs: %d%n", list.size());
        for (String url : list) {
            System.out.println(url);
        }
    }
}
