package de.ttsa.ConsoleGame.Player.Structures;

import de.ttsa.ConsoleGame.Player.Scriptables.Scriptable;

public class Room {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private Scriptable script;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    /**
     * Constructor for Room
     * @param script the script that should be executed
     */
    public Room(Scriptable script) {
        this.script = script;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //



    /**
     * Play the script of the room
     * @return true if the script was executed successfully, false otherwise
     */
    public boolean play() {
        return script.run();
    }


}
