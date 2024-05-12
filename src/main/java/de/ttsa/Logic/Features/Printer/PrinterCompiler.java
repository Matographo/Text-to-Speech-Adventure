package de.ttsa.Logic.Features.Printer;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerLineMethods;

public class PrinterCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        StringBuilder commands = new StringBuilder(getWithoutCommand(line));

        StringBuilder compiled = getStartCode(Index.SAY);
        compiled.append(getSay(commands));
        return compiled.toString();
    }

    private String getSay(StringBuilder commands) {
        StringBuilder endCommand = new StringBuilder();
        String subCommand = "";
        int cutIndex;
        while (commands.length() > 0) {
            if (commands.toString().startsWith("\'")) {
                cutIndex = commands.substring(1).indexOf("\'") + 1;
                subCommand = commands.substring(1, cutIndex);
                endCommand.append(subCommand);
                commands.delete(0, cutIndex + 1);
            } else {
                cutIndex = commands.indexOf("\'");
                if (cutIndex != -1) {
                    subCommand = commands.substring(0, cutIndex);
                } else {
                    subCommand = commands.toString();
                }
                endCommand.append("\"" + subCommand + "\"");
                if (cutIndex != -1) {
                    commands.delete(0, cutIndex);
                } else {
                    commands.setLength(0);
                }
            }
            if (commands.length() > 0) {
                endCommand.append(Seperators.SAY.getSeperator());
            }
        }

        return endCommand.toString();
    }

    
}
