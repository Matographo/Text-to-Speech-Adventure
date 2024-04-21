package de.ttsa.Logic.Compiler.Compiler.CompileC;

import de.ttsa.Logic.ClassTools.CompilerSyntax;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.CompilerStruct;

public abstract class CompilerStructMethods extends CompilerSyntax implements CompilerStruct {
    
    protected StringBuilder getStartCode(OpCodeIndex index) {
        return new StringBuilder().append(index.getIndex() + OpCodeSeperators.COMMAND.getSeperator());
    }

    protected String getWithoutCommand(String line) {
        return line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
    }
}
