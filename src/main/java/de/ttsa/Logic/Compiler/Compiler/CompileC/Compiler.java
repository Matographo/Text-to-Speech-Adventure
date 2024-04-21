package de.ttsa.Logic.Compiler.Compiler.CompileC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import de.ttsa.Logic.ClassTools.CompilerSyntax;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Features.ActionCall.ActionCallCompiler;
import de.ttsa.Logic.Features.DebugInput.DebugInputCompiler;
import de.ttsa.Logic.Features.GameExitScript.GameExitScriptCompiler;
import de.ttsa.Logic.Features.GameLoaderScript.GameLoaderScriptCompiler;
import de.ttsa.Logic.Features.GameSavingScript.GameSavingScriptCompiler;
import de.ttsa.Logic.Features.Input.InputCompiler;
import de.ttsa.Logic.Features.LoopBreaker.LoopBreakerCompiler;
import de.ttsa.Logic.Features.NumDec.NumDecCompiler;
import de.ttsa.Logic.Features.NumInit.NumInitCompiler;
import de.ttsa.Logic.Features.Printer.PrinterCompiler;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperCompiler;
import de.ttsa.Logic.Features.StrDec.StrDecCompiler;
import de.ttsa.Logic.Features.StrInit.StrInitCompiler;

public class Compiler extends CompilerSyntax {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    public static ArrayList<ArrayList<String>> fileContent;
    public static HashMap<String, HashSet<String>> variables;
    private OpCodeIfTypes ifTypes = OpCodeIfTypes.NONE;
    


// ---------------------------------------------- Constructor ------------------------------------------------- //



    public Compiler(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
        variables = new HashMap<>();
        HashSet<String> strVar = new HashSet<>();
        HashSet<String> numVar = new HashSet<>();
        variables.put("STRING", strVar);
        variables.put("NUMBER", numVar);
    }



// -------------------------------------------- Start Method -------------------------------------------------- //



    public ArrayList<ArrayList<String>> compile() {
        ArrayList<ArrayList<String>> compiled = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> line : fileContent) {
            compiled.add(compileFile(line));
        }
        return compiled;
    }



// ------------------------------------------- Compile Chooser ------------------------------------------------ //



    private ArrayList<String> compileFile(ArrayList<String> content) {
        ArrayList<String> compiled = new ArrayList<String>(content.size());
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i).strip();
            if (line.startsWith(SYNTAX_SAY)) {
                compiled.add(new PrinterCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_ROOM)) {
                compiled.addAll(compileRoom(getCodeBlock(i,content)));
                i--;
            } else if (line.startsWith(SYNTAX_SET) && line.endsWith(SYNTAX_BLOCK_START)) {
                compiled.add(compileSet(getCodeBlock(i, content)));
                i--;
            } else if (line.startsWith(SYNTAX_IF)) {
                compiled.addAll(compileIf(getCodeBlock(i, content)));
                i--;
            } else if (line.startsWith(SYNTAX_LOOP) && line.endsWith(SYNTAX_BLOCK_START)) {
                compiled.addAll(compileLoop(getCodeBlock(i, content)));
                i--;
            } else if (line.startsWith(SYNTAX_ACTION) && line.endsWith(SYNTAX_BLOCK_START)) {
                compiled.addAll(compileAction(getCodeBlock(i, content)));
                i--;
            } else if (line.startsWith(SYNTAX_ROOM_JUMPER)) {
                compiled.add(new RoomJumperCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_SAVE)) {
                compiled.add(new GameSavingScriptCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_LOAD)) {
                compiled.add(new GameLoaderScriptCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_EXIT)) {
                compiled.add(new GameExitScriptCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_INPUT)) {
                compiled.add(new InputCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_NUM_VARDEC)) {
                compiled.add(new NumInitCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_NUMBER_VARIABLE)) {
                compiled.add(new NumDecCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_STR_VARDEC)) {
                compiled.add(new StrInitCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_STRING_VARIABLE)) {
                compiled.add(new StrDecCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_LOOP_BREAKER)) {
                compiled.add(new LoopBreakerCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_DEBUG)) {
                compiled.add(new DebugInputCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_LOOP_BREAKER)) {
                compiled.add(new LoopBreakerCompiler().compile(line));
            } else if (line.startsWith(SYNTAX_ACTION_CALL)) {
                compiled.add(new ActionCallCompiler().compile(line));
            } else {
                throw new IllegalArgumentException("Syntax Error: " + line);
            }
        }
        return compiled;
    }




