package de.ttsa.Logic.Compiler.CompilerSteps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.Enums.CompilerTests;
import de.ttsa.Interfaces.CompilerLine;
import de.ttsa.Interfaces.CompilerStruct;

public class Compiler {

    // ---------------------------------------------- Attributes
    // -------------------------------------------------- //

    public static ArrayList<ArrayList<String>> fileContent;
    public static HashMap<String, HashSet<String>> variables;
    private CompilerTests compiler = CompilerTests.NONE;

    // ---------------------------------------------- Constructor
    // ------------------------------------------------- //

    public Compiler(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
        variables = new HashMap<>();
        HashSet<String> strVar = new HashSet<>();
        HashSet<String> numVar = new HashSet<>();
        variables.put("STRING", strVar);
        variables.put("NUMBER", numVar);
    }

    // -------------------------------------------- Start Method
    // -------------------------------------------------- //

    public ArrayList<ArrayList<String>> compile() {
        ArrayList<ArrayList<String>> compiled = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> line : fileContent) {
            compiled.add(compileFile(line));
        }
        return compiled;
    }

    // ------------------------------------------- Compile Chooser
    // ------------------------------------------------ //

    private ArrayList<String> compileFile(ArrayList<String> content) {
        ArrayList<String> compiled = new ArrayList<String>(content.size());
        String line = "";

        CompilerLine compilerLine;
        CompilerStruct compilerStruct;

        for (int i = 0; i < content.size(); i++) {
            line = content.get(i).strip();

            compilerLine = compiler.getCompilerLine(line);
            compilerStruct = compiler.getCompilerStruct(line);

            if (compilerLine != null) {
                compiled.add(compilerLine.compile(line));
            } else if (compilerStruct != null) {
                compiled.add(compilerStruct.compile(content, i));
                i--;
            } else {
                throw new IllegalArgumentException("Syntax Error: " + line);
            }
        }
        return compiled;
    }

}
