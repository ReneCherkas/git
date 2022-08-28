package Commands;

import Collection.CollectionManager;
import Mess.Message;

public class HeadCommand implements Command{
    private CollectionManager collectionManager;

    HeadCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        try {
            Message.info(collectionManager.getPerson().peekFirst());
        } catch (Exception e) {
            Message.error("Коллекция пуста");
        }
    }

    @Override
    public String getDescription() {
        return "вывести первый элемент коллекции";
    }
}