package View.Commands;
import View.*;

public class GetCommandAnimal extends Command{
    public GetCommandAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать список команд животного по номеру в реестре";
    }
    public void execute(){
        consoleUI.getCommandAnimal();
    }
}