package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.SubFunctions.ConditionTest;

public class Loop implements Scriptable {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private final char ITERATIONS = 'i';
    private final char TRUE       = 't';
    private final char CONDITION  = 'c';
    private final char VAR        = 'v'; 
    
    private String condition;
    private Scriptable script;
    private char conditionType;
    private int counter    = 0;
    private int maxCounter = -1;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    /**
     * Constructor for Loop
     * @param condition the condition that should be tested
     * @param conditionType the type of the condition
     * @param script the script that should be executed if the condition is true
     */
    public Loop(String condition, char conditionType, Scriptable script) {
        this.condition     = condition;
        this.conditionType = conditionType;
        this.script        = script;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        if(conditionType == ITERATIONS) maxCounter = Integer.parseInt(condition);
        if(conditionType == VAR) maxCounter = GameManager.numVars.get(condition).getValue();
        
        counter = 0;

        while(getResult() && !GameManager.loopBreak) {
            script.run();
        }
        
        GameManager.loopBreak = false;
        return true;
    }

    /**
     * Get the result of the condition
     * @return the result of the condition
     */
    private boolean getResult() {
        switch(conditionType) {
            case ITERATIONS:
            case VAR:
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
