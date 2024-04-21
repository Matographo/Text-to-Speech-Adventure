package de.ttsa.Logic.Features.Set;

import java.util.List;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerStructMethods;
import de.ttsa.Logic.Enums.CompilerSyntax;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;

public class SetCompiler extends CompilerStructMethods {

    @Override
    public String compile(List<String> lines, int blockStart) {
        String setName = lines.get(blockStart).substring(lines.get(blockStart).indexOf(CompilerSyntax.SET.toString()) + CompilerSyntax.SET.toString().length() +1, lines.get(blockStart).lastIndexOf(CompilerSyntax.BLOCK_START.toString())).strip();
        lines.remove(blockStart);

        StringBuilder compiled = getStartCode(OpCodeIndex.SET);
        compiled.append(setName);
        compiled.append(OpCodeSeperators.SET_NAME.getSeperator());
        compiled.append(compileSetCommands(lines, blockStart));
        return compiled.toString();
    }

    private String compileSetCommands(List<String> lines, int blockStart) {
        StringBuilder endString = new StringBuilder();
        String line = "";
        for (int i=blockStart; i<lines.size(); i++) {
            line = lines.get(i).strip();
            if(line.startsWith(CompilerSyntax.BLOCK_END.toString())) {
                lines.remove(i);
                break;
            }
            if(line.startsWith("'") && line.endsWith("'")) {
                endString.append(line.substring(1, line.length() - 1));
            } else {
                endString.append("\"" + line + "\"");
            }
            lines.remove(i);
            i--;
            endString.append(OpCodeSeperators.SET.getSeperator());
        }
        endString.deleteCharAt(endString.length() - 1);
        return endString.toString();
    }

}
