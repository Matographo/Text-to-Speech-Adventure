package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Parents.CompilerLineMethods;


public class LoopBreakerCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(OpCodeIndex.LOOP_BREAKER).toString();
    }
    
}
