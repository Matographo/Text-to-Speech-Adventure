package de.ttsa.Frontend.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.ttsa.AppStart;
import de.ttsa.Tools.ProcessDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StartMenu implements Initializable {
    


// --------------------------------------------- Attributes ------------------------------------------------ //



    private FileChooser fileChooser = new FileChooser();

    private String[] gameArgs       = new String[] {"-cp", "target/ttsa-1.0.jar", "de.ttsa.Logic.PlayerApp", ""};

    private ProcessDialog game;
    private ProcessDialog sprachausgabe;



// ----------------------------------------- FXML Attribute ----------------------------------------------- //



    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private TextField textField = new TextField();



// ------------------------------------------- FXML Methods ----------------------------------------------- //


    @FXML
    void startCreateMode() {
        try {
            AppStart.setRoot("CreateMode");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Adventure", "*.ta"));
            File file = fileChooser.showOpenDialog(new Stage());
            AppStart.settings.setStartDir(file.getParentFile().getAbsolutePath());

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



// ---------------------------------------------- Initializer ------------------------------------------------ //



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File start = new File(AppStart.settings.getStartDir());
        if(!start.exists()) {
            AppStart.settings.setStartDir("");
            start = new File(AppStart.settings.getStartDir());
        }
        fileChooser.setInitialDirectory(start);
        textArea.setText("Here is the Game Data: \n");
    }



// ---------------------------------------------- Methods ---------------------------------------------------- //



    private boolean isPlayable(File file) {
        return file.exists() && file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1).equals("ta");

    }

    private void getOutput() throws InterruptedException, IOException {
        for(String s : game.output()) {
            textArea.appendText(s + "\n");
            sprachausgabe.input(s);
        }
    }


    
}
