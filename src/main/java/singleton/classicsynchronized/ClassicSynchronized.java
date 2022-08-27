package singleton.classicsynchronized;

public class ClassicSynchronized {
    private static ClassicSynchronized instance;

    private ClassicSynchronized() {
        System.out.printf("%s have been created.%n", this.getClass().getSimpleName());
    }

    public static synchronized ClassicSynchronized getInstance() {
        if (instance == null) {
            instance = new ClassicSynchronized();
        }
        return instance;
    }
}
