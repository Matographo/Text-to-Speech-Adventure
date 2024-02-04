package de.ttsa.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StartMenue implements Initializable {
    
    private FileChooser fileChooser = new FileChooser();

    private String[] gameArgs = new String[] {"-cp", "target/ttsa-1.0.jar", "de.ttsa.ConsoleGame.PlayerApp", ""};

    private ProcessDialog game;

    private ProcessDialog sprachausgabe;

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private TextField textField = new TextField();

    @FXML
    void makeInput(ActionEvent event) {
        try {
            game.input(textField.getText());
            textField.setText("");
            getOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void loadGame(ActionEvent event) {
        try {
            File file = fileChooser.showOpenDialog(new Stage());

            textField.setOnKeyPressed(e -> {
                if(e.getCode().toString().equals("ENTER")) {
                    makeInput(new ActionEvent());
                }
            });

            if(isPlayable(file)){
                sprachausgabe = new ProcessDialog("espeak", new String[]{"-v", "de"});
                sprachausgabe.start();
                gameArgs[3] = file.getAbsolutePath();
                game = new ProcessDialog("java", gameArgs);
                game.start();
                textArea.clear();
                getOutput();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setInitialDirectory(new java.io.File("."));
        textArea.setText("Here is the Game Data: \n");
    }

    private boolean isPlayable(File file) {
        return file.exists() && file.getAbsolutePath().substring(file.getAbsolutePath().length()-5).equals(".ttsa");

    }

    private void getOutput() throws InterruptedException, IOException {
        for(String s : game.output()) {
            textArea.appendText(s + "\n");
            sprachausgabe.input(s);
        }
    }

}
