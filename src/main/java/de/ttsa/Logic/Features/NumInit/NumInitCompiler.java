package de.ttsa.Logic.Features.NumInit;

import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Parents.CompilerLineMethods;

public class NumInitCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        StringBuilder commands = new StringBuilder(getWithoutCommand(line));

        StringBuilder compiled = getStartCode(OpCodeIndex.NUM_INIT);
        compiled.append(compileNumDecCommand(commands));
        return compiled.toString();
    }

    private String compileNumDecCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        endString.append(line.substring(0, line.indexOf("=")).strip());
        endString.append(OpCodeSeperators.NUMBER_VARIABLE.getSeperator());
        line.delete(0, line.indexOf("=") + 1);
        endString.append(line.toString().replaceAll(" ", "").strip());
        return endString.toString();
    }
    
}
