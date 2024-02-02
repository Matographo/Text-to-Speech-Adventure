package de.ttsa.ConsoleGame.Player.Structures;

import de.ttsa.ConsoleGame.Player.Scriptables.Scriptable;

public class Action implements Scriptable {
    
    private Scriptable[] script;

    public Action(Scriptable... script) {
        this.script = script;
    }

    @Override
    public boolean run() {
        for (Scriptable s : script) {
            if (!s.run()) {
                return false;
            }
        }
        return true;
    }


}
