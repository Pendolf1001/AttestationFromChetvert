package View.Commands;
import View.*;

public class FindPoBirthDate extends Command{
    public FindPoBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти животных по году рождения в реестре";
    }
    public void execute(){
        consoleUI.findPoBirthDate();
    }
}
