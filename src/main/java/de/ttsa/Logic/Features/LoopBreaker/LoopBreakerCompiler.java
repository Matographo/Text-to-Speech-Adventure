package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;


public class LoopBreakerCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(OpCodeIndex.LOOP_BREAKER).toString();
    }
    
}
