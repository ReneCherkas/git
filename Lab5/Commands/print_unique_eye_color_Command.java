package Commands;

import Collection.CollectionManager;
import Mess.Message;

import java.util.Comparator;

public class print_unique_eye_color_Command implements Command{

    private CollectionManager collectionManager;

    print_unique_eye_color_Command(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        try {
            collectionManager.getPerson().stream().sorted(Comparator.comparingInt(o -> o.getColor().ordinal())).forEach(System.out::println);
        } catch (Exception e) {
            Message.error("Коллекция пуста");
        }
    }

    @Override
    public String getDescription() {
        return "вывести значения поля eye color всех элементов в порядке возрастания";
    }
}