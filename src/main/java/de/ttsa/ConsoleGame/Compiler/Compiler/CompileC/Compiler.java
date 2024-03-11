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
        compiled += "\"" + commands + "\"";
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
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileStr(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileNumDec(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
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
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileLoad(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
        return compiled;
    }

    private String compileExit(String line) {
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
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
        String commands = line.substring(line.indexOf(SYNTAX_COMMAND) + 1).strip();
        String compiled = "";
        compiled += compiled += COMMAND_SEPERATOR;
        compiled += commands;
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

}
