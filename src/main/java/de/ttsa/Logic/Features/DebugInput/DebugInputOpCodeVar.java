package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class DebugInputOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return isValidName(toTest) && opCodeVar.isStrName(toTest) || !isValidName(toTest);
    }

    /**
     * Test if the name is valid
     * @param name The name to test
     * @return true if the name is valid
     */
    private boolean isValidName(String name) {
        return name.matches(Regex.VALIDE_NAME.toString());
    }
    
}
