package de.ttsa.ConsoleGame.Player.Structures;

import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class Room {
    
    private Scriptable script;

    public Room(Scriptable script) {
        this.script = script;
    }

    public void play() {
        script.run();
    }
}
