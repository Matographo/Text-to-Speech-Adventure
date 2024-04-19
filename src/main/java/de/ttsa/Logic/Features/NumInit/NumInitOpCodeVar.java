package de.ttsa.Logic.Features.NumInit;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeRegex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class NumInitOpCodeVar implements OpCodeVarTestable {

    OpCodeVar opCodeVar;

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        this.opCodeVar = opCodeVar;
        String[] arg   = toTest.split(OpCodeSeperators.NUMBER_DEC.getSeperator());
        String numName = arg[0];
        String value   = arg[1];


        if(!opCodeVar.isVarName(numName))              return false;

        if(!value.contains("*") && !value.contains("/") && !value.contains("-") && !value.contains("+")) {
            if(!isNumber(value) && !isNumVar(value)) return false;
            else return true;
        }

        return isCalculatableVar(value);
    }


        /**
     * Test if the String is a Number
     * @param number String to test
     * @return true if the String is a Number
     */
    private boolean isNumber(String number) {
        return number.matches(OpCodeRegex.VALIDE_NUMBER.toString());
    }

    /**
     * Test if the String is a Number Variable
     * @param name String to test
     * @return true if the String is a Number Variable
     */
    private boolean isNumVar(String name) {
        return !isNumber(name) && opCodeVar.isVarName(name);
    }

        /**
     * Test if the String is a Calculatable Variable
     * @param value String to test
     * @return true if the String is a Calculatable Variable
     */
    private boolean isCalculatableVar(String value) {
        String[] values = value.split("[\\+\\-\\*/\\(\\)]");
        

        for(String val : values) {
            if(val.equals("")) continue;
            if(!isNumber(val) && !isNumVar(val)) return false;
        }

        return true;
    }
    
}
