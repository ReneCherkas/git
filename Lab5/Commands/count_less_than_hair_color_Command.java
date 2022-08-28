package Commands;

import Classes.ColorHair;
import Collection.CollectionManager;
import Mess.Message;

import java.util.Locale;
import java.util.Scanner;

public class count_less_than_hair_color_Command implements CommandWithArguments {

    private CollectionManager collectionManager;
    private Scanner in;
    private String[] arguments;

    count_less_than_hair_color_Command(CollectionManager collectionManager, Scanner in) {
        this.collectionManager = collectionManager;
        this.in = in;
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля Hair color которых равно заданному";
    }

    @Override
    public void execute() {
        try {
            if (arguments.length == 0) {
                throw new NullPointerException();
            }
            Message.info("Количество элементов с hair color " + arguments[0].toUpperCase(Locale.ROOT) +" " +collectionManager.getPerson().stream(
            ).filter(person -> person.getColorHair() == ColorHair.valueOf(arguments[0].toUpperCase(Locale.ROOT))).count());
        }  catch (NullPointerException e) {
            Message.error("Введите корректный аргумент");
        }
        catch (IllegalArgumentException ex){
            Message.error("Такого цвета волос не существует");
        }
        catch (Exception ex){
            Message.error("Ошибка");
        }
    }


    @Override
    public void getArguments(String[] arguments) {
        this.arguments = arguments;
    }

}