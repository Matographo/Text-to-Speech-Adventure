package de.ttsa.Frontend.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import de.ttsa.AppStart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class CreateMode {

    private File projectFolder;

    private DirectoryChooser directoryChooser = new DirectoryChooser();

    @FXML
    private TextArea codeArea;

    @FXML
    private VBox projectContent;

    @FXML
    void startPlayMode(ActionEvent event) {
        try {
            AppStart.setRoot("StartMenu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void startCreateMode(ActionEvent event) {

    }

    @FXML
    void chooseExistingProject() {
        projectFolder = directoryChooser.showDialog(new Stage());
        System.out.println(projectFolder.getAbsolutePath());
        fillVBox();
    }

    private void fillVBox() {
        if(projectContent != null) projectContent.getChildren().clear();
        for (File file : projectFolder.listFiles()) {
            Button button = new Button(file.getName());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    codeArea.setText(getFileContent(file));
                }
            });
            projectContent.getChildren().add(new TextArea(file.getName()));
        }
    }

    private String getFileContent(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String content = "";
            try {
                while (reader.ready()) {
                    content += reader.readLine() + "\n";
                }
                return content;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
