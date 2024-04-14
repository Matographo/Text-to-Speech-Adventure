package de.ttsa.ConsoleGame.Compiler.Compiler.CompileC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.ConsoleGame.ClassTools.CompilerSyntax;

public class Compiler extends CompilerSyntax {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    ArrayList<ArrayList<String>> fileContent;
    HashMap<String, HashSet<String>> variables;
    


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
                compiled.add(compileSay(line));
            } else if (line.startsWith(SYNTAX_ROOM)) {
                ArrayList<String> roomBlock = new ArrayList<>();
                int blocks = 1;
                roomBlock.add(content.get(i));
                content.remove(i);
                while(content.size() > i && !(content.get(i).strip().endsWith(SYNTAX_BLOCK_END) && blocks == 0)) {
                    line = content.get(i).strip();
                    if(line.contains("{")) {
                        blocks++;
                    } else if(line.contains("}")) {
                        blocks--;
                    }
                    roomBlock.add(line);
                    content.remove(i);
                }
                if(roomBlock.get(roomBlock.size()-1).strip().equals(SYNTAX_BLOCK_END)) {
                    roomBlock.remove(roomBlock.size()-1);
                } else {
                    roomBlock.set(roomBlock.size()-1, roomBlock.get(roomBlock.size()-1).substring(0, roomBlock.get(roomBlock.size()-1).lastIndexOf("}")).strip());
                }
                compiled.addAll(compileRoom(roomBlock));
                i--;
            } else if (line.startsWith(SYNTAX_SET) && line.endsWith(SYNTAX_BLOCK_START)) {
                ArrayList<String> setBlock = new ArrayList<>();
                int blocks = 1;

                setBlock.add(content.get(i));
                content.remove(i);

                while(content.size() > i && !(content.get(i).strip().endsWith(SYNTAX_BLOCK_END) && blocks == 0)) {
                    if(content.get(i).contains("{")) {
                        blocks++;
                    } else if(content.get(i).contains("}")) {
                        blocks--;
                    }
                    setBlock.add(content.get(i));
                    content.remove(i);
                }
                if(setBlock.get(setBlock.size()-1).strip().equals(SYNTAX_BLOCK_END)) {
                    setBlock.remove(setBlock.size()-1);
                } else {
                    setBlock.set(setBlock.size()-1, setBlock.get(setBlock.size()-1).substring(0, setBlock.get(setBlock.size()-1).lastIndexOf("}")).strip());
                }
                compiled.add(compileSet(setBlock));
                i--;
            } else if (line.startsWith(SYNTAX_IF)) {
                ArrayList<String> ifBlock = new ArrayList<>();
                int blocks = 1;

                ifBlock.add(content.get(i));
                content.remove(i);

                while(content.size() > i && !(content.get(i).strip().endsWith(SYNTAX_BLOCK_END) && blocks == 0)) {
                    if(content.get(i).contains("{")) {
                        blocks++;
                    }
                    if(content.get(i).contains("}")) {
                        blocks--;
                    }
                    ifBlock.add(content.get(i));
                    content.remove(i);
                }
                if(ifBlock.get(ifBlock.size()-1).strip().equals(SYNTAX_BLOCK_END)) {
                    ifBlock.remove(ifBlock.size()-1);
                } else {
                    ifBlock.set(ifBlock.size()-1, ifBlock.get(ifBlock.size()-1).substring(0, ifBlock.get(ifBlock.size()-1).lastIndexOf("}")).strip());
                }
                compiled.addAll(compileIf(ifBlock));
                i--;
            } else if (line.startsWith(SYNTAX_ROOM_JUMPER)) {
                compiled.add(compileRoomJumper(line));
            } else if (line.startsWith(SYNTAX_SAVE)) {
                compiled.add(compileSave(line));
            } else if (line.startsWith(SYNTAX_LOAD)) {
                compiled.add(compileLoad(line));
            } else if (line.startsWith(SYNTAX_EXIT)) {
                compiled.add(compileExit(line));
            } else if (line.startsWith(SYNTAX_INPUT)) {
                compiled.add(compileInput(line));
            } else if (line.startsWith(SYNTAX_NUM_VARDEC)) {
                compiled.add(compileNumDec(line));
            } else if (line.startsWith(SYNTAX_NUMBER_VARIABLE)) {
                compiled.add(compileNum(line));
            } else if (line.startsWith(SYNTAX_STR_VARDEC)) {
                compiled.add(compileStrDec(line));
            } else if (line.startsWith(SYNTAX_STRING_VARIABLE)) {
                compiled.add(compileStr(line));
            } else if (line.startsWith(SYNTAX_LOOP_BREAKER)) {
                compiled.add(compileBreak(line));
            } else if (line.startsWith(SYNTAX_DEBUG)) {
                compiled.add(compileDebug(line));
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

        StringBuilder compiled = getStartCode(INDEX_SAY);
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
                endCommand.append(SAY_SEPERATOR);
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

        StringBuilder compiled = getStartCode(INDEX_ROOM);
        compiled.append(commands);
        compiled.append(ROOM_SEPERATOR);

        roomContent.addAll(compileFile(lines));

        compiled.append(roomContent.size());
        compiledRoom.add(compiled.toString());
        compiledRoom.addAll(roomContent);
        return compiledRoom;
    }


