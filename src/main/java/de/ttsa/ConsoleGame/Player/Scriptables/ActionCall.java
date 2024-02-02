package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class ActionCall implements Scriptable{
    
    private String actionName;

    public ActionCall(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public boolean run() {
        return GameManager.actions.get(actionName).run();
    }

}
