package org.example.view.command;

import org.example.presenter.Presenter;
import org.example.presenter.dto.NoteDto;
import org.example.view.ViewUtilities;

import java.util.List;
import java.util.Scanner;

public class ListNotesCommand extends Command {

    public static final String NAME = "List";
    public static final String CODE = "2";

    public ListNotesCommand(Presenter pre, Scanner s) {
        super(NAME, CODE, pre, s);
    }

    @Override
    public void execute() {
        ViewUtilities.listNotes(presenter.getAllNotes());
    }
}
