package org.example.presenter;

import org.example.model.TextFile;
import org.example.model.TextService;
import org.example.view.SwingMainWindowView;

import java.util.Optional;

public class MainWindowPresenter implements Presenter {
    private final SwingMainWindowView view;
    private final TextService service = new TextService();

    public MainWindowPresenter(SwingMainWindowView mainWindowView) {
        this.view = mainWindowView;
    }

    public void openFile(String path) {
        final Optional<TextFile> textFile = service.readFromPath(path);
        if(textFile.isPresent()){
            view.setText(textFile.get().getText());
        }
    }

    public void saveTextToFile(String path, String text) {
        service.saveTextToFile(path, text);
    }
}