// ***************************** ROOM JUMPER ************************************
    private String compileRoomJumper(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(INDEX_ROOM_JUMPER);
        compiled.append(commands);
        return compiled.toString();
    }


// ***************************** Num INIT ****************************************
    private String compileNum(String line) {
        String commands = getWithoutCommand(line);
        String varName = "";

        StringBuilder compiled = getStartCode(INDEX_NUMBER_VARIABLE);
        if(commands.contains("=") || commands.contains(" ")) {
            String[] parts;

            if (commands.contains("=")) parts = commands.split("=");
            else                        parts = commands.split(" ");

            varName = parts[0].strip();
            compiled.append(varName);
            compiled.append(NUMBER_VARIABLE_SEPERATOR);
            compiled.append(parts[1].strip());
        } else {
            varName = commands;
            compiled.append(varName);
            compiled.append(NUMBER_VARIABLE_SEPERATOR);
            compiled.append("0");
        }
        variables.get("NUMBER").add(varName);
        return compiled.toString();
    }


// ***************************** STR INIT ****************************************
    private String compileStr(String line) {
        String commands = getWithoutCommand(line);
        String varName = "";

        StringBuilder compiled = getStartCode(INDEX_STRING_VARIABLE);
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
            compiled.append(STR_SEPERATOR);
            compiled.append(parts[1].strip());
        } else {
            varName = commands;
            compiled.append(varName);
            compiled.append(NUMBER_STRING_SEPERATOR);
        }

        variables.get("STRING").add(varName);
        return compiled.toString();
    }


// ***************************** NUM DEC ***************************************
    private String compileNumDec(String line) {
        StringBuilder commands = new StringBuilder(getWithoutCommand(line));

        StringBuilder compiled = getStartCode(INDEX_NUM_VARDEC);
        compiled.append(compileNumDecCommand(commands));
        return compiled.toString();
    }

    private String compileNumDecCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        endString.append(line.substring(0, line.indexOf("=")).strip());
        endString.append(NUMBER_VARIABLE_SEPERATOR);
        line.delete(0, line.indexOf("=") + 1);
        endString.append(line.toString().replaceAll(" ", "").strip());
        return endString.toString();
    }


// ***************************** INPUT ****************************************
    private String compileInput(String line) {
        return getStartCode(INDEX_INPUT).toString();
    }


