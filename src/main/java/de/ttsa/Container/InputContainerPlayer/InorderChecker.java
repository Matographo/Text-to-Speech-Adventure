package de.ttsa.Container.InputContainerPlayer;

import java.util.List;
import java.util.ArrayList;

import de.ttsa.Container.Couple;
import de.ttsa.Container.Range;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

public class InorderChecker extends StringMethods {
    
    private List<Couple<Character, OfforderChecker>> offorders;
    private boolean onlyMode;
    private boolean isNot;
    private Range occurance;

    public InorderChecker(String toCheck) {
        offorders = new ArrayList<>();
        char booleanOperator;
        StringBuilder offOrder = new StringBuilder();
        if(toCheck.startsWith(InputChecker.ONLY_MODE.toString())) {
            this.onlyMode = true;
            toCheck = toCheck.substring(1);
        }
        if(toCheck.startsWith(InputChecker.NOT.toString())) {
            this.isNot = true;
            toCheck = toCheck.substring(1);
        }
        while(toCheck.length() > 0) {
            if(toCheck.startsWith(InputChecker.AND.toString()) ||
               toCheck.startsWith(InputChecker.OR.toString())) {
                booleanOperator = toCheck.charAt(0);
                toCheck = toCheck.substring(1);
            } else {
                booleanOperator = 0;
            }
            offOrder.append(toCheck.substring(0, toCheck.indexOf(InputChecker.OFFORDER_END.toString())+1));
            toCheck = toCheck.substring(toCheck.indexOf(InputChecker.OFFORDER_END.toString())+1);
            offOrder.append(toCheck.substring(0, toCheck.indexOf(")")+1));
            toCheck = toCheck.substring(toCheck.indexOf(")")+1);
            offorders.add(new Couple<Character, OfforderChecker>(booleanOperator, new OfforderChecker(offOrder.toString(), onlyMode)));
            offOrder = new StringBuilder();
        }
    }

    public boolean check() {
        return true;
    }
}
