package statemachine;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Context {
  private final String entryState;
  private State currentState;
}
