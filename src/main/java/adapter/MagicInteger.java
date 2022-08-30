package adapter;

public interface MagicInteger {
    MagicInteger plus(MagicInteger supplement);
    MagicInteger minus(MagicInteger supplement);
    int getValue();
}
