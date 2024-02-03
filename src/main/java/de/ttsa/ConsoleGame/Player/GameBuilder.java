package de.ttsa.ConsoleGame.Player;

class GameBuilder {


// ---------------------------- Attributes ----------------------------



    private GameLoader gameLoader;
    private GameScriptBuilder gameScriptBuilder;
    


// ----------------------------- Constructor -----------------------------


    /**
     * Constructor for GameBuilder
     * @param gamePath the path to the game
     */
    public GameBuilder(String gamePath) {
        this.gameLoader        = new GameLoader(gamePath);
        this.gameScriptBuilder = new GameScriptBuilder(gameLoader.loadGameData());
    }



// ------------------------------- Methods -------------------------------


    /**
     * Build the game
     * @return the game
     */
    public void build() {
        gameScriptBuilder.load();
    }
   
    
}
