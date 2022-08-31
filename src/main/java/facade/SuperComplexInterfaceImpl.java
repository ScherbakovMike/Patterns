package facade;

public class SuperComplexInterfaceImpl implements SuperComplexInterface {
    @Override
    public void turnOnSubsystem1() {
        System.out.println("Subsystem1 has been turned on.");
    }

    @Override
    public void adjustSubsystem2() {
        System.out.println("Subsystem2 has been adjusted.");
    }

    @Override
    public void turnOffSubsystem3() {
        System.out.println("Subsystem3 has been turned off.");
    }

    @Override
    public void alterSubsystem4() {
        System.out.println("Subsystem4 has been altered.");
    }
}
