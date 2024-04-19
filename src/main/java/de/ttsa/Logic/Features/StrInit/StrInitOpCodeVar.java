package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class StrInitOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        toTest = toTest.substring(0, toTest.indexOf(":"));
        String[] tests;
        if (toTest.contains("!=")) {
            tests = toTest.split("!=");
        } else {
            tests = toTest.split("==");
        }


        if(!opCodeVar.isStrName(tests[0]) && !tests[0].startsWith("\"") && !tests[0].endsWith("\"")) return false;
        if(!opCodeVar.isStrName(tests[1]) && !tests[1].startsWith("\"") && !tests[1].endsWith("\"")) return false;

        return true;
    }
    
}
