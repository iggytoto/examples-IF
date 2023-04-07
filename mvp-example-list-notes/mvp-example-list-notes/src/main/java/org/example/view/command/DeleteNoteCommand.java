package org.example.view.command;

import org.example.presenter.Presenter;
import org.example.view.ViewUtilities;

import java.util.Scanner;

public class DeleteNoteCommand extends Command {
    public static final String NAME = "Detele";
    public static final String CODE = "3";


    public DeleteNoteCommand(Presenter presenter, Scanner scanner) {
        super(NAME, CODE, presenter, scanner);
    }

    @Override
    public void execute() {
        ViewUtilities.listNotes(presenter.getAllNotes());
        System.out.println("Enter number of note to delete...");
        final int index = scanner.nextInt();
        presenter.deleteNoteByNumber(index);
    }
}