// --------------------------- Compiler Methods ---------------------------------



// ***************************** SAY ********************************************
    private String compileSay(String line) {
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


// ***************************** ROOM *******************************************
    private ArrayList<String> compileRoom(ArrayList<String> lines) {
        ArrayList<String> compiledRoom = new ArrayList<>(lines.size());
        ArrayList<String> roomContent = new ArrayList<>(lines.size());
        String commands = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_ROOM) + SYNTAX_ROOM.length()).strip();
        lines.remove(0);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(SYNTAX_BLOCK_START)).strip();
        }

        StringBuilder compiled = getStartCode(OpCodeIndex.ROOM);
        compiled.append(commands);
        compiled.append(OpCodeSeperators.ROOM.getSeperator());

        roomContent.addAll(compileFile(lines));

        compiled.append(roomContent.size());
        compiledRoom.add(compiled.toString());
        compiledRoom.addAll(roomContent);
        return compiledRoom;
    }


// ***************************** ROOM JUMPER ************************************
    private String compileRoomJumper(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(OpCodeIndex.ROOM_JUMPER);
        compiled.append(commands);
        return compiled.toString();
    }


// ***************************** Num DEC ****************************************
    private String compileNum(String line) {
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
        variables.get("NUMBER").add(varName);
        return compiled.toString();
    }


// ***************************** STR DEC ****************************************
    private String compileStr(String line) {
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

        variables.get("STRING").add(varName);
        return compiled.toString();
    }


// ***************************** NUM INIT ***************************************
    private String compileNumDec(String line) {
        StringBuilder commands = new StringBuilder(getWithoutCommand(line));

        StringBuilder compiled = getStartCode(OpCodeIndex.NUM_INIT);
        compiled.append(compileNumDecCommand(commands));
        return compiled.toString();
    }

    private String compileNumDecCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        endString.append(line.substring(0, line.indexOf("=")).strip());
        endString.append(OpCodeSeperators.NUMBER_VARIABLE.getSeperator());
        line.delete(0, line.indexOf("=") + 1);
        endString.append(line.toString().replaceAll(" ", "").strip());
        return endString.toString();
    }


// ***************************** INPUT ****************************************
    private String compileInput(String line) {
        return getStartCode(OpCodeIndex.INPUT).toString();
    }


