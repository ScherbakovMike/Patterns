package adapter;

public class MagicIntegerImpl implements MagicInteger {
    private final int value;

    public MagicIntegerImpl(Integer value) {
        this.value = value;
    }

    @Override
    public MagicInteger plus(MagicInteger supplement) {
        return new MagicIntegerImpl(this.value + supplement.getValue());
    }

    @Override
    public MagicInteger minus(MagicInteger supplement) {
        return new MagicIntegerImpl(this.value - supplement.getValue());
    }

    public int getValue() {
        return value;
    }
}
