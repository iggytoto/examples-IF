package org.example.presenter.dto;

import org.example.model.Note;

public class NoteDto {

    private final int number;
    private final String text;

    private NoteDto(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public static NoteDto ofModel(Note note) {
        return new NoteDto(note.getNumber(), note.getText());
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
