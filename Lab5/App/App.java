package App;

import Collection.CollectionManager;
import Commands.CommandInvoker;
import Commands.PersonFieldReader;
import Mess.Message;
import Parser.CSVParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class App {
    CollectionManager collectionManager = new CollectionManager();
    CSVParser csvParser = new CSVParser(collectionManager);
    CommandInvoker commandInvoker;
    Scanner in = new Scanner(System.in);

    public void start(String path) {
        while (true) {
            Scanner in = new Scanner(System.in);
            PersonFieldReader humanBeingFieldReader = new PersonFieldReader();
            this.commandInvoker = new CommandInvoker(collectionManager, in, humanBeingFieldReader);
            try {
                File file = new File(path);
                if ( !file.isFile() || file.isDirectory()) throw new FileNotFoundException();
                csvParser.parser(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
            process();
        } catch (NoSuchElementException e) {
            Message.error("Закрыт поток ввода");
            Message.info("Завершение выполнения программы");
            System.exit(0);
        }
    }}

    public void process() {
        while (true) {
            String command = in.nextLine();
            commandInvoker.execute(command);
        }
    }
}
