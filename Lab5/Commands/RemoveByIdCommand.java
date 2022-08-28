package Commands;

import Classes.Person;
import Collection.CollectionManager;
import Mess.Message;

import java.util.Scanner;

public class RemoveByIdCommand implements CommandWithArguments{
    private CollectionManager collectionManager;
    private Scanner in;
    private String[] arguments;

    RemoveByIdCommand (CollectionManager collectionManager, Scanner in) {
        this.collectionManager = collectionManager;
        this.in = in;
    }

    @Override
    public void execute() {
        try {
            if (arguments.length == 0) {
                throw new NullPointerException();
            }
            Person person1 = null;
            for (Person person : collectionManager.getPerson()) {
                if (person.getId() ==Long.parseLong(arguments[0])) {
                    person1 = person;
                }
            }
            collectionManager.getPerson().remove(person1);
        }  catch (NullPointerException e) {
            Message.error("Введите корректный аргумент");
        }
    }

    @Override
    public String getDescription() {
        return "Удалить элемент из коллекции по его id";
    }

    @Override
    public void getArguments(String[] arguments) {
        this.arguments = arguments;
    }
}
