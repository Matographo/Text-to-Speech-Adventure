package de.ttsa.Logic.Player.PlayerLogic;

import de.ttsa.Logic.PlayerApp;
import de.ttsa.Tools.Formater;
import de.ttsa.Tools.SimpleLog;

class GameBuilder {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private GameScriptBuilder gameScriptBuilder;
    private SimpleLog log = PlayerApp.log;
    


// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for GameBuilder
     * @param gamePath the path to the game
     */
    public GameBuilder(String gamePath) {
        GameLoader gameLoader  = new GameLoader(gamePath);
        log.info("Start reading game data");
        long startTime = System.currentTimeMillis();
        this.gameScriptBuilder = new GameScriptBuilder(gameLoader.loadGameData());
        log.debug("Game data read in " + Formater.format(System.currentTimeMillis() - startTime));
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //


    /**
     * Build the game
     * @return the game
     */
    public void build() {
        gameScriptBuilder.load();
    }
   
    
}
