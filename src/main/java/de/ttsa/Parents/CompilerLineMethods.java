package de.ttsa.Parents;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.CompilerLine;

public abstract class CompilerLineMethods implements CompilerLine {
    protected StringBuilder getStartCode(Index index) {
        return new StringBuilder().append(index.getIndex());
    }

    protected String getWithoutCommand(String line) {
        return line.substring(line.indexOf(CompilerSyntax.COMMAND.toString()) + 1).strip();
    }

}
