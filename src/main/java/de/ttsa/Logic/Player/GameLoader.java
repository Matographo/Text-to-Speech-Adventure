package de.ttsa.Logic.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class GameLoader {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String gameFile;



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
    public ArrayList<String> loadGameData() {
        File game = new File(gameFile);
        ArrayList<String> gameContent = new ArrayList<String>();


        if(game.isFile()) {
            gameContent = loadGameFile(game);
        } else {
            throw new RuntimeException("Game file is not a file!");
        }

        return gameContent;
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
}
