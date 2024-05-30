package de.ttsa.Container.InputContainerPlayer;

import java.util.List;

import de.ttsa.Enums.InputChecker;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Parents.StringMethods;

import java.util.ArrayList;
import java.util.Arrays;

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
        List<String> input = new ArrayList<>();
        input.addAll(Arrays.asList(GameManager.input.split(" ")));
        for(InorderChecker toCheck:inorders) {
            result &= toCheck.check(input);
        }
        return result;
    }
}
