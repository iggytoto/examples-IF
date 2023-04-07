package org.example.presenter;

import org.example.model.Service;
import org.example.model.ServiceImpl;
import org.example.presenter.dto.NoteDto;

import java.util.List;

public class PresenterImpl implements Presenter {

    private final Service service = new ServiceImpl();

    public PresenterImpl() {

    }

    @Override
    public NoteDto createNewNote(String note) {
        return service.createNote(note);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return service.getAllNotes();
    }

    @Override
    public void deleteNoteByNumber(int number) {
        service.deleteNoteByNumber(number);
    }
}
