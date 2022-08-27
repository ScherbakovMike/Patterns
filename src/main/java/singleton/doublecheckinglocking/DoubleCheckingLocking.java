package singleton.doublecheckinglocking;

public class DoubleCheckingLocking {
    private static volatile DoubleCheckingLocking instance;

    private DoubleCheckingLocking() {
        System.out.printf("%s have been created.%n", this.getClass().getSimpleName());
    }

    public static DoubleCheckingLocking getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckingLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckingLocking();
                }
            }
        }
        return instance;
    }
}
