package org.example.view.command;

import org.example.presenter.Presenter;

import java.util.Scanner;

public abstract class Command {
    protected final String name;
    protected final String code;
    protected final Presenter presenter;
    protected final Scanner scanner;

    protected Command(String name, String code, Presenter p, Scanner s) {
        this.name = name;
        this.code = code;
        this.presenter = p;
        this.scanner = s;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public abstract void execute();
}
