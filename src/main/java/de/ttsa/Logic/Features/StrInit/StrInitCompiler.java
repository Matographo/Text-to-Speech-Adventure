package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerLineMethods;

public class StrInitCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(Index.STR_INIT);
        compiled.append(compileStrDecCommand(new StringBuilder(commands)));
        return compiled.toString();
    }

    private String compileStrDecCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        endString.append(line.substring(0, line.indexOf("=")).strip());
        endString.append(Seperators.STR.getSeperator());
        endString.append(calculateStrDec(new StringBuilder(line.substring(line.indexOf("=") + 1).strip())));
        return endString.toString();
    }

    private String calculateStrDec(StringBuilder line) {
        StringBuilder endString = new StringBuilder();
        while (line.toString().contains("'")) {
            endString.append("\"" + line.substring(0, line.indexOf("'")) + "\"");
            line.delete(0, line.indexOf("'") + 1);

            endString.append(Seperators.STR_CONTENT.getSeperator());

            endString.append(line.substring(0, line.indexOf("'")).strip());
            line.delete(0, line.indexOf("'") + 1);

            endString.append(Seperators.STR_CONTENT.getSeperator());
        }
        endString.append("\"" + line + "\"");
        return endString.toString();
    }
    
}
