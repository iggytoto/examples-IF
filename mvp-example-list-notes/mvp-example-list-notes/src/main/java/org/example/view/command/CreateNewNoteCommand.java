package org.example.view.command;

import org.example.presenter.Presenter;

import java.util.Scanner;

public class CreateNewNoteCommand extends Command {

    public static final String NAME = "Create";
    public static final String CODE = "1";


    public CreateNewNoteCommand(Presenter view, Scanner scanner) {
        super(NAME, CODE, view, scanner);
    }

    @Override
    public void execute() {
        System.out.println("Print text of new note:");
        final String text = scanner.next();
        presenter.createNewNote(text);
    }
}
