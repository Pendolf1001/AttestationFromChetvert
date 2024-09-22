package View.Commands;
import View.*;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выйти из программы";
    }
    public void execute(){
        consoleUI.finish();
    }
}
