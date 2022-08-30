package adapter;

public class MagicStringImpl implements MagicString {
    private final String value;

    public MagicStringImpl(String value) {
        this.value = value;
    }

    @Override
    public MagicString plus(MagicString supplement) {
        return new MagicStringImpl(this.value + supplement.getValue());
    }

    @Override
    public MagicString minus(MagicString supplement) {
        if (this.value.endsWith(supplement.getValue())) {
            return new MagicStringImpl(this.value.substring(0, this.value.length() - supplement.getValue().length()));
        } else {
            return this;
        }
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
