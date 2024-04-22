package de.ttsa.Logic.Features.If;

import java.util.ArrayList;
import java.util.List;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.IfTypes;
import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Parents.CompilerStructMethods;

public class IfCompiler extends CompilerStructMethods {

    private List<Integer> blockSizes;

    public IfCompiler() {
        blockSizes = new ArrayList<>();
    }

    @Override
    public String compile(List<String> lines, int blockStart) {
        StringBuilder result = getStartCode(Index.IF);

        result.append(calculateBlocks(getIfCodeArgs(lines, blockStart, getBlockEnd(lines, blockStart))));
        return result.toString();
    }

    private List<String> getIfCodeArgs(List<String> lines, int blockStart, int blockEnd) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> content = new ArrayList<>();
        String condition = "";
        boolean isFirst = true;
        for (int i=blockStart; i<blockEnd; i++) {
            if ((lines.get(i).startsWith(CompilerSyntax.IF.toString()) || lines.get(i).startsWith("} Else If") || lines.get(i).startsWith("} Else")) && lines.get(i).endsWith(CompilerSyntax.BLOCK_START.toString())) {
                if(!isFirst) {
                    result.add(condition);
                    blockSizes.add(getBlockContentSize(content));
                    content.clear();
                }
                
                isFirst = false;
                condition = lines.get(i).substring(lines.get(i).indexOf(CompilerSyntax.COMMAND.toString()) + 1, lines.get(i).lastIndexOf(CompilerSyntax.BLOCK_START.toString())).strip();
                lines.remove(i);
                blockEnd--;
                i--;
            } else {
                content.add(lines.get(i));
            }
        }
        result.add(condition);
        blockSizes.add(getBlockContentSize(content));
        
        return result;
    }

    private String calculateBlocks(List<String> conditions) {
        StringBuilder compiled = new StringBuilder();
        int value;

        for (int i=0; i<conditions.size(); i++) {
            value = blockSizes.get(i);

            compiled.append(calculateCondition(conditions.get(i)));
            compiled.append(Seperators.IF_NUM.getSeperator());
            
            compiled.append(value);
            compiled.append(Seperators.IF_ELSE.getSeperator());
        }
        compiled.delete(compiled.length()-2, compiled.length());
        return compiled.toString();
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
        //TODO: Implement
        return null;
    }

    private String splitAtMatch(String toSplit, String[] matches) {
        for (String match : matches) {
            if(toSplit.contains(match)) {
                return toSplit.substring(0, toSplit.indexOf(match));
            }
        }
        return toSplit;
    }

    private int getBlockEnd(List<String> lines, int blockStart) {
        int blockEnd = blockStart;
        int blocks = 0;
        String line = "";
        for (int i = blockStart; i < lines.size(); i++) {
            line = lines.get(i);
            if(line.contains("{")) {
                blocks++;
            }
            if(line.contains("}")) {
                blocks--;
            }
            if(blocks == 0) {
                lines.remove(i);
                blockEnd = i;
                break;
            }
        }
        return blockEnd;
    }
    
}
