package de.ttsa.Logic.Features.If;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Parents.StringMethods;

public class IfCodeVar extends StringMethods implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        boolean result = true;
        boolean isNum;
        String var;
        toTest = toTest.substring(0, toTest.lastIndexOf("{")).strip();
        toTest = toTest.replaceAll(" ", "");
        if(toTest.contains("==")) {
            String[] parts = toTest.split("==");

            if(parts[0].matches("[a-zA-Z]+\\w*")) {
                isNum = opCodeVar.isNumName(parts[0]);
                if(!isNum) {
                    result = opCodeVar.isStrName(parts[0]);
                }
            } else {
                if(parts[0].matches("\\d+")) {
                    isNum = true;
                } else {
                    isNum = false;
                }
            }
            if(!isNum) {
                if(parts[1].matches("'[a-zA-Z]+\\w*'")) {
                    result &= opCodeVar.isStrName(parts[1].substring(1, parts[1].length()-1));
                } else {
                    result &= parts[1].matches("\"[a-zA-Z]+\"");
                }
            } else {
                parts[1] = parts[1].replaceAll(" ", "");
                while(!parts[1].matches("[^a-zA-Z]*")) {
                    var = getVarValue(parts[1]);
                    if(!opCodeVar.isNumName(var)) return false;
                    parts[1] = parts[1].replaceFirst(var, "1");
                }
            }
        } else {
            while(toTest.contains("'") || toTest.contains("@")) {
                if(toTest.contains("'")) {
                    var = getNextSubstring("'", toTest);
                    result &= opCodeVar.isSetName(var);
                    toTest =toTest.replaceFirst("'" + var + "'", "");
                } else {
                    toTest = toTest.substring(toTest.indexOf("@"));
                    var = getVarValue(toTest);
                    result &= opCodeVar.isStrName(var);
                    toTest = toTest.replaceFirst("@" + var, "");
                }
            }
        }
        return result;
    }

    private String getVarValue(String varValue) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\w*");
        Matcher matcher = pattern.matcher(varValue);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }
    
}
