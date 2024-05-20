package de.ttsa.Logic.Features.NumInit;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Parents.StringMethods;

public class NumInitCodeSyntax extends StringMethods implements CodeSyntaxTestable {

    private static Pattern patternName = Pattern.compile(Regex.VALIDE_NAME.toString());
    private static Pattern patternNumber = Pattern.compile(Regex.VALIDE_NUMBER.toString());
    private static Pattern patternCalculatable = Pattern.compile(Regex.CALCULATABLE.toString());

    @Override
    public boolean testCode(String code) {
        code = code.replaceAll(" ", "");
        if(!code.contains("=")) return false;
        String[] args = code.split("=");
        if(!patternName.matcher(args[0].strip()).matches()) return false;
        if(!isEqualOccurence(args[1].strip(), '(', ')')) return false;
        return testCalc(args[1].strip());
    }

    private boolean testCalc(String code) {
        if(!code.contains("*") && !code.contains("/") && !code.contains("-") && !code.contains("+")) {
            if(!patternNumber.matcher(code).matches() && !patternName.matcher(code).matches()) return false;
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

        return patternCalculatable.matcher(value).matches();
    }
    
}
