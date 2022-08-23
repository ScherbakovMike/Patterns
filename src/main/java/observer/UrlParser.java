package observer;

public interface UrlParser {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

    void parse();
}
