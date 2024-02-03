package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.SubFunctions.ConditionTest;

public class If implements Scriptable {


// ---------------------------- Attributes ----------------------------



    private final String[] condition;
    private final Scriptable[] script;
    


// --------------------------- Constructor ---------------------------


    /**
     * Constructor for If
     * @param condition the condition that should be tested
     * @param script the script that should be executed if the condition is true
     */
    public If(String condition, Scriptable script) {
        this.condition    = new String[1];
        this.condition[0] = condition;
        this.script       = new Scriptable[1];
        this.script[0]    = script;
    }

    /**
     * Constructor for If
     * @param condition the conditions that should be tested
     * @param script the scripts that should be executed if the condition is true
     */
    public If(String[] condition, Scriptable[] script) {
        this.condition = condition;
        this.script    = script;
    }



// ----------------------------- Methods -----------------------------



    @Override
    public boolean run() {
        for (int i = 0; i < condition.length; i++) {
            if(ConditionTest.test(condition[i])) {
                return script[i].run();
            }
        }
        
        return false;
    }



}
