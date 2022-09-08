package statemachine;

import java.util.Random;

public class ContentState extends State {
  public ContentState(String name, Context context) {
    super(name, context);
  }

  @Override
  public void next() {
    getContext().unload();
    getContext().setCurrentState(
            getPossibleNextStates().get(
                    new Random().nextInt(
                            getPossibleNextStates().size()
                    )
            )
    );
    getContext().load();
  }
}
