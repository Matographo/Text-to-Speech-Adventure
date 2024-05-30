package de.ttsa.Container.InputContainerPlayer;

import java.util.ArrayList;
import java.util.List;

import de.ttsa.Logic.Features.Set.Set;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Parents.StringMethods;

public class InputRegexCheckerBuilder extends StringMethods {

    private String pattern;
    
    public InputRegexCheckerBuilder(String argument) {
        //pattern = calculateArgument(argument);
    }
/*
    private String calculateArgument(String argument) {
        List<String> inorders = new ArrayList<>();
        String currentInorder = "";
        while(!argument.isBlank()) {
            currentInorder = argument.substring(0, argument.indexOf(")"+1));
            pattern += calculateInorder(currentInorder);
        }
    }

    private String calculateInorder(String inorder) {
        
    }

    private String calculateSet(String setName, String occurrence) {
        StringBuilder pattern = new StringBuilder();
        pattern.append("(");
        Set set = GameManager.sets.get(setName);
        for(String value : set.getVar()) {
            pattern.append(value);
            pattern.append("|");
        }
        for(String value : set.getStr()) {
            pattern.append("#" + value + "#");
            pattern.append("|");
        }
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(")");
        pattern.append(getOccurence(occurrence));
        return pattern.toString();
    }




    private String getOccurence(String occurrence) {
        String num1 = "";
        String num2 = "";
        String number = occurrence.substring(2, occurrence.length()-1);
        num1 = number.substring(0, number.indexOf(","));
        num2 = number.substring(number.indexOf(",")+1);
        if(num2.equals(num1)) {
            if(num1.equals("1"))
                return "";
            return "*{" + num1 + "}";
        }
        return "*{" + num1 + "," + num2 + "}";
    }



    public boolean checkInput() {
        String pattern = buildPattern();
        return GameManager.input.matches(pattern);
    }
    

    private String buildPattern() {
        return pattern;
    }


    public static void main(String[] args) {
        GameManager.input = "test";
        InputRegexCheckerBuilder test = new InputRegexCheckerBuilder("\"test\"");
        System.out.println(test.checkInput());
    }
*/
}
