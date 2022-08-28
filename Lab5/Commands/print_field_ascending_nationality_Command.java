package Commands;

import Collection.CollectionManager;
import Mess.Message;

import java.util.Comparator;

public class print_field_ascending_nationality_Command implements Command{

    private CollectionManager collectionManager;

    print_field_ascending_nationality_Command(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        try {
            collectionManager.getPerson().stream().sorted(Comparator.comparingInt(o -> o.getCountry().ordinal())).forEach(System.out::println);
        } catch (Exception e) {
            Message.error("Коллекция пуста");
        }
    }

    @Override
    public String getDescription() {
        return "вывести значения поля nationality всех элементов в порядке возрастания";
    }
}