package statemachine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class Context implements StateActions {
  private State entryState;
  private State currentState;

  @Override
  public void load() {
    currentState.load();
  }

  @Override
  public void next() {
    currentState.next();
  }

  @Override
  public void unload() {
    currentState.unload();
  }
}
