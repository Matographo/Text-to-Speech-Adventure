package de.ttsa.Parents;

import de.ttsa.Enums.Index;
import de.ttsa.Interfaces.CompilerStruct;

public abstract class CompilerStructMethods implements CompilerStruct {
    
    protected StringBuilder getStartCode(Index index) {
        return new StringBuilder().append(index.getIndex());
    }

    protected String getWithoutCommand(String line) {
        return line.substring(2).strip();
    }
}
