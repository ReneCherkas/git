package CommandRegester;

import Classes.Person;
import Collection.CollectionManager;
import Mess.Message;

public class CollectionInfo {
    public void getInfoAboutCollection(CollectionManager collectionManager) {
        Message.info("Дата создания коллекции " + collectionManager.getCreationCollectionDate());
        Message.info("Количество элементов в коллекции " + collectionManager.getPerson().size());
    }

    public void show(CollectionManager collectionManager){
        if (collectionManager.getPerson().size() == 0) {
            Message.info("Коллекция пуста!");
        } else {
            for (Person values : collectionManager.getPerson()) {
                Message.info(values.toString());
            }
        }
    }
}
