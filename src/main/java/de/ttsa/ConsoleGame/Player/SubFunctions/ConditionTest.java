package de.ttsa.ConsoleGame.Player.SubFunctions;

import java.util.HashSet;

import de.ttsa.ConsoleGame.Player.Functions.Calculator;

/**
 * This class is used to test a String, if the condition is true.
 */

public class ConditionTest {

    private static String testString;
    private final String AND = "&&";
    private final String OR = "!!";
    private final String INPUT = "input";
    private final String[] OPERATORS = new String[] { "==", "!=", "<=", ">=", "<", ">" };

    public static boolean test(String conditionString) {
        testString = conditionString;
        return new ConditionTest().test();
    }

    public boolean test() {
        if (testString.strip().isEmpty()) {
            return true;
        } else {
            return tester();
        }
    }

    private boolean tester() {
        return testOr(testString);
    }



    private boolean testOr(String condition) {
        boolean result = false;
        String[] orCon = condition.split(OR);
        for (String con : orCon) {
            result = result || testAnd(con);
        }
        return result;
    }

    private boolean testAnd(String condition) {
        boolean result = true;
        String[] andCon = condition.split(AND);
        for (String con : andCon) {
            result = result && testCondition(con);
        }
        return result;
    }

    private boolean testCondition(String condition) {
        boolean result = false;
        for (String op : OPERATORS) {
            if (condition.contains(op)) {
                String[] con = condition.split(op);
                if (con.length == 2) {
                    result = testOperator(con[0], op, con[1]);
                }
                break;
            }
        }
        return result;
    }

    private boolean testOperator(String leftNum, String op, String rightNum) {
        boolean result = false;
        int left = getNumber(leftNum);
        int right = getNumber(rightNum);
        switch (op) {
            case "==" -> result = left == right;
            case "!=" -> result = left != right;
            case "<" -> result = left < right;
            case ">" -> result = left > right;
            case "<=" -> result = left <= right;
            case ">=" -> result = left >= right;
        }
        
        return result;
    }

    private int getNumber(String num) {
        return Calculator.calc(num);
    }




}
