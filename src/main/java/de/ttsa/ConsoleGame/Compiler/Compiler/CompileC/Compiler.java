package de.ttsa.ConsoleGame.Compiler.Compiler.CompileC;

import java.util.ArrayList;

import de.ttsa.ConsoleGame.ClassTools.CompilerSyntax;

public class Compiler extends CompilerSyntax {

    ArrayList<ArrayList<String>> fileContent;
    
    public Compiler(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
    }

    public ArrayList<ArrayList<String>> compile() {
        ArrayList<ArrayList<String>> compiled = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> line : fileContent) {
            compiled.add(compileFile(line));
        }
        return compiled;
    }

    private ArrayList<String> compileFile(ArrayList<String> content) {
        ArrayList<String> compiled = new ArrayList<String>(content.size());
        ArrayList<String> block = new ArrayList<>();
        String line = "";
        boolean isRoom = false;
        int blockCount = 0;
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i).strip();
            if(line.startsWith("}") && isRoom) {
                compiled.addAll(compileRoom(block));
                blockCount--;
                isRoom = false;
            } else if(blockCount > 0) {
                block.add(line);
            } else if (line.startsWith(SYNTAX_SAY)) {
                compiled.add(compileSay(line));
            } else if (line.startsWith(SYNTAX_ROOM)) {
                blockCount++;
                isRoom = true;
                block.add(line);
            } else if (line.startsWith(SYNTAX_SET) && line.endsWith(SYNTAX_BLOCK_START)) {
                ArrayList<String> setBlock = new ArrayList<>();

                while(!content.get(i).strip().endsWith(SYNTAX_BLOCK_END)) {
                    setBlock.add(content.get(i));
                    content.remove(i);
                }
                if(content.get(i).strip().equals(SYNTAX_BLOCK_END)) {
                    content.remove(i);
                } else {
                    setBlock.add(content.get(i).substring(0, content.lastIndexOf("}")).strip());
                    content.remove(i);
                }
                compiled.add(compileSet(setBlock));
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
        String commands = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_ROOM) + SYNTAX_ROOM.length()).strip();
        lines.remove(0);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(SYNTAX_BLOCK_START)).strip();
        }

        StringBuilder compiled = getStartCode(INDEX_ROOM);
        compiled.append(commands);
        compiled.append(ROOM_SEPERATOR);
        compiled.append(lines.size());
        compiledRoom.add(compiled.toString());
        compiledRoom.addAll(compileFile(lines));
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

        StringBuilder compiled = getStartCode(INDEX_NUMBER_VARIABLE);
        if (commands.contains("=")) {
            String[] parts = commands.split("=");
            compiled.append(parts[0].strip());
            compiled.append(NUMBER_VARIABLE_SEPERATOR);
            compiled.append(parts[1].strip());
            return compiled.toString();
        } else if (commands.contains(" ")) {
            String[] parts = commands.split(" ");
            compiled.append(parts[0].strip());
            compiled.append(NUMBER_VARIABLE_SEPERATOR);
            compiled.append(parts[1].strip());
            return compiled.toString();
        } else {
            compiled.append(commands);
            compiled.append(NUMBER_VARIABLE_SEPERATOR);
            compiled.append("0");
            return compiled.toString();
        }
    }


// ***************************** STR INIT ****************************************
    private String compileStr(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(INDEX_STRING_VARIABLE);
        if (commands.contains("=")) {
            String[] parts = commands.split("=");
            compiled.append(parts[0].strip());
            compiled.append(NUMBER_STRING_SEPERATOR);
            compiled.append(parts[1].strip());
            return compiled.toString();
        } else {
            compiled.append(commands);
            compiled.append(NUMBER_STRING_SEPERATOR);
            return compiled.toString();
        }

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
    private String compileIf(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);

        StringBuilder compiled = getStartCode(INDEX_IF);
        compiled.append(commands);
        return compiled.toString();
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




    // ------------------------------ Help Methods ------------------------------


    private StringBuilder getStartCode(String index) {
        return new StringBuilder().append(index + COMMAND_SEPERATOR);
    }

    private String getWithoutCommand(String line) {
        return line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
    }

}
