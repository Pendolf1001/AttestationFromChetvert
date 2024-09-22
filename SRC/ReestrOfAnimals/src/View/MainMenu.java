package View;
import View.Commands.*;

import java.util.ArrayList;
import java.util.List;
public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetInfo(consoleUI));
        commandList.add(new AddAnimal(consoleUI));
        commandList.add(new GetCommandAnimal(consoleUI));
        commandList.add(new AddCommand(consoleUI));
        commandList.add(new ExecCommand(consoleUI));
        commandList.add(new FindPoBirthDate(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(Integer.toString(i + 1));
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}