package strategy;

public interface DisplayBehavior {
    default void showQuestion() {
        System.out.println("Display behavior is not implemented.");
    };
}
