package Commands;

import Mess.Message;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Execute_Script_Command implements CommandWithArguments{
    private ArrayList<String> scripts = new ArrayList<>();
    Set<String> scriptsInProcess = new HashSet<>();
    Scanner scanner;
    CommandInvoker invoker;
    String[] arguments;

    public Execute_Script_Command(CommandInvoker invoker, Scanner scanner) {
        this.scanner = scanner;
        this.invoker = invoker;
    }


    @Override
    public void execute() {
        try {
            if (arguments.length == 0) {
            throw new NullPointerException();
            }

            String filePath = "Lab5\\data.csv\\" + arguments[0] ;
            File file = new File(filePath);
            String absolutePath = file.getAbsolutePath();

            if (scriptsInProcess.contains(absolutePath)) {
                Message.error("Данный скрипт уже выполняется.");
                Message.error("Выполнение этого скрипта в данный момент невозможно.");
                return;
            }

            scriptsInProcess.add(absolutePath);
            Scanner scanner;
            try {
                scanner = new Scanner(file);
                System.out.printf("Попытка прочитать команды из файла \"%s\":%n", file.getName());
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.printf("Команда \"%s\":%n", line);
                    invoker.execute(line);
            }
            scriptsInProcess.remove(absolutePath);
        }catch (NullPointerException | FileNotFoundException e){
            Message.error("Введите путь к скрипту");
        }
    } catch (NullPointerException e) {
            e.printStackTrace();
        }}

        @Override
    public String getDescription() {
        String s = "считать и исполнить скрипт из указанного файла";
        return s;
    }

    @Override
    public void getArguments(String[] arguments) {
        this.arguments = arguments;
    }
}
