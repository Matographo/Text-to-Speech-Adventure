package de.ttsa.GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import de.ttsa.ConsoleGame.Player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StartMenue implements Initializable {
    
    private FileChooser fileChooser = new FileChooser();

    private Player player;

    @FXML
    private TextArea textArea = new TextArea();

    @FXML
    private TextField textField = new TextField();



    @FXML
    void makeInput(ActionEvent event) {
        if(player != null) {
            player.makeInput(textField.getText());
            textField.clear();
        }
    }


    @FXML
    void getText(ActionEvent event) {
        File file = fileChooser.showOpenDialog(new Stage());
        if(file.exists() && file.getAbsolutePath().substring(file.getAbsolutePath().length()-5).equals(".ttsa")){
            player = new Player(file.getAbsolutePath());
            player.playGame();
            for(String s : player.getOutput()) {
                textArea.appendText(s + "\n");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setInitialDirectory(new java.io.File("."));
        textArea.setText("No file selected");
    }

}
