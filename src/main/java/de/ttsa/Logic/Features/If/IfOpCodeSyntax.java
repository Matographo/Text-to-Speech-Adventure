package de.ttsa.Logic.Features.If;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class IfOpCodeSyntax extends OpCode implements OpCodeTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        String[] toTest    = arg.split(IF_ELSE_SEPERATOR);
        boolean testResult = true;


        for(int i=0; i < toTest.length; i++) {
            if(i == toTest.length - 1) {
                testResult = testResult && isTestableElse(toTest[i]);
            } else {
                testResult = testResult && testIfSyntaxSwitch(toTest[i]);
            }
        }

        return testResult;
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean isTestableElse(String test) {
        if(test.startsWith(":") && isNumber(test.substring(1))) return true;

        return testIfSyntaxSwitch(test);
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxSwitch(String args) {
        OpCodeIfTypes type = OpCodeIfTypes.convert(args.charAt(0));
        args   = args.substring(1, args.indexOf(IF_NUM_SEPERATOR));
        boolean testResult;

        switch(type) {
            case NUMBER -> testResult = testIfSyntaxNum(args);
            case STRING -> testResult = testIfSyntaxStr(args);
            case INPUT ->  testResult = testIfSyntaxIn(args);
            default ->        testResult = false;
        }

        return testResult;
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
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxNum(String args) {
        while(hasBrackets(args)) {
            if(!testIfSyntaxNumInnerBreckets(getInnerBreckets(args))) return false;
            args = removeInnerBrecketsAndSubstitut(args, "1");
        }
        return args.matches(REGEX_IF_NUMBER);
    }

        /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxStr(String args) {
        return args.matches(REGEX_IF_STRING);
    }

        /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxIn(String args) {
        return args.matches(REGEX_IF_INPUT);
    }

    private boolean hasBrackets(String args) {
        return args.contains("(") || args.contains(")");
    }

    private String getInnerBreckets(String args) {
        int start = args.lastIndexOf("(") + 1;
        args = args.substring(start);
        return args.substring(0, args.indexOf(")"));
    }

    private boolean testIfSyntaxNumInnerBreckets(String args) {
        return args.matches(REGEX_IF_INNER_BRECKETS);
    }

    private String removeInnerBrecketsAndSubstitut(String args, String substitut) {
        int start = args.lastIndexOf("(");
        String startStr = args.substring(0, start);
        args = args.substring(start+1);
        String endStr = args.substring(args.indexOf(")") + 1);
        return startStr + substitut + endStr;
    }
    
}
