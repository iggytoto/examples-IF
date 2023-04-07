package org.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

public class TextService {
    public Optional<TextFile> readFromPath(String path) {
        try {
            final Path pathToFile = Path.of(path);
            final List<String> allFileLines = Files.readAllLines(pathToFile);
            final String text = String.join("\n", allFileLines);
            return Optional.of(new TextFile(path, text));
        } catch (IOException e) {
            System.out.println("Failed to open file:" + path + ". Error:" + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<TextFile> saveTextToFile(String path, String text) {
        try {
            final Path pathToFile = Path.of(path);
            Files.writeString(pathToFile, text, StandardOpenOption.CREATE_NEW);
            return Optional.of(new TextFile(path, text));
        } catch (IOException e) {
            System.out.println("Failed to save file:" + path + ". Error:" + e.getMessage());
            return Optional.empty();
        }
    }
}
