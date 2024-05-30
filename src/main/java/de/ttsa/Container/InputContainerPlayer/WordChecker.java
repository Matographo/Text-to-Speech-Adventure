package de.ttsa.Container.InputContainerPlayer;

import de.ttsa.Container.Range;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Parents.StringMethods;

public class WordChecker extends StringMethods {
    
    private char checkType;
    private String toCheck;
    private boolean isNot;
    private Range occurance;

    public WordChecker(String toCheck) {
        if(toCheck.startsWith(InputChecker.NOT.toString())) {
            this.isNot = true;
            toCheck = toCheck.substring(1);
        }
        occurance = new Range(toCheck.substring(toCheck.lastIndexOf(InputChecker.QUANTOR.toString())));
        toCheck = toCheck.substring(0, toCheck.lastIndexOf(InputChecker.QUANTOR.toString()));
        checkType = getFirstChar(toCheck, '\'', '"', '@');
        toCheck = deleteFirstAndLast(""+checkType, toCheck);
        this.toCheck = toCheck;
    }

    public boolean check(String toCheck) {
        boolean result = false;

        switch(checkType) {
            case '@':
                result = GameManager.strVars.get(this.toCheck).getValue().equals(toCheck);
                break;
            case '\'':
                result = GameManager.sets.get(this.toCheck).contains(toCheck);
                break;
            case '"':
                result = this.toCheck.equals(toCheck);
                break;
        }


        return result && !isNot;
    }

    public Range getRange() {
        return occurance;
    }
}
