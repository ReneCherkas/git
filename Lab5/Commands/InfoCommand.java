package Commands;

import Collection.CollectionManager;
import CommandRegester.CollectionInfo;
import Mess.Message;

public class InfoCommand implements Command{
    private CollectionManager collectionManager;

    private CollectionInfo textFormatter;


    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        textFormatter = new CollectionInfo();
    }

    @Override
    public void execute() {
        try {
            textFormatter.getInfoAboutCollection(collectionManager);
        } catch (NullPointerException ex) {
            Message.error("В коллекции нет элементов");
        }
    }

    @Override
    public String getDescription() {
        return "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