// ***************************** IF *******************************************
    private ArrayList<String> compileIf(ArrayList<String> lines) {
        String result = getStartCode(OpCodeIndex.IF).toString();

        ArrayList<String> content = calculateIfBlocks(getBlocks(lines));

        content.set(0, result + content.get(0));
        return content;
    }

    private ArrayList<ArrayList<String>> getBlocks(ArrayList<String> ifBlock) {
        ArrayList<ArrayList<String>> blocks = new ArrayList<>();
        ArrayList<String> block = new ArrayList<>();
        boolean isFirst = true;
        for (String line : ifBlock) {
            if ((line.startsWith(SYNTAX_IF) || line.startsWith("} Else If") || line.startsWith("} Else")) && line.endsWith(SYNTAX_BLOCK_START)) {
                if(!isFirst) {
                    blocks.add(block);
                }
                isFirst = false;
                block = new ArrayList<>();
                block.add(line.substring(line.indexOf(SYNTAX_COMMAND) + 1, line.lastIndexOf(SYNTAX_BLOCK_START)).strip());
            } else if (line.startsWith(SYNTAX_BLOCK_END)) {
                continue;
            } else {
                block.add(line);
            
            }

        }

        blocks.add(block);
        return blocks;
    }

    private ArrayList<String> calculateIfBlocks(ArrayList<ArrayList<String>> blocks) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> compiledFile;
        StringBuilder compiledIf = new StringBuilder();
        String condition = "";


        for (ArrayList<String> block : blocks) {
            condition = block.get(0);
            block.remove(0);

            compiledIf.append(calculateCondition(condition));
            compiledIf.append(OpCodeSeperators.IF_NUM.getSeperator());
            
            compiledFile = compileFile(block);
            result.addAll(compiledFile);
            compiledIf.append(compiledFile.size());
            compiledIf.append(OpCodeSeperators.IF_ELSE.getSeperator());
        }
        compiledIf.delete(compiledIf.length()-2, compiledIf.length());

        result.add(0, compiledIf.toString());
        return result;
    }

    private String calculateCondition(String condition) {
        condition = condition.replaceAll(" ", "");
        StringBuilder compiled = new StringBuilder();
        OpCodeIfTypes mode = calculateConditionMode(condition);
        
        compiled.append(mode.getType());
        switch(mode) {
            case NUMBER -> compiled.append(calculateIfNumber(condition));
            case STRING -> compiled.append(calculateIfString(condition));
            case INPUT -> compiled.append(calculateIfInput(condition));
            case NONE -> compiled.deleteCharAt(compiled.length()-1);
        }
        return compiled.toString();
    }

    private OpCodeIfTypes calculateConditionMode(String conditionString) {
        if(conditionString.equals("")) return OpCodeIfTypes.NONE;

        String condition = splitAtMatch(conditionString, new String[]{"==", "!=", ">=", "<=", ">", "<"});

        if(variables.get("NUMBER").contains(condition) || condition.matches("\\d")) return OpCodeIfTypes.NUMBER;
        else if(variables.get("STRING").contains(condition) || condition.startsWith("\"") && condition.endsWith("\"")) return OpCodeIfTypes.STRING;
        else if(conditionString.startsWith(SYNTAX_INPUT)) return OpCodeIfTypes.INPUT;
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


// ***************************** STR INIT ****************************************
    private String compileStrDec(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(OpCodeIndex.STR_INIT);
        compiled.append(compileStrDecCommand(new StringBuilder(commands)));
        return compiled.toString();
    }

    private String compileStrDecCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        endString.append(line.substring(0, line.indexOf("=")).strip());
        endString.append(OpCodeSeperators.STR.getSeperator());
        endString.append(calculateStrDec(new StringBuilder(line.substring(line.indexOf("=") + 1).strip())));
        return endString.toString();
    }

    private String calculateStrDec(StringBuilder line) {
        StringBuilder endString = new StringBuilder();
        while (line.toString().contains("'")) {
            endString.append("\"" + line.substring(0, line.indexOf("'")) + "\"");
            line.delete(0, line.indexOf("'") + 1);

            endString.append(OpCodeSeperators.STR_CONTENT.getSeperator());

            endString.append(line.substring(0, line.indexOf("'")).strip());
            line.delete(0, line.indexOf("'") + 1);

            endString.append(OpCodeSeperators.STR_CONTENT.getSeperator());
        }
        endString.append("\"" + line + "\"");
        return endString.toString();
    }

// ***************************** DEBUG ******************************************
    private String compileDebug(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(OpCodeIndex.DEBUG);
        compiled.append(compileDebugCommand(new StringBuilder(commands)));
        return compiled.toString();
    }

    private String compileDebugCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        while (line.toString().contains("'")) {
            endString.append("\"" + line.substring(0, line.indexOf("'")) + "\"");
            line.delete(0, line.indexOf("'") + 1);

            endString.append(OpCodeSeperators.STR_CONTENT.getSeperator());

            endString.append(line.substring(0, line.indexOf("'")).strip());
            line.delete(0, line.indexOf("'") + 1);

            endString.append(OpCodeSeperators.STR_CONTENT.getSeperator());
        }
        endString.append("\"" + line + "\"");
        return endString.toString();
    }

// ***************************** SAVE *******************************************
    private String compileSave(String line) {
        return getStartCode(OpCodeIndex.SAVE).toString();
    }


// ***************************** LOAD *******************************************
    private String compileLoad(String line) {
        return getStartCode(OpCodeIndex.LOAD).toString();
    }


// ***************************** EXIT *******************************************
    private String compileExit(String line) {
        StringBuilder compiled = getStartCode(OpCodeIndex.EXIT);
        compiled.append("0");
        return compiled.toString();
    }


// ***************************** LOOP *******************************************
    private ArrayList<String> compileLoop(ArrayList<String> lines) {
        ArrayList<String> result = new ArrayList<>(lines.size());
    
        String commands = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_COMMAND) + 1, lines.get(0).lastIndexOf(SYNTAX_BLOCK_START)).strip();
        lines.remove(0);

        StringBuilder compiled = getStartCode(OpCodeIndex.LOOP);

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

        compiled.append(OpCodeSeperators.LOOP.getSeperator());

        List<String> loopContent = compileFile(lines);
        compiled.append(loopContent.size());
        result.add(compiled.toString());
        result.addAll(loopContent);

        return result;
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


// ***************************** BREAK ******************************************
    private String compileBreak(String line) {
        return getStartCode(OpCodeIndex.LOOP_BREAKER).toString();
    }


