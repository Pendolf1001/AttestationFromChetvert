package View.Commands;
import View.*;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать реестр";
    }
    public void execute(){
        consoleUI.getInfo();
    }
}
