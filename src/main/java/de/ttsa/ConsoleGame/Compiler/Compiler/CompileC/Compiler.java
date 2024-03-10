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
            } else if (line.startsWith(SAY_SYNTAX)) {
                compiled.add(compileSay(line));
            } else if (line.startsWith(ROOM_SYNTAX)) {
                blockCount++;
                isRoom = true;
                block.add(line);
            } else {
                throw new IllegalArgumentException("Syntax Error: " + line);
            }
        }
        return compiled;
    }

    private String compileSay(String line) {
        String commands = line.substring(line.indexOf(COMMAND_SYNTAX) + 1).strip();
        String compiled = "";
        compiled += INDEX_SAY;
        compiled += COMMAND_SEPERATOR;
        compiled += "\"" + commands + "\"";
        return compiled;
    }

    private ArrayList<String> compileRoom(ArrayList<String> lines) {
        ArrayList<String> compiledRoom = new ArrayList<>(lines.size());
        String commands = lines.get(0).substring(lines.get(0).indexOf(ROOM_SYNTAX) + ROOM_SYNTAX.length()).strip();
        lines.remove(0);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(BLOCK_START_SYNTAX)).strip();
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

}
