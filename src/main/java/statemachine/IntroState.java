package statemachine;

public class IntroState extends State {
  public IntroState(String name, Context context) {
    super(name, context);
  }

  @Override
  public void next() {
    getContext().unload();
    getContext().setCurrentState(getDefaultNextState());
    getContext().load();
  }
}
