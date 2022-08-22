package strategy;

public class DisplayInMobileApplication implements DisplayBehavior {
    @Override
    public void showQuestion() {
        System.out.println("--- The question has been displayed in the mobile application.");
    }
}
