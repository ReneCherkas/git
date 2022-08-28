package Commands;
import Mess.Message;


public class ExitCommand implements Command {

    @Override
    public void execute() {
        Message.info("Завершение работы программы!");
        System.exit(0);

    }

    @Override
    public String getDescription() {
        return "Завершить программу (без сохранения в файл)";
    }
}
