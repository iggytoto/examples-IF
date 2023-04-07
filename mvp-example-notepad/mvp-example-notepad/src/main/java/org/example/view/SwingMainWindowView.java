package org.example.view;

import org.example.presenter.MainWindowPresenter;
import org.example.presenter.Presenter;

import javax.swing.*;
import java.io.File;
import java.util.Optional;

public class SwingMainWindowView extends JFrame implements View {

    private final Presenter presenter = new MainWindowPresenter(this);
    private final JTextArea textArea = new JTextArea();

    public SwingMainWindowView() {
        add(textArea);
        setSize(800, 600);
        setJMenuBar(createMenu());
        new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setVisible(true);
    }

    private JMenuBar createMenu() {
        final JMenuBar menuBar = new JMenuBar();
        final JMenu menu = new JMenu("File...");
        JMenuItem menuItem;

        menuBar.add(menu);

        menuItem = new JMenuItem("Open");
        menuItem.getAccessibleContext().setAccessibleDescription("Opens a file");
        menuItem.addActionListener((event) -> {
            final Optional<String> path = showOpenFileDialog();
            path.ifPresent(p -> presenter.openFile(p));
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.getAccessibleContext().setAccessibleDescription("Saves a file");
        menuItem.addActionListener((event) -> {
            final Optional<String> path = showOpenFileDialog();
            path.ifPresent(s -> presenter.saveTextToFile(s, textArea.getText()));
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener((event) -> System.exit(0));
        menu.add(menuItem);

        return menuBar;
    }

    private Optional<String> showOpenFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return Optional.of(selectedFile.getAbsolutePath());
        }
        return Optional.empty();
    }

    @Override
    public void setText(String text) {
        textArea.setText(text);
    }
}
