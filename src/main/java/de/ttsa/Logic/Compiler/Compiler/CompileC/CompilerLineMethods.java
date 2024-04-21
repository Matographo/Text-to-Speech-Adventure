package de.ttsa.Logic.Compiler.Compiler.CompileC;

import de.ttsa.Logic.Enums.CompilerSyntax;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.CompilerLine;

public abstract class CompilerLineMethods implements CompilerLine {
    protected StringBuilder getStartCode(OpCodeIndex index) {
        return new StringBuilder().append(index.getIndex() + OpCodeSeperators.COMMAND.getSeperator());
    }

    protected String getWithoutCommand(String line) {
        return line.substring(line.indexOf(CompilerSyntax.COMMAND.toString()) + 1).strip();
    }

}
