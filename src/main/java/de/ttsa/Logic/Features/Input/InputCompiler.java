package de.ttsa.Logic.Features.Input;

import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Parents.CompilerLineMethods;

public class InputCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(OpCodeIndex.INPUT).toString();
    }
    
}
