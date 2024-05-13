package de.ttsa;

import java.io.IOException;

import de.ttsa.Container.SettingsClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStart extends Application {

    // --------------------------------------------- Attributes
    // ------------------------------------------------ //

    public static final String settingsPath = "src/main/resources/Data/data.settings";
    private static Scene scene;
    public static SettingsClass settings;
    private static Stage stage;

    // ------------------------------------------------ Main
    // --------------------------------------------------- //

    public static void main(String[] args) {
        launch(args);
    }

    // ----------------------------------------------- Start
    // -------------------------------------------------- //

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        settings = new SettingsClass(settingsPath);
        scene = new Scene(loadFXML("StartMenu"), 640, 600);
        stage.setScene(scene);
        stage.show();
    }

    // ---------------------------------------------- Methoden
    // ---------------------------------------------- //

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppStart.class.getResource("Frontend/GUI/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
