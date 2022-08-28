package Commands;

import Classes.Person;
import Collection.CollectionManager;
import CommandRegester.CollectionInfo;
import Mess.Message;

import java.util.Scanner;

public class UpdateIdCommand implements CommandWithArguments{
    private String[] arguments;
    private CollectionManager collectionManager;
    private Scanner in;
    private CollectionInfo collectionInfo;

    public UpdateIdCommand(CollectionManager collectionManager, Scanner in) {
        this.collectionManager = collectionManager;
        this.in = in;
        collectionInfo = new CollectionInfo();
    }

    @Override
    public void execute() {
        try {
            if (arguments.length == 0) {
                throw new NullPointerException();
            }
            if (collectionManager.isElementInCollection(Long.parseLong(arguments[0]))) {
                Person person = collectionManager.getElementById(Long.parseLong(arguments[0]));
                Message.info("Введите stop, когда захотите прервать изменение элемента коллекции!");
                Message.info("Введите значения полей для элемента коллекции: ");
                String[] commandWords = new String[0];
                do {
                    try {
                        commandWords = in.nextLine().trim().split("\\s+");
                        if (commandWords.length == 1) {
                            collectionManager.updateById(Long.parseLong(arguments[0]), commandWords[0], "");
                        } else {
                            collectionManager.updateById(Long.parseLong(arguments[0]), commandWords[0], commandWords[1]);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        Message.error("Не указано поле или значение!");
                    }
                } while (!commandWords[0].equals("stop"));

            } else {
                Message.error("Элемента с данным id нет в коллекции!");
            }
        } catch (IndexOutOfBoundsException e2) {
            Message.error("Не указаны все аргументы команды!");
        } catch (NumberFormatException e3) {
            Message.error("Формат аргумента не соответствует целочисленному ");
        } catch (NullPointerException e4) {
            Message.error("Не указаны все аргументы команды!");
        }
    }

    @Override
    public String getDescription() {
        return "Обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void getArguments(String[] arguments) {
        this.arguments = arguments;
    }
}