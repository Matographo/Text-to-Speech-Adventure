package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerLineMethods;

public class ActionCallCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(Index.ACTION_CALL);
        if(commands.strip().matches("[a-zA-Z]+\\w*")) {
            compiled.append(commands.strip());
            commands = "";
        } else {
            compiled.append(commands.substring(0, commands.indexOf(" ")).strip());
            commands = commands.substring(commands.indexOf(" ") + 1).strip();
        }
        
        compiled.append(Seperators.ACTION.getSeperator());

        compiled.append(getActionCallArgs(commands));
        return compiled.toString();
    }

    private String getActionCallArgs(String args) {
        StringBuilder result = new StringBuilder();
        String[] argsOfCall = args.split(Seperators.ACTION_ARGS.getSeperator());
        if(args.isBlank()) {
            return "-";
        }
        for(String arg : argsOfCall) {
            result.append(arg.strip());
            result.append(Seperators.ACTION_ARGS.getSeperator());
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    
}
