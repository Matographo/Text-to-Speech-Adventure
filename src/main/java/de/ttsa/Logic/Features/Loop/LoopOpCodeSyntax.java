package de.ttsa.Logic.Features.Loop;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class LoopOpCodeSyntax extends OpCode implements OpCodeTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        String argsTyp2 = arg.substring(0, arg.indexOf(OpCodeSeperators.IF_NUM.getSeperator()));


        return testIfSyntaxSwitch(arg) || argsTyp2.matches(REGEX_LOOP);
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxSwitch(String args) {
        OpCodeIfTypes type = OpCodeIfTypes.convert(args.charAt(0));
        args   = args.substring(1, args.indexOf(OpCodeSeperators.IF_NUM.getSeperator()));
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
