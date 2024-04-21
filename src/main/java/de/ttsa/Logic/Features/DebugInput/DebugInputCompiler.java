package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Parents.CompilerLineMethods;

public class DebugInputCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(OpCodeIndex.DEBUG);
        compiled.append(compileDebugCommand(new StringBuilder(commands)));
        return compiled.toString();
    }

    private String compileDebugCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        while (line.toString().contains("'")) {
            endString.append("\"" + line.substring(0, line.indexOf("'")) + "\"");
            line.delete(0, line.indexOf("'") + 1);

            endString.append(OpCodeSeperators.STR_CONTENT.getSeperator());

            endString.append(line.substring(0, line.indexOf("'")).strip());
            line.delete(0, line.indexOf("'") + 1);

            endString.append(OpCodeSeperators.STR_CONTENT.getSeperator());
        }
        endString.append("\"" + line + "\"");
        return endString.toString();
    }
    
}
