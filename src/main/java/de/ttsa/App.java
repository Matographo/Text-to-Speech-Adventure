package de.ttsa;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {



// --------------------------------------------- Attributes ------------------------------------------------ //



    private static Scene scene;



// ------------------------------------------------ Main --------------------------------------------------- //



    public static void main(String[] args) {
        launch(args);
    }



// ----------------------------------------------- Start -------------------------------------------------- //



    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("StartMenue"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }



// ---------------------------------------------- Methoden ---------------------------------------------- //



    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GUI/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    

    
}
