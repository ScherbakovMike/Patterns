package statemachine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter @Setter
public abstract class State implements StateActions {
  private final String name;

  private List<State> possibleNextStates = new ArrayList<>();
  private State defaultNextState;
  private final Context context;

  @Override
  public void load() {
    System.out.printf("Loading %s state%n", getName());
  }

  @Override
  public void unload() {
    System.out.printf("Unloading %s state%n", getName());
  }
}
