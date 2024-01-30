package de.ttsa.ConsoleGame.Player.Structures;

import de.ttsa.ConsoleGame.Player.Scriptables.Scriptable;

public class Room {
    
    private Scriptable script;

    public Room(Scriptable script) {
        this.script = script;
    }

    public void play() {
        script.run();
    }
}
