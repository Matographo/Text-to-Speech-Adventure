package de.ttsa.Logic.Features.Loop;

import de.ttsa.Enums.IfTypes;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class LoopOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        String argsTyp2 = arg.substring(0, arg.indexOf(Seperators.IF_NUM.getSeperator()));


        return testIfSyntaxSwitch(arg) || argsTyp2.matches(Regex.LOOP_OPCODE.toString());
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxSwitch(String args) {
        IfTypes type = IfTypes.convert(args.charAt(0));
        args   = args.substring(1, args.indexOf(Seperators.IF_NUM.getSeperator()));
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
        return args.matches(Regex.IF_NUMBER_OPCODE.toString());
    }

        /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxStr(String args) {
        return args.matches(Regex.IF_STRING_OPCODE.toString());
    }

        /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxIn(String args) {
        return args.matches(Regex.IF_INPUT_OPCODE.toString());
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
        return args.matches(Regex.IF_INNER_BRECKETS_OPCODE.toString());
    }

    private String removeInnerBrecketsAndSubstitut(String args, String substitut) {
        int start = args.lastIndexOf("(");
        String startStr = args.substring(0, start);
        args = args.substring(start+1);
        String endStr = args.substring(args.indexOf(")") + 1);
        return startStr + substitut + endStr;
    }
    
}
