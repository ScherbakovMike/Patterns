package statemachine;

import java.util.List;

public class StateMachineSolution {
  public static void main(String[] args) {
    var context = new Context();
    var state1 = new IntroState("Intro State", context);
    var state2 = new ContentState("Content State", context);
    var state3 = new FinishState("Finish State", context);

    state1.setDefaultNextState(state2);
    state2.setDefaultNextState(state3);
    state2.setPossibleNextStates(List.of(state1, state3));
    state3.setDefaultNextState(state1);

    context.setCurrentState(state1);
    context.load();
    context.next();
    context.next();
    context.next();
    context.next();
  }
}
