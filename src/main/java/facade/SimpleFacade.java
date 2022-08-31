package facade;

public class SimpleFacade {
    private final SuperComplexInterface instance;

    public SimpleFacade(SuperComplexInterface instance) {
        this.instance = instance;
    }

    public void makeAllPreparations() {
        instance.turnOnSubsystem1();
        instance.adjustSubsystem2();
        instance.turnOffSubsystem3();
        instance.alterSubsystem4();
    }
}
