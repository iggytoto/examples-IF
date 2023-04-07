package org.example.view;

import org.example.presenter.dto.NoteDto;

import java.util.List;

public class ViewUtilities {

    public static void listNotes(List<NoteDto> notes) {
        if (notes.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("List on notes:");
            for (NoteDto note : notes) {
                System.out.println(note.getNumber() + " : " + note.getText());
            }
        }
    }
}
