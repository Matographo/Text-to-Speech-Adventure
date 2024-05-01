package de.ttsa.Logic.Player.Functions.PlayerFunctions;

import java.util.ArrayList;
import java.util.HashSet;

import de.ttsa.Enums.InputChecker;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Parents.StringMethods;

public class OrderChecker extends StringMethods {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String[] input;
    private int lastFoundet                 = -1;
    private final String WORD_VAR_SEPARATOR = "!!";
    


// -------------------------------------------- Check Methods -------------------------------------------------- //


    /**
     * Check if the given String is a valid order
     * @param toCheck the String that should be checked
     * @return true if the String is a valid order
     */
    public boolean check(String toCheck) {
        input = getInput();

        if(checkFirstAndLast(InputChecker.INORDER_START.toString(), InputChecker.INORDER_END.toString(), toCheck)) {
            return checkInorder(toCheck);
        }

        return false;
    }

    /**
     * Check if the given String is in the right order
     * @param toCheck the String that should be checked
     * @return true if the String is a valid order
     */
    private boolean checkInorder(String toCheck) {
        boolean checkResult         = true;
        toCheck                     = deleteFirstAndLast(InputChecker.INORDER_START.toString(), InputChecker.INORDER_END.toString(), toCheck);
        ArrayList<String> offOrders = new ArrayList<>();


        while(hasBlock(InputChecker.OFFORDER_START.toString(), InputChecker.OFFORDER_END.toString(), toCheck)) {

            offOrders.add(getNextSubstring(InputChecker.OFFORDER_START.toString(), InputChecker.OFFORDER_END.toString(), toCheck));
            toCheck = deleteUntilAfterSubstring(InputChecker.OFFORDER_START.toString(), InputChecker.OFFORDER_END.toString(), toCheck);

        }
        for(String offOrder : offOrders) {

            checkResult = checkResult && checkOffOrder(offOrder);
            toCheck = deleteUntilSubstring(InputChecker.OFFORDER_START.toString(), InputChecker.OFFORDER_END.toString(), toCheck);

        }

        return checkResult;
    }

    /**
     * Check if the given String has the components in the input
     * @param toCheck the String that should be checked
     * @return true if the String is a valid order
     */
    private boolean checkOffOrder(String toCheck) {
        if(input == null || input.length == 0) return false;

        String[] words      = toCheck.split(WORD_VAR_SEPARATOR);
        boolean checkResult = true;


        for(String word : words) {

            if(word.startsWith(InputChecker.VAR.toString())) {

                word        = deleteFirst(InputChecker.VAR.toString(), word);
                checkResult = checkResult && checkVar(word);

            } else if (checkFirstAndLast(InputChecker.SET.toString(), toCheck)) {

                word        = deleteFirstAndLast(InputChecker.SET.toString(), word);
                checkResult = checkResult && checkSet(word);

            } else if (checkFirstAndLast(InputChecker.STRING.toString(), toCheck)) {
                checkResult = checkResult && checkWord(word);
            }

        }

        input = getNewInput();
        return checkResult;
    }

    /**
     * Check if the given String is a variable an exists in the input
     * @param toCheck the String that should be checked
     * @return true if the String is a valid order
     */
    private boolean checkVar(String toCheck) {
        boolean checkResult = false;
        toCheck             = GameManager.strVars.get(toCheck).getValue();

        for(int i=0; i < input.length; i++) {

            if(input[i].equals(toCheck)) {
                if(i > lastFoundet) lastFoundet = i;

                checkResult = true;
                break;
            }
        }

        return checkResult;
    }

    /**
     * Check if the given String is a word and exists in the input
     * @param toCheck the String that should be checked
     * @return true if the String is a valid order
     */
    private boolean checkWord(String toCheck) {
        boolean checkResult = false;
        toCheck            = deleteFirstAndLast(InputChecker.STRING.toString(), toCheck);

        for(int i=0; i < input.length; i++) {
            if(input[i].equals(toCheck)) {
                if(i > lastFoundet) lastFoundet = i;
                checkResult                     = true;
                break;
            }
        }
        return checkResult;
    }

    /**
     * Check if the given String is a set and exists in the input
     * @param toCheck the String that should be checked
     * @return true if the String is a valid order
     */
    private boolean checkSet(String toCheck) {
        HashSet<String> strings = GameManager.sets.get(toCheck).getStr();
        HashSet<String> vars    = GameManager.sets.get(toCheck).getVar();
        boolean checkResult     = false;


        for(String string : strings) {
            checkResult = checkResult || checkWord(string);
        }
        for(String var : vars) {
            checkResult = checkResult || checkVar(var);
        }
        return checkResult;
    }



// ---------------------------------------------- Getter & Setter -------------------------------------------- //



    /**
     * Get the input from the User
     * @return the input
     */
    private String[] getInput() {
        return GameManager.input.split(" ");
    }

    /**
     * Get the new input after the last foundet word and delete until the last foundet word
     * @return the new input
     */
    private String[] getNewInput() {
        String[] newInput = new String[input.length - lastFoundet - 1];


        for(int i=0; i < newInput.length; i++) {
            newInput[i] = input[i + lastFoundet + 1];
        }
        
        return newInput;
    }


    
}
