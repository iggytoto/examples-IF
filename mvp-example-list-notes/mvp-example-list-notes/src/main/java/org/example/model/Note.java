package org.example.model;

public class Note {
    private int number;
    private String text;

    public Note(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
