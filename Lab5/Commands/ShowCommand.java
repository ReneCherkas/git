package Commands;

import Collection.CollectionManager;
import CommandRegester.CollectionInfo;

public class ShowCommand implements Command{
    private CollectionManager collectionManager;
    private CollectionInfo collectionInfo;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        collectionInfo = new CollectionInfo();
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionInfo.show(collectionManager);
    }

    @Override
    public String getDescription() {
        return "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
