package View.Commands;
import View.*;

public class ExecCommand extends Command{
    public ExecCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить команду животному по номеру в реестре";
    }
    public void execute(){
        consoleUI.execCommand();
    }
}
