package de.ttsa.ConsoleGame.Player.Functions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.ttsa.ConsoleGame.Player.GameManager;

/**
 * This class is used to calculate a String with a mathmatical expression.
 */

public class Calculator {

    private static Pattern varName = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*");
    private static Pattern ops = Pattern.compile("[\\+\\-\\*\\/]");
    private static Matcher match;
    private static String toCalculate;

    public Calculator() {

    }

    public static int calc(String toCalculate) {
        Calculator.toCalculate = toCalculate;
        return new Calculator().calc();
    }

    /**
     * This method calculates a String with a mathmatical expression.
     * 
     * @param toCalculate The String with the mathmatical expression
     * @return The result of the calculation
     */
    private int calc() {
        String calc = "";
        String result = toCalculate;

        while (result.contains("(")) {
            calc = result.substring(0, result.indexOf(")"));
            calc = calc.substring(calc.lastIndexOf("(") + 1);
            result = result.replace("(" + calc + ")", calcFormula(calc) + "");
        }
        return calcFormula(result);
    }

    private int calcFormula(String toCalculate) {
        toCalculate = variableReplacer(toCalculate);
        if (toCalculate.startsWith("-") || toCalculate.startsWith("+")) {
            toCalculate = "0" + toCalculate;
        }
        toCalculate = toCalculate.replaceAll(" ", "");
        ArrayList<Integer> zahlen = new ArrayList<Integer>();
        ArrayList<String> operatoren = new ArrayList<String>();
        String[] zahlenCut = toCalculate.split("[\\+\\-\\*\\/\\^]");
        String[] operatorenCut = toCalculate.split("[0-z]+");

        for (String z : zahlenCut) {
            if (!z.equals("")) {
                try {
                    zahlen.add(Integer.parseInt(z));
                } catch (Exception e) {
                    try {
                        zahlen.add(GameManager.numVars.get(z).getValue());
                    } catch (Exception e2) {
                        throw new RuntimeException("Variable " + z + " not found");
                    }
                }
            }
        }
        for (String o : operatorenCut) {
            if (!o.equals("")) {
                if(!(o.length() == 1) && !(o.length() == 2 && o.charAt(1) == '-')) {
                    throw new RuntimeException("Invalid mathmatical expression");
                }
                operatoren.add(o);
            }
        }
        return verrechnen(zahlen, operatoren);
    }

    /**
     * This method replaces all variables in the String with the value of the
     * variable.
     * 
     * @param toCalculate The String with the mathmatical expression
     * @return The String with the replaced variables
     */
    public String variableReplacer(String toCalculate) {
        while(varName.matcher(toCalculate).find()) {
            toCalculate = replaceFirstVariableString(toCalculate);
        }
        return toCalculate;
    }

    private String replaceFirstVariableString(String toCalculate) {
        String finalString = "";
        match = varName.matcher(toCalculate);
        if(match.find()) {
            int start = match.start();
            finalString = toCalculate.substring(0, start);
            toCalculate = toCalculate.substring(start);
            match.reset();
            match = ops.matcher(toCalculate);

            if(match.find()) {
                int end = match.start();
                String varName = toCalculate.substring(0, end);
                finalString += GameManager.numVars.get(varName).getValue();
                finalString += toCalculate.substring(end);
            } else {
                String varName = toCalculate;
                finalString += GameManager.numVars.get(varName).getValue();
            }
            return finalString;
        }
        return toCalculate;        
    }

    /**
     * This method calculates the mathmatical expression with the given numbers and
     * operators.
     * 
     * @param zahlen     The numbers of the mathmatical expression
     * @param operatoren The operators of the mathmatical expression
     * @return The result of the calculation
     */
    public int verrechnen(ArrayList<Integer> zahlen, ArrayList<String> operatoren) {
        if (operatoren == null && zahlen.size() == 1) {
            return zahlen.get(0);
        }
        if(operatoren.size() == zahlen.size()) {
            throw new RuntimeException("Invalid mathmatical expression");
        }

        // multipliziert die zahl mit -1 wenn der operator vornedran einen operator mit 2 stellen hat
        for(int i = 0; i < operatoren.size(); i++) {
            if(operatoren.get(i).length() == 2 && operatoren.get(i).charAt(1) == '-') {
                zahlen.set(i + 1, zahlen.get(i + 1) * -1);
                operatoren.set(i, operatoren.get(i).substring(0, 1));
            }
        }

        Operationen oper = new Operationen();

        int i = 1;
        while (i <= operatoren.size()) {
            if (operatoren.get(i - 1).equals("^")) {
                zahlen.set(i - 1, oper.sqe(zahlen.get(i - 1), zahlen.get(i)));
                operatoren.remove(i - 1);
                zahlen.remove(i);
            } else {
                i++;
            }
        }
        i = 1;
        while (i <= operatoren.size()) {
            switch (operatoren.get(i - 1)) {
                case "*":
                    zahlen.set(i - 1, oper.mult(zahlen.get(i - 1), zahlen.get(i)));
                    operatoren.remove(i - 1);
                    zahlen.remove(i);
                    break;
                case "/":
                    zahlen.set(i - 1, oper.div(zahlen.get(i - 1), zahlen.get(i)));
                    operatoren.remove(i - 1);
                    zahlen.remove(i);
                    break;
                default:
                    i++;
            }
        }
        i = 1;
        while (i <= operatoren.size()) {
            switch (operatoren.get(i - 1)) {
                case "+":
                    zahlen.set(i - 1, oper.add(zahlen.get(i - 1), zahlen.get(i)));
                    operatoren.remove(i - 1);
                    zahlen.remove(i);
                    break;
                case "-":
                    zahlen.set(i - 1, oper.sub(zahlen.get(i - 1), zahlen.get(i)));
                    operatoren.remove(i - 1);
                    zahlen.remove(i);
                    break;
                default:
                    i++;
            }
        }
        return zahlen.get(0);
    }

    /**
     * This class contains all mathmatical operations.
     */
    private class Operationen {
        public Integer add(Integer zahl1, Integer zahl2) {
            return zahl1 + zahl2;
        }

        public Integer sub(Integer zahl1, Integer zahl2) {
            return zahl1 - zahl2;
        }

        public Integer mult(Integer zahl1, Integer zahl2) {
            return zahl1 * zahl2;
        }

        public Integer div(Integer zahl1, Integer zahl2) {
            return zahl1 / zahl2;
        }

        public int sqe(Integer zahl1, Integer zahl2) {
            int newV = zahl1;
            for (int i = 1; i < zahl2; i++) {
                newV *= zahl1;
            }
            return newV;
        }

        public double sqr(double zahl) {
            return Math.sqrt(zahl);
        }
    }
}