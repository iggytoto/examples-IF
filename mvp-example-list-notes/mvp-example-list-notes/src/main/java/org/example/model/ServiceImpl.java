package org.example.model;

import org.example.presenter.dto.NoteDto;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    private final List<Note> repository = new ArrayList<>();

    @Override
    public NoteDto createNote(String note) {
        final Note model = new Note(note);
        repository.add(model);
        model.setNumber(repository.indexOf(model) + 1);
        return NoteDto.ofModel(model);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return repository.stream().map(NoteDto::ofModel).toList();
    }

    @Override
    public void deleteNoteByNumber(int number) {
        repository.remove(number - 1);
    }
}
