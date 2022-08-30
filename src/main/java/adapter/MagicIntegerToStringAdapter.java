package adapter;

public class MagicIntegerToStringAdapter implements MagicString {
    private final MagicInteger adaptee;

    public MagicIntegerToStringAdapter(MagicInteger adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public MagicString plus(MagicString supplement) {
        return new MagicStringImpl(
                String.valueOf(adaptee.plus(
                                new MagicIntegerImpl(
                                        Integer.parseInt(supplement.getValue())
                                )
                        ).getValue()
                )
        );
    }

    @Override
    public MagicString minus(MagicString supplement) {
        return new MagicStringImpl(
                String.valueOf(adaptee.minus(
                                new MagicIntegerImpl(
                                        Integer.parseInt(supplement.getValue())
                                )
                        ).getValue()
                )
        );
    }

    @Override
    public String getValue() {
        return String.valueOf(adaptee.getValue());
    }
}
