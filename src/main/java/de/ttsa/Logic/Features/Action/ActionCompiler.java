package de.ttsa.Logic.Features.Action;

import java.util.List;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Parents.CompilerStructMethods;

public class ActionCompiler extends CompilerStructMethods {

    @Override
    public String compile(List<String> lines, int blockStart) {
        StringBuilder commands = new StringBuilder(lines.get(blockStart).substring(lines.get(blockStart).indexOf(CompilerSyntax.ACTION.toString()) + CompilerSyntax.ACTION.toString().length() + 1, lines.get(blockStart).lastIndexOf(CompilerSyntax.BLOCK_START.toString())).strip());
        lines.remove(blockStart);

        StringBuilder compiled = getStartCode(OpCodeIndex.ACTION);
        compiled.append(commands.substring(0, commands.indexOf("(")).strip());
        compiled.append(OpCodeSeperators.ACTION.getSeperator());
        compiled.append(getActionParams(commands.substring(commands.indexOf("(") + 1, commands.lastIndexOf(")")).strip()));
        compiled.append(OpCodeSeperators.ACTION.getSeperator());


        compiled.append(getBlockContentSize(lines, blockStart));
        return compiled.toString();
    }

    private String getActionParams(String commands) {
        StringBuilder result = new StringBuilder();
        if(commands.equals("")) return "-";
        String[] args = commands.split(OpCodeSeperators.ACTION_ARGS.getSeperator());
        char argType;
        for(String arg : args) {
            arg = arg.strip();
            switch (argType = getArgType(arg)) {
                case 'n':
                    result.append(argType);
                    result.append(getArgName(arg));
                    break;
                case 's':
                    result.append(argType);
                    result.append(getArgName(arg));
                    break;
                default:
                    return "-";
            }
            result.append(OpCodeSeperators.ACTION_ARGS.getSeperator());
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private char getArgType(String arg) {
        if(arg.substring(0, arg.indexOf(" ")).equals(CompilerSyntax.NUM_DEC.toString())) {
            return 'n';
        } else if(arg.substring(0, arg.indexOf(" ")).equals(CompilerSyntax.STR_DEC.toString())) {
            return 's';
        } else {
            return '-';
        }
    }

    private String getArgName(String arg) {
        return arg.substring(arg.indexOf(" ") + 1).strip();
    }

    private int getBlockContentSize(List<String> lines, int blockStart) {
        int size = 0;
        int blockCount = 1;
        for (int i = blockStart; i < lines.size(); i++) {
            if(lines.get(i).contains(CompilerSyntax.BLOCK_START.toString())) {
                blockCount++;
            }
            if (lines.get(i).contains(CompilerSyntax.BLOCK_END.toString())) {
                size--;
                blockCount--;
            }
            if (blockCount == 0) {
                size++;
                lines.remove(i);
                break;
            }
            size++;
        }
        return size;
    }
    
}
