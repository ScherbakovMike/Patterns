package strategy;

public class DisplayBehaviorOnWebPage implements DisplayBehavior {
    @Override
    public void showQuestion() {
        System.out.println("--- The question has been displayed on the web page:");
    }
}
