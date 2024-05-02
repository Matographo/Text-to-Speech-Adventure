package de.ttsa.Container.InputContainerPlayer;

import java.util.List;

import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

import java.util.ArrayList;

public class OrderChecker extends StringMethods {
    
    private List<InorderChecker> inorders;

    public OrderChecker(String toCheck) {
        inorders = new ArrayList<>();
        StringBuilder inOrder = new StringBuilder();
        while(toCheck.length() > 0) {
            inOrder.append(toCheck.substring(0, toCheck.indexOf(InputChecker.INORDER_END.toString())+1));
            toCheck = toCheck.substring(toCheck.indexOf(InputChecker.INORDER_END.toString())+1);
            inOrder.append(toCheck.substring(0, toCheck.indexOf(")")+1));
            toCheck = toCheck.substring(toCheck.indexOf(")")+1);
            inorders.add(new InorderChecker(inOrder.toString()));
            inOrder = new StringBuilder();
        }
    }

    public boolean check() {
        boolean result = true;
        for(InorderChecker toCheck:inorders) {
            result &= toCheck.check();
        }
        return result;
    }
}
