package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class StrInitOpCodeVar implements OpCodeVarTestable {

    private OpCodeVar opCodeVar;

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        this.opCodeVar = opCodeVar;
        String args;
        String[] strDecArgs = toTest.split(Seperators.STR.getSeperator());


        if(!isStrVar(strDecArgs[0]))                          return false;
        String[] tokens = strDecArgs[1].split(Seperators.STR_CONTENT.getSeperator());
        for(String token : tokens) {
            if(!isStrVar(token) && !isStr(token)) return false;
        }

        return true;
    }

    /**
     * Test if the String is a String Variable
     * @param name String to test
     * @return true if the String is a String Variable
     */
    private boolean isStrVar(String name) {
        return !isNumber(name) && opCodeVar.isStrName(name);
    }

    /**
     * Test if the String is a Number
     * @param number String to test
     * @return true if the String is a Number
     */
    private boolean isNumber(String number) {
        return number.matches(Regex.VALIDE_NUMBER.toString());
    }

    /**
     * Test if the String is a String
     * @param name String to test
     * @return true if the String is a String
     */
    private boolean isStr(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }
    
}
