package de.ttsa.ConsoleGame.Player.SubFunctions;

import java.util.ArrayList;

import de.ttsa.ConsoleGame.Player.GameManager;

public class OrderChecker extends StringMethodes {

    private String[] input;
    private int lastFoundet = -1;
    private final String WORD_VAR_SEPARATOR = "!!";
    

    public boolean check(String toCheck) {
        input = getInput();
        if(checkFirstAndLast("(", ")", toCheck)) {
            return checkInorder(toCheck);
        }
        return false;
    }


    private boolean checkInorder(String toCheck) {
        boolean checkResult = true;
        toCheck = deleteFirstAndLast("(", ")", toCheck);
        ArrayList<String> offOrders = new ArrayList<>();
        while(hasBlock("\"", toCheck)) {
            offOrders.add(getNextSubstring("\"", toCheck));
            toCheck = deleteUntilAfterSubstring("\"", toCheck);
        }
        for(String offOrder : offOrders) {
            checkResult = checkResult && checkOffOrder(offOrder);
            toCheck = deleteUntilSubstring("\"", toCheck);
        }
        return checkResult;
    }


    private boolean checkOffOrder(String toCheck) {
        if(input == null || input.length == 0) return false;
        String[] words = toCheck.split(WORD_VAR_SEPARATOR);
        boolean checkResult = true;
        for(String word : words) {
            if(word.startsWith("'")) {
                word = deleteFirstAndLast("'", word);
                checkResult = checkResult && checkVar(word);
            } else {
                checkResult = checkResult && checkWord(word);
            }
        }

        input = getNewInput();
        return checkResult;
    }


    private boolean checkVar(String toCheck) {
        boolean checkResult = false;
        toCheck = GameManager.strVars.get(toCheck).getValue();
        for(int i=0; i < input.length; i++) {
            if(input[i].equals(toCheck)) {
                if(i > lastFoundet) lastFoundet = i;
                checkResult = true;
                break;
            }
        }
        return checkResult;
    }


    private boolean checkWord(String toCheck) {
        boolean checkResult = false;
        for(int i=0; i < input.length; i++) {
            if(input[i].equals(toCheck)) {
                if(i > lastFoundet) lastFoundet = i;
                checkResult = true;
                break;
            }
        }
        return checkResult;
    }


    private String[] getInput() {
        return GameManager.input.split(" ");
    }

    private String[] getNewInput() {
        String[] newInput = new String[input.length - lastFoundet - 1];
        for(int i=0; i < newInput.length; i++) {
            newInput[i] = input[i + lastFoundet + 1];
        }
        return newInput;
    }
}
