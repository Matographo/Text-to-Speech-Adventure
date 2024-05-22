package de.ttsa.Logic.Player.PlayerLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import de.ttsa.Tools.ZipManager;

class GameLoader {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String gameFile;
    private String gameFileExtension = "ta";



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for GameLoader
     * @param gamePaht the path to the game
     */
    public GameLoader(String gamePaht) {
        this.gameFile = gamePaht;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //


    /**
     * Load the game data
     * @return the game data as a list of strings
     */
    public List<String> loadGameData() {
        File game = new File(gameFile);
        GameManager.gameFile = game;

        if(!game.exists()) {
            throw new RuntimeException("Game file does not exist!");
        } else if(!game.canRead()) {
            throw new RuntimeException("Game file is not readable!");
        } else if(!game.isFile()) {
            throw new RuntimeException("Game file is not a file!");
        } else if(!game.getName().endsWith(gameFileExtension)) {
            throw new RuntimeException("Game file is not a Text Adventure (.ta) file!");
        }

        if(isZipFile(game)) {
            try {
                return loadGame(game);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return loadGameFile(game);
    }

    /**
     * Load the game file
     * @param game the game file
     * @return the game data as a list of strings
     */
    private ArrayList<String> loadGameFile(File game) {
        try {
            BufferedReader reader         = new BufferedReader(new FileReader(game));
            ArrayList<String> gameContent = new ArrayList<String>();
            String line                   = "";


            while((line = reader.readLine()) != null) {
                gameContent.add(line);
            }

            reader.close();
            return gameContent;
        } catch(Exception e) {
            throw new RuntimeException("Error while reading game file!");
        }
    }

    private List<String> loadGame(File game) throws IOException {
        return ZipManager.readFromZip(game.getAbsolutePath(), "game.ta");
    }

    private boolean isZipFile(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            zipFile.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