// ***************************** SET ********************************************
    private String compileSet(ArrayList<String> lines) {
        String setName = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_SET) + SYNTAX_SET.length() +1, lines.get(0).lastIndexOf(SYNTAX_BLOCK_START)).strip();
        lines.remove(0);

        StringBuilder compiled = getStartCode(OpCodeIndex.SET);
        compiled.append(setName);
        compiled.append(OpCodeSeperators.SET_NAME.getSeperator());
        compiled.append(compileSetCommands(lines));
        return compiled.toString();
    }

    private String compileSetCommands(ArrayList<String> lines) {
        StringBuilder endString = new StringBuilder();
        for (String line : lines) {
            line = line.strip();
            if(line.startsWith("'") && line.endsWith("'")) {
                endString.append(line.substring(1, line.length() - 1));
            } else {
                endString.append("\"" + line + "\"");
            }
            endString.append(OpCodeSeperators.SET.getSeperator());
        }
        endString.deleteCharAt(endString.length() - 1);
        return endString.toString();
    }


// ***************************** ACTION *****************************************
    private ArrayList<String> compileAction(ArrayList<String> lines) {
        ArrayList<String> result = new ArrayList<>(lines.size());
        StringBuilder commands = new StringBuilder(lines.get(0).substring(lines.get(0).indexOf(SYNTAX_ACTION) + SYNTAX_ACTION.length() + 1, lines.get(0).lastIndexOf(SYNTAX_BLOCK_START)).strip());
        lines.remove(0);

        StringBuilder compiled = getStartCode(OpCodeIndex.ACTION);
        compiled.append(commands.substring(0, commands.indexOf("(")).strip());
        compiled.append(OpCodeSeperators.ACTION.getSeperator());
        compiled.append(getActionParams(commands.substring(commands.indexOf("(") + 1, commands.lastIndexOf(")")).strip()));
        compiled.append(OpCodeSeperators.ACTION.getSeperator());
        List<String> actionContent = compileFile(lines);
        compiled.append(actionContent.size());
        result.add(compiled.toString());
        result.addAll(actionContent);
        return result;
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
        if(arg.substring(0, arg.indexOf(" ")).equals(SYNTAX_NUMBER_VARIABLE)) {
            return 'n';
        } else if(arg.substring(0, arg.indexOf(" ")).equals(SYNTAX_STRING_VARIABLE)) {
            return 's';
        } else {
            return '-';
        }
    }

    private String getArgName(String arg) {
        return arg.substring(arg.indexOf(" ") + 1).strip();
    }


// ***************************** ACTION CALL ************************************
    private String compileActionCall(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(OpCodeIndex.ACTION_CALL);
        if(commands.strip().matches("[a-zA-Z]+\\w*")) {
            compiled.append(commands.strip());
            commands = "";
        } else {
            compiled.append(commands.substring(0, commands.indexOf(" ")).strip());
            commands = commands.substring(commands.indexOf(" ") + 1).strip();
        }
        
        compiled.append(OpCodeSeperators.ACTION.getSeperator());

        compiled.append(getActionCallArgs(commands));
        return compiled.toString();
    }

    private String getActionCallArgs(String args) {
        StringBuilder result = new StringBuilder();
        String[] argsOfCall = args.split(OpCodeSeperators.ACTION_ARGS.getSeperator());
        if(args.isBlank()) {
            return "-";
        }
        for(String arg : argsOfCall) {
            result.append(arg.strip());
            result.append(OpCodeSeperators.ACTION_ARGS.getSeperator());
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }




// -------------------------------------------- Help Methods ------------------------------------------------ //


    private StringBuilder getStartCode(OpCodeIndex index) {
        return new StringBuilder().append(index.getIndex() + OpCodeSeperators.COMMAND.getSeperator());
    }

    private String getWithoutCommand(String line) {
        return line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
    }

    private String splitAtMatch(String toSplit, String[] matches) {
        for (String match : matches) {
            if(toSplit.contains(match)) {
                return toSplit.substring(0, toSplit.indexOf(match));
            }
        }
        return toSplit;
    }

    private ArrayList<String> getCodeBlock(int index, ArrayList<String> lines) {
        ArrayList<String> block = new ArrayList<>();
        int blocks = 0;
        String line = "";
        for (int i=index; i< lines.size(); i++) {
            line = lines.get(i);
            if(line.contains("{")) {
                blocks++;
            }
            if(line.contains("}")) {
                blocks--;
            }
            if(blocks == 0) {
                lines.remove(index);
                break;
            }
            block.add(line);
            lines.remove(index);
            i--;
        }
        return block;
    }

}
