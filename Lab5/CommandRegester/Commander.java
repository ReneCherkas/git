package CommandRegester;

import Mess.Message;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Commander {
    /**
     * method dividing string into parts of executable command
     *
     * @param NameCommand  Collection of elements
     *
     */
    public static void execute(String NameCommand) {
        Scanner sc = new Scanner(System.in);
        String line = null;
        try {
            line = sc.nextLine().toLowerCase().trim();
        } catch (NoSuchElementException ex) {
            Message.error("Завершение программы");
            System.exit(0);
        }
        if (!line.equals("")) {
            String[] lines = line.split("\\s+");
            if (lines.length > 1) {
                try {
                    String command = lines[0];
                } catch (IllegalStateException e) {
                    Message.error(e.getMessage());
                }
            } else if (lines.length == 1) {
                try {
                    String command = lines[0];
                } catch (IllegalStateException e) {
                    Message.error(e.getMessage());
                }
            } else {
                Message.error("Введены неправильные аргументы!");
            }
        }
    }
}
