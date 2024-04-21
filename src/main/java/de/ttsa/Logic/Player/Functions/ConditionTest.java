package de.ttsa.Logic.Player.Functions;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;

/**
 * This class is used to test a String, if the condition is true.
 */

public class ConditionTest {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private static String testString;
    private final String AND         = "&&";
    private final String OR          = ";;";
    private final char INPUT_CON     = 'i';
    private final char STRING_CON    = 's';
    private final char VAR_CON       = 'n';
    private final String[] OPERATORS = new String[] { "==", "!=", "<=", ">=", "<", ">" };



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Test a condition
     * @param conditionString the condition that should be tested
     * @return true if the condition is true
     */
    public static boolean test(String conditionString) {
        testString = conditionString;

        return new ConditionTest().test();
    }
    
    /**
     * Test a condition
     * @param conditionString the condition that should be tested
     * @return true if the condition is true
     */
    public boolean test() {
        if (testString.strip().isEmpty()) {
            return true;
        } else {
            return tester();
        }
    }

    /**
     * Test starts OrTester
     * @return true if the condition is true
     */
    private boolean tester() {
        return testOr(testString);
    }



// ------------------------------------------- Boolean Algebra ------------------------------------------------- //



    /**
     * Test the or condition
     * @param condition with the Or condition
     * @return true if the condition is true
     */
    private boolean testOr(String condition) {
        boolean result = false;
        String[] orCon = condition.split(OR);


        for (String con : orCon) {
            result = result || testAnd(con);
        }

        return result;
    }

    /**
     * Test the and condition
     * @param condition with the And condition
     * @return true if the condition is true
     */
    private boolean testAnd(String condition) {
        boolean result  = true;
        String[] andCon = condition.split(AND);


        for (String con : andCon) {
            result = result && testCondition(con);
        }

        return result;
    }

    /**
     * Test the condition
     * @param condition the condition that should be tested
     * @return true if the condition is true
     */
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



// ------------------------------------------- Number Conditions ------------------------------------------------- //
    


    /**
     * Test the number condition
     * @param condition the condition that tests number operations
     * @return true if the condition is true
     */
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

    /**
     * Test the operator compare the left and right number with the operator
     * @param leftNum the left number
     * @param op the operator
     * @param rightNum the right number
     * @return true if the condition is true
     */
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

    /**
     * Get the Calcolated number
     * @param num the String to calculate
     * @return the number with the calculated value
     */
    private int getNumber(String num) {
        return Calculator.calc(num);
    }



// ------------------------------------------- String Conditions ------------------------------------------------- //


    /**
     * Test the string condition
     * @param condition the condition that tests string operations
     * @return true if the condition is true
     */
    private boolean testStringCondition(String condition) {
        String[] con;
        boolean isNQ;
        
        if(condition.contains("!=")) {
            con = condition.split("!=");
            isNQ = true;
        } else {
            con = condition.split("==");
            isNQ = false;
        }
        


        for(int i=0; i < con.length; i++) {

            if(con[i].startsWith("\"") && con[i].endsWith("\"")) {
                con[i] = con[i].substring(1, con[i].length() - 1);
            } else {
                con[i] = GameManager.strVars.get(con[i]).getValue();
            }

        }

        if(isNQ) return !con[0].equals(con[1]);
        
        return con[0].equals(con[1]);
    }



// ------------------------------------------- Input Conditions ------------------------------------------------- //


    /**
     * Test the input condition
     * @param condition the condition that tests input operations
     * @return true if the condition is true
     */
    private boolean testInputCondition(String condition) {
        return new OrderChecker().check(condition);
    }


}
