package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Logic.Compiler.Compiler.CompileC.Compiler;
import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;

public class StrDecCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);
        String varName = "";

        StringBuilder compiled = getStartCode(OpCodeIndex.STR_DEC);
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
            compiled.append(OpCodeSeperators.STR.getSeperator());
            compiled.append(parts[1].strip());
        } else {
            varName = commands;
            compiled.append(varName);
            compiled.append(OpCodeSeperators.NUMBER_STRING.getSeperator());
        }

        Compiler.variables.get("STRING").add(varName);
        return compiled.toString();
    }
    
}
