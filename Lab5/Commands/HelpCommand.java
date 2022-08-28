package Commands;

import Mess.Message;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HelpCommand implements Command{
    private HashMap<String, Command> commandsWithoutArguments;
    private HashMap<String, CommandWithArguments> commandWithArguments;

    public HelpCommand(HashMap<String, Command> commandsWithoutArguments, HashMap<String, CommandWithArguments> commandWithArguments) {
        this.commandsWithoutArguments = commandsWithoutArguments;
        this.commandWithArguments = commandWithArguments;
    }

    @Override
    public void execute() {
        for (Map.Entry<String, Command> entry : commandsWithoutArguments.entrySet()) {
            Message.info(String.format("%-30s", entry.getKey()) + " " + entry.getValue().getDescription().toLowerCase(Locale.ROOT));
        }

        for (Map.Entry<String, CommandWithArguments> entry : commandWithArguments.entrySet()) {
            Message.info(String.format("%-30s", entry.getKey()) + " " + entry.getValue().getDescription().toLowerCase(Locale.ROOT));
        }
    }

    @Override
    public String getDescription() {
        return "Вывести справку по доступным командам";
    }
}
