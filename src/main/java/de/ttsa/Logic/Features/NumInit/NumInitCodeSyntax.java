package de.ttsa.Logic.Features.NumInit;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Parents.StringMethods;

public class NumInitCodeSyntax extends StringMethods implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        code = code.replaceAll(" ", "");
        if(!code.contains("=")) return false;
        String[] args = code.split("=");
        if(!args[0].strip().matches(Regex.VALIDE_NAME.toString())) return false;
        if(!isEqualOccurence(args[1].strip(), '(', ')')) return false;
        return testCalc(args[1].strip());
    }

    private boolean testCalc(String code) {
        if(!code.contains("*") && !code.contains("/") && !code.contains("-") && !code.contains("+")) {
            if(!code.matches(Regex.VALIDE_NUMBER.toString()) && !code.matches(Regex.VALIDE_NAME.toString())) return false;
            else return true;
        }

        return isCalculatable(code);
    }

    private boolean isCalculatable(String value) {
        return isEqualOccurence(value, '(', ')') && testBreackets(value);
    }

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

        return value.matches(Regex.CALCULATABLE.toString());
    }
    
}
