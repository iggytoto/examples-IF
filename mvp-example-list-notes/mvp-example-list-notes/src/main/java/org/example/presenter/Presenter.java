package org.example.presenter;

import org.example.presenter.dto.NoteDto;

import java.util.List;

public interface Presenter {

    NoteDto createNewNote(String note);

    List<NoteDto> getAllNotes();

    void deleteNoteByNumber(int index);
}
