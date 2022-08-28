package Commands;

import Collection.CollectionManager;
import Mess.Message;

public class ClearCommand implements Command{
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.clear();
        Message.info("Коллекция очищена!");
    }

    @Override
    public String getDescription() {
        return "Очистить коллекцию";
    }
}
