package de.ttsa.Logic.Features.NumInit;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class NumInitOpCodeSyntax extends OpCode implements OpCodeTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        String[] args = arg.split(NUMBER_DEC_SEPERATOR);
        String value = args[1];


        if(args.length != 2)           return false;
        else if(!isValidName(args[0])) return false;
        
        if(!value.contains("*") && !value.contains("/") && !value.contains("-") && !value.contains("+")) {
            if(!isNumber(value) && !isValidName(value)) return false;
            else                                        return true;
        }

        return isCalculatable(value);
    }

        /**
     * Test if the name is valid
     * @param name The name to test
     * @return true if the name is valid
     */
    private boolean isValidName(String name) {
        return name.matches(REGEX_VALIDE_NAME);
    }

        /**
     * Test if the String is a Number
     * @param number String to test
     * @return true if the String is a Number
     */
    private boolean isNumber(String number) {
        return number.matches(REGEX_VALIDE_NUMBER);
    }

        /**
     * Test if the String is a Calculatable
     * @param value String to test
     * @return true if the String is a Calculatable
     */
    private boolean isCalculatable(String value) {
        return testBreacketsCount(value) && testBreackets(value);
    }


    /**
     * Test if there is an equal amount of brackets
     * @param value String to test
     * @return true if there is an equal amount of brackets
     */
    private boolean testBreacketsCount(String value) {
        int count = 0;


        for(int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '(') count++;
            else if (value.charAt(i) == ')') count--;
        }

        return count == 0;
    }

    /**
     * Test if the brackets are correct and the Content is calculatable
     * @param value String to test
     * @return true if the brackets are correct and the Content is calculatable
     */
    private boolean testBreackets(String value) {
        boolean testResult = true;
        String toTest = "";
        int begin;
        int end;


        if(value.contains("(") && value.contains(")")) {

            while (value.contains("(") && value.contains(")")) {
                begin      = value.lastIndexOf("(");
                end        = value.lastIndexOf(toTest, value.indexOf(")"));
                toTest     = value.substring(begin+1, end);
                value      = value.substring(0, begin) + 1 + value.substring(end+1, value.length());
                testResult = testResult && testBreackets(toTest);
            }

        } 

        if (value.contains("(") || value.contains(")")) {
            return false;
        }

        return value.matches(CALCULATABLE);
    }
    
}
