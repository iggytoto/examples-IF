package org.example.model;

public class TextFile {

    private final String path;
    private final String text;

    public TextFile(String path, String text) {
        this.path = path;
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }
}
