package singleton.enumimplementation;

public enum EnumImplementation {
    INSTANCE;

    EnumImplementation() {
        System.out.printf("%s have been created.%n", this.getClass().getSimpleName());
    }
}
