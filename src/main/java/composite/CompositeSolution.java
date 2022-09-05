package composite;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class CompositeSolution {
    public static void main(String[] args) throws IOException {
        var url = new URL("https://mikescherbakov.ru");
        var document = Jsoup.connect(url.toString()).get();
        ComponentWithText textComponent = new ComponentWithTextImpl(
                (ComponentWithText) document.parent(),
                document.normalName(),
                document.text());
        fillComponentsWithText(
                document.getAllElements(),
                textComponent
        );
        textComponent.print();
    }

    private static void fillComponentsWithText(Elements allElements, ComponentWithText textComponent) {
        allElements.forEach(item -> {
            if (item.hasText()) {
                var newItem = new ComponentWithTextImpl(textComponent, item.normalName(), item.text());
                textComponent.getChildrenWithText().add(newItem);
                fillComponentsWithText(newItem.children(), newItem);
            }
        });
    }
}
