package de.ttsa.Logic.Features.Printer;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.CompilerLine;

public class PrinterCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        StringBuilder commands = new StringBuilder(getWithoutCommand(line));

        StringBuilder compiled = getStartCode(OpCodeIndex.SAY);
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
                    commands.delete(cutIndex, commands.length());
                } else {
                    commands.setLength(0);
                }
            }
            if (commands.length() > 0) {
                endCommand.append(OpCodeSeperators.SAY.getSeperator());
            }
        }

        return endCommand.toString();
    }

    
}