// ***************************** IF *******************************************
    private ArrayList<String> compileIf(ArrayList<String> lines) {
        String result = getStartCode(INDEX_IF).toString();

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
            compiledIf.append(IF_NUM_SEPERATOR);
            
            compiledFile = compileFile(block);
            result.addAll(compiledFile);
            compiledIf.append(compiledFile.size());
            compiledIf.append(IF_ELSE_SEPERATOR);
        }
        compiledIf.delete(compiledIf.length()-2, compiledIf.length());

        result.add(0, compiledIf.toString());
        return result;
    }

    private String calculateCondition(String condition) {
        condition = condition.replaceAll(" ", "");
        StringBuilder compiled = new StringBuilder();
        char mode = calculateConditionMode(condition);
        
        compiled.append(mode);
        switch(mode) {
            case IF_NUMBER -> compiled.append(calculateIfNumber(condition));
            case IF_STRING -> compiled.append(calculateIfString(condition));
            case IF_INPUT -> compiled.append(calculateIfInput(condition));
            case ' ' -> compiled.deleteCharAt(compiled.length()-1);
        }
        return compiled.toString();
    }

    private char calculateConditionMode(String conditionString) {
        if(conditionString.equals("")) return ' ';

        String condition = splitAtMatch(conditionString, new String[]{"==", "!=", ">=", "<=", ">", "<"});

        if(variables.get("NUMBER").contains(condition) || condition.matches("\\d")) return IF_NUMBER;
        else if(variables.get("STRING").contains(condition) || condition.startsWith("\"") && condition.endsWith("\"")) return IF_STRING;
        else if(conditionString.startsWith(SYNTAX_INPUT)) return IF_INPUT;
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


// ***************************** STR DEC ****************************************
    private String compileStrDec(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(INDEX_STR_VARDEC);
        compiled.append(compileStrDecCommand(new StringBuilder(commands)));
        return compiled.toString();
    }

    private String compileStrDecCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        endString.append(line.substring(0, line.indexOf("=")).strip());
        endString.append(STR_SEPERATOR);
        endString.append(calculateStrDec(new StringBuilder(line.substring(line.indexOf("=") + 1).strip())));
        return endString.toString();
    }

    private String calculateStrDec(StringBuilder line) {
        StringBuilder endString = new StringBuilder();
        while (line.toString().contains("'")) {
            endString.append("\"" + line.substring(0, line.indexOf("'")) + "\"");
            line.delete(0, line.indexOf("'") + 1);

            endString.append(STR_CONTENT_SEPERATOR);

            endString.append(line.substring(0, line.indexOf("'")).strip());
            line.delete(0, line.indexOf("'") + 1);

            endString.append(STR_CONTENT_SEPERATOR);
        }
        endString.append("\"" + line + "\"");
        return endString.toString();
    }

// ***************************** DEBUG ******************************************
    private String compileDebug(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(INDEX_DEBUG);
        compiled.append(compileDebugCommand(new StringBuilder(commands)));
        return compiled.toString();
    }

    private String compileDebugCommand(StringBuilder line) {
        StringBuilder endString = new StringBuilder();

        while (line.toString().contains("'")) {
            endString.append("\"" + line.substring(0, line.indexOf("'")) + "\"");
            line.delete(0, line.indexOf("'") + 1);

            endString.append(STR_CONTENT_SEPERATOR);

            endString.append(line.substring(0, line.indexOf("'")).strip());
            line.delete(0, line.indexOf("'") + 1);

            endString.append(STR_CONTENT_SEPERATOR);
        }
        endString.append("\"" + line + "\"");
        return endString.toString();
    }

// ***************************** SAVE *******************************************
    private String compileSave(String line) {
        return getStartCode(INDEX_SAVE).toString();
    }


// ***************************** LOAD *******************************************
    private String compileLoad(String line) {
        return getStartCode(INDEX_LOAD).toString();
    }


// ***************************** EXIT *******************************************
    private String compileExit(String line) {
        StringBuilder compiled = getStartCode(INDEX_EXIT);
        compiled.append("0");
        return compiled.toString();
    }


// ***************************** LOOP *******************************************
    private String compileLoop(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);

        StringBuilder compiled = getStartCode(INDEX_LOOP);
        compiled.append(commands);
        return compiled.toString();
    }


// ***************************** BREAK ******************************************
    private String compileBreak(String line) {
        return getStartCode(INDEX_LOOP_BREAKER).toString();
    }


// ***************************** SET ********************************************
    private String compileSet(ArrayList<String> lines) {
        String setName = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_SET) + SYNTAX_SET.length() +1, lines.get(0).lastIndexOf(SYNTAX_BLOCK_START)).strip();
        lines.remove(0);

        StringBuilder compiled = getStartCode(INDEX_SET);
        compiled.append(setName);
        compiled.append(SET_NAME_SEPERATOR);
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
            endString.append(SET_SEPERATOR);
        }
        endString.deleteCharAt(endString.length() - 1);
        return endString.toString();
    }


// ***************************** ACTION *****************************************
    private String compileAction(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);

        StringBuilder compiled = getStartCode(INDEX_ACTION);
        compiled.append(commands);
        return compiled.toString();
    }


// ***************************** ACTION CALL ************************************
    private String compileActionCall(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(INDEX_ACTION_CALL);
        compiled.append(commands);
        return compiled.toString();
    }




// -------------------------------------------- Help Methods ------------------------------------------------ //


    private StringBuilder getStartCode(String index) {
        return new StringBuilder().append(index + COMMAND_SEPERATOR);
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

}
