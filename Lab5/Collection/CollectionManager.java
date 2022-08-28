package Collection;

import Classes.*;
import Mess.Message;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayDeque;
import java.util.Locale;

public class CollectionManager {
    public ArrayDeque<Person> pers;
    private CollectionPerson collectionPerson;
    private LocalDate creationCollectionDate;


    public CollectionManager() {
        pers = new ArrayDeque<>();
        collectionPerson = new CollectionPerson();
        Path file = Paths.get("data.csv");
        try{
            BasicFileAttributes attr =
                    Files.readAttributes(file, BasicFileAttributes.class);
            creationCollectionDate = Instant.ofEpochMilli(attr.creationTime().toMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
        }
        catch (IOException e){
            creationCollectionDate = LocalDate.now();
        }
    }


    public LocalDate getCreationCollectionDate() {
        return creationCollectionDate;
    }


    public Person insert(Person person){
        long checkId = person.getId();
        for (Person ignored : getPerson())
            if (isElementInCollection(checkId)) checkId++;
        person.setId(checkId);
        pers.add(person);
        return person;
    }


    public ArrayDeque<Person> getPerson() {
        return pers;
    }

    public boolean isElementInCollection(long id) {
        if (id < 1) {
            return false;
        }
        for (Person values : this.getPerson()) {
            if (values.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return pers.size();
    }

    public void removeFirst() {
        pers.removeFirst();
    }

    public void removeHead() {
        pers.pollFirst();
    }

    public void clear() {
        pers.clear();
        collectionPerson.setId(1L);
    }

    public void updateById(long id, String field, String value) {
        switch (field) {
            case "name": {
                if (value.trim().equals(""))   throw new NullPointerException();
                getElementById(id).setName(value);
                Message.info("Поле изменено!");
                break;
            }
            case "coordinate_x": {
                if (value.trim().equals(""))  throw new NullPointerException();
                getElementById(id).getCoordinates().setX(Float.parseFloat(value));
                Message.info("Поле изменено!");
                break;
            }
            case "coordinate_y": {
                if (value.trim().equals(""))  throw new NullPointerException();
                getElementById(id).getCoordinates().setY(Integer.parseInt(value));
                Message.info("Поле изменено!");
                break;
            }

            case "hair_Color": {
                getElementById(id).setColorHair(ColorHair.valueOf(value.toUpperCase(Locale.ROOT)));
                Message.info("Поле изменено!");
                break;
            }

            case "nationality": {
                getElementById(id).setCountry(Country.valueOf(value.toUpperCase(Locale.ROOT)));
                Message.info("Поле изменено!");
                break;
            }

            case "location_x": {
                if (value.trim().equals(""))  throw new NullPointerException();
                getElementById(id).getCoordinates().setX(Long.parseLong(value));
                Message.info("Поле изменено!");
                break;
            }
            case "location_y": {
                if (value.trim().equals(""))  throw new NullPointerException();
                getElementById(id).getCoordinates().setY((int) Long.parseLong(value));
                Message.info("Поле изменено!");
                break;
            }

            case "location_z": {
                if (value.trim().equals(""))  throw new NullPointerException();
                getElementById(id).getCoordinates().setZ(Integer.parseInt(value));
                Message.info("Поле изменено!");
                break;
            }

            case "stop": {
                Message.info("Объект изменен!");
                break;
            }
            default: {
                Message.info("Значение поля введено неверно!");
                break;
            }
        }

    }

    public Person getElementById(long id) {
        if (id < 1) {
            Message.error("Введите корректный id!");
        }
        for (Person values : pers) {
            if (values.getId() == id) {
                return values;
            }
        }
        return null;
    }
}
