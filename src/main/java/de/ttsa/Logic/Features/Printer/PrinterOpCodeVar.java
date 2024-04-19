package de.ttsa.Logic.Features.Printer;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class PrinterOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] allArgs   = toTest.split(OpCodeSeperators.SAY.getSeperator());
        boolean testResult = true;


        for(String arg : allArgs) {
            if(arg.startsWith("\"") && arg.endsWith("\"")) continue;
            if(!opCodeVar.isVarName(arg)) {
                return false;
            }
        }

        return testResult;
    }
    
}
