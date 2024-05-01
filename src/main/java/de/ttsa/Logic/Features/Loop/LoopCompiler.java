package de.ttsa.Logic.Features.Loop;

import java.util.List;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.IfTypes;
import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Parents.CompilerStructMethods;

public class LoopCompiler extends CompilerStructMethods {

    @Override
    public String compile(List<String> lines, int blockStart) {
        String commands = lines.get(blockStart).substring(lines.get(blockStart).indexOf(CompilerSyntax.COMMAND.toString()) + 1, lines.get(blockStart).lastIndexOf(CompilerSyntax.BLOCK_START.toString())).strip();
        lines.remove(blockStart);

        StringBuilder compiled = getStartCode(Index.LOOP);

        switch (getLoopMode(commands)) {
            case 'n':
                compiled.append(commands);
                break;
            case 't':
                compiled.append("true");
                break;
            case 'v':
                compiled.append(commands);
                break;
            case 'c':
                compiled.append(calculateCondition(commands));
                break;
            default:
                break;
        }

        compiled.append(Seperators.LOOP.getSeperator());

        compiled.append(getBlockContentSize(lines, blockStart));

        return compiled.toString();
    }

    private char getLoopMode(String commands) {
        if(commands.matches("\\d+")) {
            return 'n';
        } else if(commands.equals("true")) {
            return 't';
        } else if(commands.matches("[a-zA-Z]+\\w*")) {
            return 'v';
        } else {
            return 'c';
        }
    }

    private String calculateCondition(String condition) {
        condition = condition.replaceAll(" ", "");
        StringBuilder compiled = new StringBuilder();
        IfTypes mode = calculateConditionMode(condition);
        
        compiled.append(mode.getType());
        switch(mode) {
            case NUMBER -> compiled.append(calculateIfNumber(condition));
            case STRING -> compiled.append(calculateIfString(condition));
            case INPUT -> compiled.append(calculateIfInput(condition));
            case NONE -> compiled.deleteCharAt(compiled.length()-1);
        }
        return compiled.toString();
    }

    private IfTypes calculateConditionMode(String conditionString) {
        if(conditionString.equals("")) return IfTypes.NONE;

        String condition = splitAtMatch(conditionString, new String[]{"==", "!=", ">=", "<=", ">", "<"});

        if(Compiler.variables.get("NUMBER").contains(condition) || condition.matches("\\d")) return IfTypes.NUMBER;
        else if(Compiler.variables.get("STRING").contains(condition) || condition.startsWith("\"") && condition.endsWith("\"")) return IfTypes.STRING;
        else if(conditionString.startsWith(CompilerSyntax.INPUT.toString())) return IfTypes.INPUT;
        throw new IllegalArgumentException("Syntax Error: " + condition);
    }

    private String calculateIfNumber(String condition) {
        return condition;
    }

    private String calculateIfString(String condition) {
        return condition;
    }

    private String calculateIfInput(String condition) {
        return condition;
    }

    private String splitAtMatch(String toSplit, String[] matches) {
        for (String match : matches) {
            if(toSplit.contains(match)) {
                return toSplit.substring(0, toSplit.indexOf(match));
            }
        }
        return toSplit;
    }

    private int getBlockContentSize(List<String> lines) {
        int size = lines.size();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(CompilerSyntax.BLOCK_END.toString())) {
                size--;
            }
        }
        return size;
    }

    private int getBlockContentSize(List<String> lines, int blockStart) {
        int blockCount = 1;
        int size = 0;
        String line = "";
        for (int i = blockStart; i < lines.size(); i++) {
            line = lines.get(i);
            blockCount += countChar(line, CompilerSyntax.BLOCK_START.toString().charAt(0));
            if (lines.get(i).contains(CompilerSyntax.BLOCK_END.toString())) {
                size--;
                blockCount -= countChar(line, CompilerSyntax.BLOCK_END.toString().charAt(0));
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

    private int countChar(String string, char c) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
    
}
