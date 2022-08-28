package Commands;

import Classes.CollectionPerson;
import Collection.CollectionManager;
import Mess.Message;

public class AddCommand implements Command{

    private CollectionManager collectionManager;
    CollectionPerson collectionPerson = new CollectionPerson();

    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.insert(collectionPerson.createPerson()); Message.info("Добавлен новый персонаж в коллекцию");
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }
}