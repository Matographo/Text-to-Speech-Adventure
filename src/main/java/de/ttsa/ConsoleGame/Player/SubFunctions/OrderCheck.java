package de.ttsa.ConsoleGame.Player.SubFunctions;

import de.ttsa.ConsoleGame.Player.GameManager;

/**
 * This class is used to check conditions faster and easier.
 */

public class OrderCheck {
    private int lastHighest = 0;

    /**
     * This method checks if the String order maches the input
     * 
     * @param input the String to check
     * @return true if the order maches the input
     */
    public boolean check(String input) {
        // Inorder Check
        if ((input = input.strip()).startsWith("(")) {
            String inorder = input.substring(1, input.indexOf(")"));
            if (input.length() == input.indexOf(")" + 1)) {
                return checkInOrder(inorder) && check(input.substring(input.indexOf(")") + 1));
            } else {
                return checkInOrder(inorder);
            }
        // Offorder Check
        } else if (input.startsWith("\"")) {
            String[] off = input.split("\"");
            String offorder = off[1];
            if (input.length() == input.indexOf("\"") + 1) {
                return checkOffOrder(offorder) && check(input.substring(input.indexOf("\"") + 1));
            } else {
                return checkOffOrder(offorder);
            }
        // String Variable Check
        } else if (input.startsWith("'")) {
            String set = input.substring(1);
            set = set.substring(0, set.indexOf("'"));
            if (input.length() == input.substring(1).indexOf("'") + 2) {
                return checkStrVar(set);
            } else {
                input = input.substring(1);
                input = input.substring(input.indexOf("'") + 1);
                return checkStrVar(set) && check(input.substring(input.indexOf("'") + 1));
            }
        // Word Check
        } else {
            String[] words = input.split("!!");
            boolean wordCheck = true;
            for (String word : words) {
                word = word.strip();
                wordCheck = wordCheck && checkWord(word);
            }
            return wordCheck;
        }
    }

    /**
     * This method checks if the String order maches the input
     * 
     * @param input the String to check
     * @return true if the order maches the input
     */
    private boolean checkInOrder(String input) {
        String[] inOrder;
        String offOrder;
        boolean inOrderCheck = true;
        int orderLastHighest = 0;
        if (!input.contains("\""))
            inOrder = input.split(",");
        else {
            int offOrderStart = input.indexOf("\"");
            offOrder = input.substring(offOrderStart + 1, input.indexOf("\"", offOrderStart + 1));
            inOrderCheck = inOrderCheck && check(offOrder);
            if (input.length() != offOrder.length() + 2) {
                String[] inOrderExtreme1 = input.substring(0, offOrderStart).split(",");
                String[] inOrderExtreme2 = input.substring(input.indexOf("\"", offOrderStart + 1) + 1).split(",");
                inOrder = new String[inOrderExtreme1.length + inOrderExtreme2.length];

                String inorder = input.substring(0, offOrderStart);
                inorder = inorder + input.substring(input.indexOf("\"", offOrderStart + 1) + 1);
                inOrder = inorder.split(",");
            } else {
                inOrder = new String[0];
            }
            if (lastHighest > orderLastHighest) {
                orderLastHighest = lastHighest;
            }
        }

        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i].isEmpty())
                continue;
            lastHighest = 0;
            boolean checkB = check(inOrder[i]);
            if (lastHighest > orderLastHighest) {
                orderLastHighest = lastHighest;
                inOrderCheck = inOrderCheck && checkB;
            } else {
                inOrderCheck = false;
            }
        }
        return inOrderCheck;
    }

    /**
     * This method checks if the String matches the input in any order
     * 
     * @param input the String to check
     * @return true if the order maches the input
     */
    private boolean checkOffOrder(String input) {
        String[] offOrder = input.split("!!");
        boolean offOrderCheck = true;
        for (int i = 0; i < offOrder.length; i++) {
            offOrderCheck = offOrderCheck && check(offOrder[i]);
        }
        return offOrderCheck;
    }


    private boolean checkStrVar(String toCheck) {
        String[] input = getInput();
        if (toCheck == null || toCheck.isEmpty())
            return false;
        int times = input.length;
        String lastInput;
        toCheck = GameManager.strVars.get(toCheck).getValue();
        for (int i = 0; i < times; i++) {
            lastInput = input[i];
            if (lastInput.equals(toCheck)) {
                if (i > lastHighest) {
                    lastHighest = i;
                }
                return true;
            }
        }
        return false;
    }

    // /**
    //  * This method checks if the String matches the Name Set with the input
    //  * 
    //  * @param input the String to check
    //  * @return true if the order maches the input
    //  */
    // private boolean checkSet(String input) {
    //     if (input == null || input.isEmpty())
    //         return false;
    //     HashSet<String> set = new HashSet<>();
    //     for (int i = 0; i < GameManager.getInput().size(); i++) {
    //         // abfragen ob das setelement eine string variable ist (') und wenn ja das mit
    //         // dem string austauschen
    //         for (String key : GameManager.allCommandSets.get(input)) {
    //             if (key.startsWith("'") && key.endsWith("'")) {
    //                 String variable = key.substring(1, key.length() - 1);
    //                 set.add(GameManager.allStrings.get(variable).get());
    //             } else {
    //                 set.add(key);
    //             }
    //         }
    //         if (set.contains(GameManager.getInput().get(i))) {
    //             if (i > lastHighest) {
    //                 lastHighest = i;
    //             }
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /**
     * This method checks if the Word/Words matches the input
     * 
     * @param input the String to check
     * @return true if the order maches the input
     */
    private boolean checkWord(String toCheck) {
        String[] input = getInput();
        if (toCheck == null || toCheck.isEmpty())
            return false;
        int times = input.length;
        String lastInput;
        for (int i = 0; i < times; i++) {
            lastInput = input[i];
            if (lastInput.equals(toCheck)) {
                if (i > lastHighest) {
                    lastHighest = i;
                }
                return true;
            }
        }
        return false;
    }



    private String[] getInput() {
        return GameManager.input.split(" ");
    }
}