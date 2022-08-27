package singleton.staticimplementation;

public class StaticImplementation {
    private static StaticImplementation instance = new StaticImplementation();

    private StaticImplementation() {
        System.out.printf("%s have been created.%n", this.getClass().getSimpleName());
    }

    public static StaticImplementation getInstance() {
        return instance;
    }
}
