package de.ttsa.Logic.Compiler.Functions.Properties;

import java.io.File;
import java.util.Properties;

public class GameProperty {
    
    private File propertiesPath;

    private String compilerName = "";
    private String compilerVersion = "";
    private String compilerPublisher = "";

    private String gameTitle = "";
    private String gameDescription = "";
    private String gameAuthor = "";
    private String gameReleaseDate = "";
    private String gameLanguage = "";
    private String[] gameGenre = new String[0];

    private boolean playerMusic = false;
    private boolean playerImage = false;


    public GameProperty(File file) {
        propertiesPath = new File(file, "game.properties");
    }


    public String getCompilerName() {
        return compilerName;
    }

    public String getCompilerVersion() {
        return compilerVersion;
    }

    public String getCompilerPublisher() {
        return compilerPublisher;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public GameProperty setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
        return this;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public GameProperty setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
        return this;
    }

    public String getGameAuthor() {
        return gameAuthor;
    }

    public GameProperty setGameAuthor(String gameAuthor) {
        this.gameAuthor = gameAuthor;
        return this;
    }

    public String getGameReleaseDate() {
        return gameReleaseDate;
    }

    public GameProperty setGameReleaseDate(String gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
        return this;
    }

    public String getGameLanguage() {
        return gameLanguage;
    }

    public GameProperty setGameLanguage(String gameLanguage) {
        this.gameLanguage = gameLanguage;
        return this;
    }

    public String[] getGameGenre() {
        return gameGenre;
    }

    public GameProperty setGameGenre(String[] gameGenre) {
        this.gameGenre = gameGenre;
        return this;
    }

    public boolean isPlayerMusic() {
        return playerMusic;
    }

    public GameProperty setPlayerMusic(boolean playerMusic) {
        this.playerMusic = playerMusic;
        return this;
    }

    public boolean isPlayerImage() {
        return playerImage;
    }

    public GameProperty setPlayerImage(boolean playerImage) {
        this.playerImage = playerImage;
        return this;
    }





    public boolean save() {
        Properties prop = new Properties();
        prop.setProperty("compilerName", "Text Adventure Maker Compiler");
        prop.setProperty("compilerVersion", "0.0.1");
        prop.setProperty("compilerPublisher", "Leonard Ramminger");

        prop.setProperty("gameTitle", gameTitle);
        prop.setProperty("gameDescription", gameDescription);
        prop.setProperty("gameAuthor", gameAuthor);
        prop.setProperty("gameReleaseDate", gameReleaseDate);
        prop.setProperty("gameLanguage", gameLanguage);
        prop.setProperty("gameGenre", String.join(",", gameGenre));
        
        prop.setProperty("playerMusic", String.valueOf(playerMusic));
        prop.setProperty("playerImage", String.valueOf(playerImage));

        return new PropertySaver(prop, propertiesPath).save();
    }

    public boolean load() {
        if(isValide()) {
            Properties prop = new PropertyLoader(propertiesPath).load();

            compilerName      = prop.getProperty("compilerName");
            compilerVersion   = prop.getProperty("compilerVersion");
            compilerPublisher = prop.getProperty("compilerPublisher");

            gameTitle       = prop.getProperty("gameTitle");
            gameDescription = prop.getProperty("gameDescription");
            gameAuthor      = prop.getProperty("gameAuthor");
            gameReleaseDate = prop.getProperty("gameReleaseDate");
            gameLanguage    = prop.getProperty("gameLanguage");
            gameGenre       = prop.getProperty("gameGenre").split(",");

            playerMusic = Boolean.parseBoolean(prop.getProperty("playerMusic"));
            playerImage = Boolean.parseBoolean(prop.getProperty("playerImage"));

            return true;
        }

        return false;
    }

    private boolean isValide() {
        if(gameTitle.isBlank()) {
            return false;
        }
        if(gameAuthor.isBlank()) {
            return false;
        }
        if(gameLanguage.isBlank()) {
            return false;
        }
        return true;
    }

    public GameProperty createDefault() {
        gameTitle = "New Game";
        gameAuthor = "Unknown";
        gameLanguage = "en";
        return this;
    }


}
