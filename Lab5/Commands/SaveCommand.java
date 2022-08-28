package Commands;

import Classes.Coordinates;
import Classes.Location;
import Classes.Person;
import Collection.CollectionManager;
import Mess.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Locale;

public class SaveCommand implements Command{

    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        File file = new File("Lab5\\data\\data.csv");
        try (FileOutputStream outputStream = new FileOutputStream(file)){
            for (Person value : collectionManager.getPerson()) {
                Long id = value.getId();
                String name = value.getName();
                Coordinates coordinates = value.getCoordinates();
                LocalDateTime creationDate = value.getCreationDate();
                String eyeColor = value.getColor().toString().toUpperCase(Locale.ROOT);
                String hairColor = value.getColorHair().toString().toUpperCase(Locale.ROOT);
                String nationality = value.getCountry().toString().toUpperCase(Locale.ROOT);
                Location location = value.getLocation();
                String message = ( id + ", " + name + ", " + coordinates.getX() + ", " + coordinates.getY() + ", " + creationDate + ", " + eyeColor + ", " + hairColor + ", " + nationality + ", " + location.getX() + ", " + location.getY() + ", " + location.getZ() + ", ");
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            Message.error("Ошибка. Отсутствует доступ к файлу." + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Message.error("Ошибка");
        }
    }

    @Override
    public String getDescription() {
        return "Сохранить коллекцию в файл";
    }
}
