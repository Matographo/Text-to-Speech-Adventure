package de.ttsa.Container.InputContainerPlayer;

import java.util.List;

import de.ttsa.Container.Couple;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

import java.util.ArrayList;

public class OrderChecker extends StringMethods {
    
    private List<Couple<Character, InorderChecker>> inorders;

    public OrderChecker(String toCheck) {
        inorders = new ArrayList<>();
        char booleanOperator;
        StringBuilder inOrder = new StringBuilder();
        while(toCheck.length() > 0) {
            if(toCheck.startsWith(InputChecker.AND.toString()) ||
               toCheck.startsWith(InputChecker.OR.toString())) {
                booleanOperator = toCheck.charAt(0);
                toCheck = toCheck.substring(1);
            } else {
                booleanOperator = 0;
            }
            inOrder.append(toCheck.substring(0, toCheck.indexOf(InputChecker.INORDER_END.toString())+1));
            toCheck = toCheck.substring(toCheck.indexOf(InputChecker.INORDER_END.toString())+1);
            inOrder.append(toCheck.substring(0, toCheck.indexOf(")")+1));
            toCheck = toCheck.substring(toCheck.indexOf(")")+1);
            inorders.add(new Couple<Character, InorderChecker>(booleanOperator, new InorderChecker(inOrder.toString())));
            inOrder = new StringBuilder();
        }
    }

    public boolean check() {
        return true;
    }
}
