package Commands;

import Collection.CollectionManager;
import Mess.Message;

public class RemoveFirstCommand implements Command {
    private CollectionManager collectionManager;

    RemoveFirstCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        try {
            if (collectionManager.getSize() <= 0){
                Message.error("Коллекция пуста");
            }else {
               Message.info("Из коллекции был удален 1 элемент.\n"+collectionManager.getPerson().peekFirst());
                collectionManager.removeFirst();}
        } catch (Exception e) {
            Message.error("Коллекция пуста");
        }
    }

    @Override
    public String getDescription() {
        return "Удалить элемент из коллекции вывести его перед этим";
    }
}