package de.ttsa.ConsoleGame.Compiler.Compiler.CompileC;

import java.util.ArrayList;

import de.ttsa.ConsoleGame.ClassTools.CompilerSyntax;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;

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

    private String compileSay(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += INDEX_SAY;
        compiled += COMMAND_SEPERATOR;
        compiled += getSay(commands);
        return compiled;
    }

    private ArrayList<String> compileRoom(ArrayList<String> lines) {
        ArrayList<String> compiledRoom = new ArrayList<>(lines.size());
        String commands = lines.get(0).substring(lines.get(0).indexOf(SYNTAX_ROOM) + SYNTAX_ROOM.length()).strip();
        lines.remove(0);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(SYNTAX_BLOCK_START)).strip();
        }
        String compiled = "";
        compiled += INDEX_ROOM;
        compiled += COMMAND_SEPERATOR;
        compiled += commands;
        compiled += ROOM_SEPERATOR;
        compiled += lines.size();
        compiledRoom.add(compiled);
        compiledRoom.addAll(compileFile(lines));
        return compiledRoom;
    }

    private String compileRoomJumper(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += INDEX_ROOM_JUMPER;
        compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileNum(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += INDEX_NUMBER_VARIABLE;
        compiled += COMMAND_SEPERATOR;
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

    private String compileStr(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += INDEX_STRING_VARIABLE;
        compiled += COMMAND_SEPERATOR;
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

    private String compileNumDec(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileInput(String line) {
        String compiled = "";
        compiled += INDEX_INPUT;
        compiled += COMMAND_SEPERATOR;
        return compiled;
    }

    private String compileIf(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileStrDec(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileDebug(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileSave(String line) {
        String compiled = "";
        compiled += INDEX_SAVE;
        compiled += COMMAND_SEPERATOR;
        return compiled;
    }

    private String compileLoad(String line) {
        String compiled = "";
        compiled += INDEX_LOAD;
        compiled += COMMAND_SEPERATOR;
        return compiled;
    }

    private String compileExit(String line) {
        String compiled = "";
        compiled += INDEX_EXIT;
        compiled += COMMAND_SEPERATOR;
        compiled += "0";
        return compiled;
    }

    private String compileLoop(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileBreak(String line) {
        String compiled = "";
        compiled += INDEX_LOOP_BREAKER;
        compiled += COMMAND_SEPERATOR;
        return compiled;
    }

    private String compileSet(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileAction(ArrayList<String> lines) {
        String commands = lines.get(0).substring(lines.indexOf(SYNTAX_COMMAND) + 1).strip();
        lines.remove(0);
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileDo(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    // ------------------------------ Help Methods ------------------------------

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

}
