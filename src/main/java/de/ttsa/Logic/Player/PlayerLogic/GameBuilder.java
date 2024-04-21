package de.ttsa.Logic.Player.PlayerLogic;

class GameBuilder {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private GameScriptBuilder gameScriptBuilder;
    


// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for GameBuilder
     * @param gamePath the path to the game
     */
    public GameBuilder(String gamePath) {
        GameLoader gameLoader  = new GameLoader(gamePath);
        this.gameScriptBuilder = new GameScriptBuilder(gameLoader.loadGameData());
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
