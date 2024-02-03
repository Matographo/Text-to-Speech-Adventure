package de.ttsa.ConsoleGame.Player.Scriptables;

import java.util.List;

public class Script implements Scriptable{

    private Scriptable[] script;

    public Script(Scriptable script) {
        this.script = new Scriptable[]{script};
    }

    public Script(List<Scriptable> script) {
        this.script = script.toArray(new Scriptable[0]);
    }

    public Script(Scriptable... script) {
        this.script = script;
    }

    @Override
    public boolean run() {
        for (Scriptable subScript : script) {
            if(!subScript.run()) return false;
        }
        
        return true;
    }
}
