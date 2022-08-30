package adapter;

public interface MagicString {
    MagicString plus(MagicString supplement);
    MagicString minus(MagicString supplement);
    String getValue();
}
