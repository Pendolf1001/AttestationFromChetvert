package View.Commands;
import View.*;

public class AddAnimal extends Command{
    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить животное в реестр";
    }
    public void execute(){
        consoleUI.addAnimal();
    }
}
