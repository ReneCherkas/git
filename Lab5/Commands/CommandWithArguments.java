package Commands;

public interface CommandWithArguments extends Command {
    void getArguments(String[] arguments);
}
