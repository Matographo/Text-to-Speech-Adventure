package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Parents.CompilerLineMethods;

public class NumDecCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);
        String varName = "";

        StringBuilder compiled = getStartCode(OpCodeIndex.NUMBER_DEC);
        if(commands.contains("=") || commands.contains(" ")) {
            String[] parts;

            if (commands.contains("=")) parts = commands.split("=");
            else                        parts = commands.split(" ");

            varName = parts[0].strip();
            compiled.append(varName);
            compiled.append(OpCodeSeperators.NUMBER_VARIABLE.getSeperator());
            compiled.append(parts[1].strip());
        } else {
            varName = commands;
            compiled.append(varName);
            compiled.append(OpCodeSeperators.NUMBER_VARIABLE.getSeperator());
            compiled.append("0");
        }
        Compiler.variables.get("NUMBER").add(varName);
        return compiled.toString();
    }
    
}
