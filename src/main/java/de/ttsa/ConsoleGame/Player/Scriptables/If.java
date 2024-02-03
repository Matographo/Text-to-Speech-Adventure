package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.SubFunctions.ConditionTest;

public class If implements Scriptable {

    private final String[] condition;
    private final Scriptable[] script;
    
    public If(String condition, Scriptable script) {
        this.condition    = new String[1];
        this.condition[0] = condition;
        this.script       = new Scriptable[1];
        this.script[0]    = script;
    }

    public If(String[] condition, Scriptable[] script) {
        this.condition = condition;
        this.script    = script;
    }

    @Override
    public boolean run() {
        for (int i = 0; i < condition.length; i++) {
            if(testCondition(condition[i])) {
                script[i].run();
                return true;
            }
        }
        
        return false;
    }

    private boolean testCondition(String condition) {
        return ConditionTest.test(condition);
    }
}
