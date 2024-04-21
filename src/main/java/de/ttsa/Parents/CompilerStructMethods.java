package de.ttsa.Parents;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Interfaces.CompilerStruct;

public abstract class CompilerStructMethods implements CompilerStruct {
    
    protected StringBuilder getStartCode(OpCodeIndex index) {
        return new StringBuilder().append(index.getIndex() + OpCodeSeperators.COMMAND.getSeperator());
    }

    protected String getWithoutCommand(String line) {
        return line.substring(line.indexOf(CompilerSyntax.COMMAND.toString()) + 1).strip();
    }
}
