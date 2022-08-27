package singleton;

import singleton.classicsynchronized.ClassicSynchronized;
import singleton.doublecheckinglocking.DoubleCheckingLocking;
import singleton.enumimplementation.EnumImplementation;
import singleton.staticimplementation.StaticImplementation;

public class SingletonSolution {
    public static void main(String[] args) {
        ClassicSynchronized.getInstance();
        DoubleCheckingLocking.getInstance();
        var testEnum = EnumImplementation.INSTANCE;
        StaticImplementation.getInstance();
    }
}
