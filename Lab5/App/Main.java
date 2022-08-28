package App;

import Mess.Message;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Message.info("Введите имя файла");
        try {
            File filePath = new File(args[0]);
            Message.info(filePath);
            String path = "Lab5\\data\\" + filePath;
            if (Files.exists(Paths.get(path))){
                Message.info("Начните вводить команды");
                File file = new File((path));
                    if (!file.canRead()){
                        Message.error("Недостаточно прав для чтения файла c данными.");
                        Message.info("Введите exit, чтобы завершить программу, или продолжите с пустой коллекцией.");
                    }
            }else {
                Message.error("Файл не найден. Невозможно запустить программу.");
            }
            App application = new App();
            application.start(path);
        }catch (ArrayIndexOutOfBoundsException e){
            Message.error("Не введен аргумент");
            Message.error("программа завершена");
            System.exit(0);
        }
    }
}
