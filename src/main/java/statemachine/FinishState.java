package statemachine;

public class FinishState extends State {
  public FinishState(String name, Context context) {
    super(name, context);
  }

  @Override
  public void next() {
    getContext().unload();
    getContext().setCurrentState(getDefaultNextState());
    getContext().load();
  }
}
