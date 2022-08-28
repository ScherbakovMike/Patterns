package command;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommandSolution {
    public static void main(String[] args) throws InterruptedException {
        var params = new CommandParams(Map.of("url1", "https://mikescherbakov.ru"));
        Command command1 = commandParams -> {
            try {
                Jsoup.connect((String) commandParams.getParam("url1"))
                        .get()
                        .select("a")
                        .forEach(item -> System.out.println(item.attr("href")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        System.out.println("Executing single command:");
        command1.execute(params);

        params.setParam("url2", "http://entertoit.com");
        Command command2 = commandParams -> {
            try {
                Jsoup.connect((String) commandParams.getParam("url2"))
                        .get()
                        .select("a")
                        .forEach(item -> System.out.println(item.attr("href")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        System.out.println("Executing group of command:");
        new CommandGroup(List.of(command1, command2)).execute(params);
    }
}
