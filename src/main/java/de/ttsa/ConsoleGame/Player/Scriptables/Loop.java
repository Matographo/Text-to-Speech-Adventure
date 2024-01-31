package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.SubFunctions.ConditionTest;

public class Loop implements Scriptable {

    private final char ITERATIONS = 'i';
    private final char TRUE = 't';
    private final char CONDITION = 'c'; 
    
    private String condition;
    private Scriptable script;
    private char conditionType;
    private int counter = 0;
    private int maxCounter = -1;


    public Loop(String condition, char conditionType, Scriptable script) {
        this.condition = condition;
        this.conditionType = conditionType;
        this.script = script;
    }


    @Override
    public boolean run() {
        if(conditionType == ITERATIONS) maxCounter = Integer.parseInt(condition);
        counter = 0;
        while(getResult() && !GameManager.loopBreak) {
            script.run();
        }
        GameManager.loopBreak = false;
        return true;
    }

    private boolean getResult() {
        switch(conditionType) {
            case ITERATIONS:
                return counter++ < maxCounter;
            case TRUE:
                return true;
            case CONDITION:
                return ConditionTest.test(condition);
            default:
                return false;
        }
    }


}
