package de.ttsa.Logic.Features.StrInit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class StrInitCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        toTest = toTest.strip();
        toTest = toTest.replaceAll(" ", "");

        String varName = toTest.split("=")[0].strip();
        String varValue = toTest.split("=")[1].strip();
        String var;

        if(!opCodeVar.isStrName(varName)) return false;

        if(varValue.contains("'")) {
            return opCodeVar.isStrName(varValue.substring(1, varValue.length()-1));
        }

        return true;
    }
    
}
