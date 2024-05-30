package de.ttsa.Container.InputContainerPlayer;

import java.util.List;
import java.util.ArrayList;

import de.ttsa.Container.Range;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

public class InorderChecker extends StringMethods {
    
    private List<OfforderChecker> offorders;
    private boolean onlyMode;
    private boolean isNot;
    private Range occurance;

    public InorderChecker(String toCheck) {
        offorders = new ArrayList<>();
        StringBuilder offOrder = new StringBuilder();
        if(toCheck.startsWith(InputChecker.ONLY_MODE.toString())) {
            this.onlyMode = true;
            toCheck = toCheck.substring(1);
        }
        if(toCheck.startsWith(InputChecker.NOT.toString())) {
            this.isNot = true;
            toCheck = toCheck.substring(1);
        }
        occurance = new Range(toCheck.substring(toCheck.lastIndexOf(InputChecker.QUANTOR.toString())));
        toCheck = toCheck.substring(0, toCheck.lastIndexOf(InputChecker.QUANTOR.toString()));
        toCheck = deleteFirstAndLast("[", "]", toCheck);
        while(toCheck.length() > 0) {
            offOrder.append(toCheck.substring(0, toCheck.indexOf(InputChecker.OFFORDER_END.toString())+1));
            toCheck = toCheck.substring(toCheck.indexOf(InputChecker.OFFORDER_END.toString())+1);
            offOrder.append(toCheck.substring(0, toCheck.indexOf(")")+1));
            toCheck = toCheck.substring(toCheck.indexOf(")")+1);
            offorders.add(new OfforderChecker(offOrder.toString(), onlyMode));
            offOrder = new StringBuilder();
        }
    }

    public boolean check(List<String> input) {
        boolean result = true;
        
        for(OfforderChecker toCheck : offorders) {
            result &= toCheck.check(input);
        }
        
        return result && !isNot;
    }
}
