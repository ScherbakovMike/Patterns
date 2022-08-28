package command;

@FunctionalInterface
public interface Command {
    void execute(CommandParams params) throws InterruptedException;
}
