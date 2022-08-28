package Commands;


import Collection.CollectionManager;
import Mess.Message;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class CommandInvoker {
    Scanner in;
    private HashMap<String, Command> commandWithoutArguments;
    private HashMap<String, CommandWithArguments> commandWithArguments;
    private CollectionManager collectionManager;
    PersonFieldReader personFieldReader;

    public CommandInvoker(CollectionManager collectionManager, Scanner in, PersonFieldReader personFieldReader) {
        this.collectionManager = collectionManager;
        this.in = in;
        this.personFieldReader = personFieldReader;
        commandWithoutArguments = new HashMap<>();
        commandWithArguments = new HashMap<>();
        this.registerCommands();
    }


    private void registerCommands() {
        register("help", new HelpCommand(commandWithoutArguments, commandWithArguments));
        register("info", new InfoCommand(collectionManager));
        register("show", new ShowCommand(collectionManager));
        register("add", new AddCommand(collectionManager));
        registerWithArgument("update", new UpdateIdCommand(collectionManager, in));
        registerWithArgument("remove_by_id", new RemoveByIdCommand(collectionManager, in));
        register("clear", new ClearCommand(collectionManager));
        register("save", new SaveCommand(collectionManager));
        register("remove_head", new RemoveHeadCommand(collectionManager));
        registerWithArgument("execute_script", new Execute_Script_Command(this, in));
        register("exit", new ExitCommand());
        register("head", new HeadCommand(collectionManager));
        registerWithArgument("count_less_than_hair_color", new count_less_than_hair_color_Command(collectionManager, in));
        register("print_unique_eye_color", new print_unique_eye_color_Command(collectionManager));
        register("remove_first", new RemoveFirstCommand(collectionManager));
        register("print_field_ascending_nationality", new print_field_ascending_nationality_Command(collectionManager));
    }

    private void register(String name, Command command) {
        commandWithoutArguments.put(name, command);
    }
    private void registerWithArgument(String name, CommandWithArguments command) {
        commandWithArguments.put(name, command);
    }

    public void execute(String firstLineCommand) {
        String[] words = firstLineCommand.trim().split("\\s+");
        String[] args = Arrays.copyOfRange(words, 1, words.length);

        if (commandWithArguments.containsKey(words[0].toLowerCase(Locale.ROOT))) {
            CommandWithArguments command;
            command = commandWithArguments.get(words[0].toLowerCase(Locale.ROOT));
            command.getArguments(args);
            command.execute();
        } else if (commandWithoutArguments.containsKey(words[0].toLowerCase(Locale.ROOT))) {
            Command command;
            command = commandWithoutArguments.get(words[0].toLowerCase(Locale.ROOT));
            command.execute();
        } else {
            Message.info("Команда " + words[0] + " не распознана, введите корректную команду!");
        }

    }
}
