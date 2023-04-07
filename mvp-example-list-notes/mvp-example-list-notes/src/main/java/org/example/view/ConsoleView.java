package org.example.view;

import org.example.presenter.Presenter;
import org.example.presenter.PresenterImpl;
import org.example.view.command.Command;
import org.example.view.command.CreateNewNoteCommand;
import org.example.view.command.DeleteNoteCommand;
import org.example.view.command.ListNotesCommand;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);
    private final Presenter presenter;

    public ConsoleView() {
        this.presenter = new PresenterImpl();
    }

    public void run() {
        while (true) {
            final List<Command> commandList = getCommands();
            System.out.println("Available commands:");
            for (var c : commandList) {
                System.out.println(c.getCode() + " - " + c.getName());
            }
            System.out.println("Type command then hit enter");

            final String commandCode = scanner.next();

            final Command commandToSend = commandList.stream().filter(c -> c.getCode().equals(commandCode)).findFirst().orElseThrow();

            commandToSend.execute();
        }
    }

    private List<Command> getCommands() {
        return List.of(new CreateNewNoteCommand(presenter, scanner), new ListNotesCommand(presenter, scanner), new DeleteNoteCommand(presenter, scanner));
    }
}
