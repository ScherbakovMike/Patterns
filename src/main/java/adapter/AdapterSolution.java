package adapter;

public class AdapterSolution {
    public static void main(String[] args) {
        System.out.println("Examination of MagicIntegerToStringAdapter");
        MagicInteger magicInteger = new MagicIntegerImpl(10);
        MagicString magicString = new MagicIntegerToStringAdapter(magicInteger);
        System.out.printf("Value: %s,%n", magicString.getValue());
        System.out.printf("Plus 10: %s,%n", magicString.plus(new MagicStringImpl("10")).getValue());
        System.out.printf("Minus 0: %s%n", magicString.minus(new MagicStringImpl("0")).getValue());
    }
}
