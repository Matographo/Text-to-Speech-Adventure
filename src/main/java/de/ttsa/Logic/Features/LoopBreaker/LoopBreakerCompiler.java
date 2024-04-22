package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Enums.Index;
import de.ttsa.Parents.CompilerLineMethods;


public class LoopBreakerCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(Index.LOOP_BREAKER).toString();
    }
    
}
