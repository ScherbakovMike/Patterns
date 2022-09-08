package statemachine;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class State {
  private final Context context;
  private final String name;
  private List<State> possibleNextStates = new ArrayList<>();
  private final State defaultNextState;

  public abstract void load();
  public abstract void unload();
}
