package command;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CommandGroup implements Command {
    private final List<Command> commands;

    public CommandGroup(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(CommandParams params) {
        var executor = Executors.newCachedThreadPool();
        commands.forEach(command -> executor.submit(() -> {
            try {
                command.execute(params);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ignored) {
        }
    }
}
