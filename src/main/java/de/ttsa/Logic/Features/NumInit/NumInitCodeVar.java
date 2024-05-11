package de.ttsa.Logic.Features.NumInit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class NumInitCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        toTest = toTest.strip();
        toTest = toTest.replaceAll(" ", "");

        String varName = toTest.split("=")[0].strip();
        String varValue = toTest.split("=")[1].strip();
        String var;

        if(!opCodeVar.isNumName(varName)) return false;

        while(!varValue.matches("[^a-zA-Z]*")) {
            var = getVarValue(varValue);
            if(!opCodeVar.isNumName(var)) return false;
            varValue = varValue.replaceFirst(var, "1");
        }
        return true;
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
