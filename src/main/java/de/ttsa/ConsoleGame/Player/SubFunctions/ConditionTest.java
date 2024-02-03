package de.ttsa.ConsoleGame.Player.SubFunctions;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Functions.Calculator;

/**
 * This class is used to test a String, if the condition is true.
 */

public class ConditionTest {

    private static String testString;
    private final String AND         = "&&";
    private final String OR          = ";;";
    private final char INPUT_CON     = 'i';
    private final char STRING_CON    = 's';
    private final char VAR_CON       = 'n';
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
        boolean result  = true;
        String[] andCon = condition.split(AND);


        for (String con : andCon) {
            result = result && testCondition(con);
        }

        return result;
    }

    private boolean testCondition(String condition) {
        char conType   = condition.charAt(0);
        condition      = condition.substring(1);
        boolean result = false;


        switch (conType) {
            case VAR_CON ->    result = testNumCondition(condition);
            case STRING_CON -> result = testStringCondition(condition);
            case INPUT_CON ->  result = testInputCondition(condition);
            default -> throw new RuntimeException("Condition type " + conType + " is not valid!");
        }

        return result;
    }



// ----------------------- Number Conditions -----------------------
    



    private boolean testNumCondition(String condition) {
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
        int left       = getNumber(leftNum);
        int right      = getNumber(rightNum);


        switch (op) {
            case "==" -> result = left == right;
            case "!=" -> result = left != right;
            case "<" ->  result = left <  right;
            case ">" ->  result = left >  right;
            case "<=" -> result = left <= right;
            case ">=" -> result = left >= right;
        }
        
        return result;
    }

    private int getNumber(String num) {
        return Calculator.calc(num);
    }



// ----------------------- String Conditions -----------------------



    private boolean testStringCondition(String condition) {
        String[] con = condition.split("==");


        for(int i=0; i < con.length; i++) {

            if(con[i].startsWith("\"") && con[i].endsWith("\"")) {
                con[i] = con[i].substring(1, con[i].length() - 1);
            } else {
                con[i] = GameManager.strVars.get(con[i]).getValue();
            }

        }

        return con[0].equals(con[1]);
    }



// ----------------------- Input Conditions -----------------------



    private boolean testInputCondition(String condition) {
        return new OrderChecker().check(condition);
    }


}
