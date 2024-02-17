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
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i).strip();
            if (line.startsWith(SAY_SYNTAX)) {
                compiled.add(compileSay(line));
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

}
