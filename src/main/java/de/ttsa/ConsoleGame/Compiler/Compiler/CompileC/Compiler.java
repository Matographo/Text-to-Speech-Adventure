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
            } else if (line.startsWith(SYNTAX_NUMBER_VARIABLE)) {
                compiled.add(compileNum(line));
            } else if (line.startsWith(SYNTAX_STRING_VARIABLE)) {
                compiled.add(compileStr(line));
            } else if (line.startsWith(SYNTAX_LOOP_BREAKER)) {
                compiled.add(compileBreak(line));
            } else {
                throw new IllegalArgumentException("Syntax Error: " + line);
            }
        }
        return compiled;
    }



// --------------------------- Compiler Methods ---------------------------------


// ***************************** SAY ********************************************
    private String compileSay(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(INDEX_SAY);
        compiled += getSay(commands);
        return compiled;
    }

    private String getSay(String commands) {
        String endCommand = "";
        String subCommand = "";
        int cutIndex;
        while (commands.length() > 0) {
            if (commands.startsWith("\'")) {
                cutIndex = commands.substring(1).indexOf("\'") + 1;
                subCommand = commands.substring(1, cutIndex);
                endCommand += subCommand;
                commands = commands.substring(cutIndex + 1);
            } else {
                cutIndex = commands.indexOf("\'");
                if (cutIndex != -1) {
                    subCommand = commands.substring(0, cutIndex);
                } else {
                    subCommand = commands;
                }
                endCommand += "\"" + subCommand + "\"";
                if (cutIndex != -1) {
                    commands = commands.substring(cutIndex);
                } else {
                    commands = "";
                }
            }
            if (commands.length() > 0) {
                endCommand += SAY_SEPERATOR;
            }
        }

        return endCommand;
    }


// ***************************** ROOM *******************************************
    private ArrayList<String> compileRoom(ArrayList<String> lines) {
        ArrayList<String> compiledRoom = new ArrayList<>(lines.size());
        String commands = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_ROOM) + SYNTAX_ROOM.length()).strip();
        lines.remove(0);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(SYNTAX_BLOCK_START)).strip();
        }
        String compiled = getStartCode(INDEX_ROOM);
        compiled += commands;
        compiled += ROOM_SEPERATOR;
        compiled += lines.size();
        compiledRoom.add(compiled);
        compiledRoom.addAll(compileFile(lines));
        return compiledRoom;
    }


// ***************************** ROOM JUMPER ************************************
    private String compileRoomJumper(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(INDEX_ROOM_JUMPER);
        compiled += commands;
        return compiled;
    }


// ***************************** Num INIT ****************************************
    private String compileNum(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(INDEX_NUMBER_VARIABLE);
        if (commands.contains("=")) {
            String[] parts = commands.split("=");
            compiled += parts[0].strip();
            compiled += NUMBER_VARIABLE_SEPERATOR;
            compiled += parts[1].strip();
            return compiled;
        } else {
            compiled += commands;
            compiled += NUMBER_VARIABLE_SEPERATOR;
            compiled += "0";
            return compiled;
        }
    }


// ***************************** STR INIT ****************************************
    private String compileStr(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(INDEX_STRING_VARIABLE);
        if (commands.contains("=")) {
            String[] parts = commands.split("=");
            compiled += parts[0].strip();
            compiled += NUMBER_STRING_SEPERATOR;
            compiled += parts[1].strip();
            return compiled;
        } else {
            compiled += commands;
            compiled += NUMBER_STRING_SEPERATOR;
            compiled += "";
            return compiled;
        }

    }


// ***************************** NUM DEC ***************************************
    private String compileNumDec(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(null);
        compiled += commands;
        return compiled;
    }


// ***************************** INPUT ****************************************
    private String compileInput(String line) {
        return getStartCode(INDEX_INPUT);
    }


// ***************************** IF *******************************************
    private String compileIf(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = getStartCode(INDEX_IF);
        compiled += commands;
        return compiled;
    }


// ***************************** STR DEC ****************************************
    private String compileStrDec(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(null);
        compiled += commands;
        return compiled;
    }


// ***************************** DEBUG ******************************************
    private String compileDebug(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(INDEX_DEBUG);
        compiled += commands;
        return compiled;
    }


// ***************************** SAVE *******************************************
    private String compileSave(String line) {
        return getStartCode(INDEX_SAVE);
    }


// ***************************** LOAD *******************************************
    private String compileLoad(String line) {
        return getStartCode(INDEX_LOAD);
    }


// ***************************** EXIT *******************************************
    private String compileExit(String line) {
        String compiled = getStartCode(INDEX_EXIT);
        compiled += "0";
        return compiled;
    }


// ***************************** LOOP *******************************************
    private String compileLoop(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = getStartCode(INDEX_LOOP);
        compiled += commands;
        return compiled;
    }


// ***************************** BREAK ******************************************
    private String compileBreak(String line) {
        return getStartCode(INDEX_LOOP_BREAKER);
    }


// ***************************** SET ********************************************
    private String compileSet(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = getStartCode(INDEX_SET);
        compiled += commands;
        return compiled;
    }


// ***************************** ACTION *****************************************
    private String compileAction(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = getStartCode(INDEX_ACTION);
        compiled += commands;
        return compiled;
    }


// ***************************** ACTION CALL ************************************
    private String compileActionCall(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = getStartCode(INDEX_ACTION_CALL);
        compiled += commands;
        return compiled;
    }




    // ------------------------------ Help Methods ------------------------------


    private String getStartCode(String index) {
        return index + COMMAND_SEPERATOR;
    }

}
