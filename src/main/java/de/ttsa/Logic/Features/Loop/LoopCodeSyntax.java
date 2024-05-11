package de.ttsa.Logic.Features.Loop;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class LoopCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        boolean result = false;
        String condition = code.substring(0, code.indexOf("{")).strip().replaceAll(" ", "");
        result |= condition.matches(Regex.VALIDE_NAME.toString());
        result |= condition.matches(Regex.VALIDE_NUMBER.toString());
        result |= testIfSyntaxNum(condition);
        result |= testIfSyntaxStr(condition);
        result |= testIfSyntaxIn(condition);
        return result;
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
        return args.matches(Regex.IF_NUMBER_CODE.toString());
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxStr(String args) {
        return args.matches(Regex.IF_STRING_CODE.toString());
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxIn(String args) {
        return args.matches(Regex.IF_INPUT_CODE.toString());
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
        return args.matches(Regex.IF_INNER_BRECKETS_CODE.toString());
    }

    private String removeInnerBrecketsAndSubstitut(String args, String substitut) {
        int start = args.lastIndexOf("(");
        String startStr = args.substring(0, start);
        args = args.substring(start+1);
        String endStr = args.substring(args.indexOf(")") + 1);
        return startStr + substitut + endStr;
    }
    
}
