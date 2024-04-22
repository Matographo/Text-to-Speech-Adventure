package de.ttsa.Parents;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.CompilerStruct;

public abstract class CompilerStructMethods implements CompilerStruct {
    
    protected StringBuilder getStartCode(Index index) {
        return new StringBuilder().append(index.getIndex() + Seperators.COMMAND.getSeperator());
    }

    protected String getWithoutCommand(String line) {
        return line.substring(line.indexOf(CompilerSyntax.COMMAND.toString()) + 1).strip();
    }
}
