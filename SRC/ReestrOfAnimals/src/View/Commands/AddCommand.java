package View.Commands;
import View.*;

public class AddCommand extends Command{
    public AddCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить команду животному по номеру в реестре";
    }
    public void execute(){
        consoleUI.addCommand();
    }
}
