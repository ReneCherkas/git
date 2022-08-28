package Parser;

import Classes.*;
import Collection.CollectionManager;
import Mess.Message;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CSVParser {
    private static CollectionManager collectionManager;

    public  CSVParser(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public static void parser(String path) {
        try { int lineNumber = 1;
            File fileCsv = new File(path);
            Scanner file = new Scanner(fileCsv);
            while (file.hasNextLine()) {
                String[] line = file.nextLine().trim().split("\\s*[,\"]+\\s*");
                if (line.length != 11) {
                    Message.info("Коллекция не соответствует нормам" + line[0]);
                    continue;
                }
                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].replaceFirst(".+=", "");
                }
                Validation validation = new Validation();
                if (validation.validation(line, lineNumber)) {
                    Long id = Long.parseLong(line[0]);
                    String name = line[1];
                    Coordinates coordinates = new Coordinates(Float.parseFloat(line[2]), Integer.parseInt(line[3]));
                    LocalDateTime creationDate = LocalDateTime.parse(line[4]);
                    Color eyeColor = Color.valueOf(line[5]);
                    ColorHair hairColor = ColorHair.valueOf(line[6]);
                    Country nationality = Country.valueOf(line[7]);
                    Location location = new Location(Long.parseLong(line[8]), Long.parseLong(line[9]), Integer.parseInt(line[10]));
                    Person person = new Person(id, name,coordinates,creationDate, eyeColor, hairColor, nationality, location);
                    collectionManager.insert(person);
                }
                lineNumber++;
            }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
