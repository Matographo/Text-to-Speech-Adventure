package de.ttsa.ConsoleGame.Player.Scriptables;

import java.util.List;

public class Script implements Scriptable{


// ---------------------------- Attributes ----------------------------



    private Scriptable[] script;



// --------------------------- Constructors ---------------------------


    /**
     * Create a script from a list of scriptables
     * @param script the list of scriptables
     */
    public Script(Scriptable script) {
        this.script = new Scriptable[]{script};
    }

    /**
     * Create a script from a list of scriptables
     * @param script the list of scriptables
     */
    public Script(List<Scriptable> script) {
        this.script = script.toArray(new Scriptable[0]);
    }

    /**
     * Create a script from a list of scriptables
     * @param script the list of scriptables
     */
    public Script(Scriptable... script) {
        this.script = script;
    }



// ----------------------------- Methods -----------------------------



    @Override
    public boolean run() {
        for (Scriptable subScript : script) {
            if(!subScript.run()) return false;
        }
        
        return true;
    }


    
}
