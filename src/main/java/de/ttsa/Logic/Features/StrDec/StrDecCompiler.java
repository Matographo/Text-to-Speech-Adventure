package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Parents.CompilerLineMethods;

public class StrDecCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);
        String varName = "";

        StringBuilder compiled = getStartCode(Index.STR_DEC);
        if(commands.contains("=") || commands.contains(" ")) {
            String[] parts;

            if (commands.contains("=")) parts = commands.split("=");
            else {
                parts = new String[2];
                parts[0] = commands.substring(0, commands.indexOf(" "));
                parts[1] = commands.substring(commands.indexOf(" ") + 1).toString();
            }

            varName = parts[0].strip();
            compiled.append(varName);
            compiled.append(Seperators.STR.getSeperator());
            compiled.append(parts[1].strip());
        } else {
            varName = commands;
            compiled.append(varName);
            compiled.append(Seperators.NUMBER_STRING.getSeperator());
        }

        Compiler.variables.get("STRING").add(varName);
        return compiled.toString();
    }
    
}
