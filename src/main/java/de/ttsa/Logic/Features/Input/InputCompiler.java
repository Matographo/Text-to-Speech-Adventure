package de.ttsa.Logic.Features.Input;

import de.ttsa.Enums.Index;
import de.ttsa.Parents.CompilerLineMethods;

public class InputCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(Index.INPUT).toString();
    }
    
}
