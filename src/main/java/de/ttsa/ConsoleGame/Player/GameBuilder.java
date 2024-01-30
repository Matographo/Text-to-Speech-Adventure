package de.ttsa.ConsoleGame.Player;

import de.ttsa.ConsoleGame.Player.Scriptables.Scriptable;

class GameBuilder {

    private GameLoader gameLoader;
    private GameScriptBuilder gameScriptBuilder;
    
    public GameBuilder(String gamePath) {
        this.gameLoader = new GameLoader(gamePath);
        this.gameScriptBuilder = new GameScriptBuilder(gameLoader.loadGameData());
    }

    public Scriptable build() {
        return gameScriptBuilder.load();
    }
    
}
