package de.ttsa.console.Compiler.Compiler;

import java.io.File;
import java.util.ArrayList;

import de.ttsa.console.Compiler.Compiler.CompileC.Compiler;
import de.ttsa.console.Compiler.Compiler.CompileTools.CFileReader;
import de.ttsa.console.Compiler.Compiler.CompileTools.GameBuilder;
import de.ttsa.console.Compiler.Compiler.CompileTools.Merger;
import de.ttsa.console.Compiler.Compiler.CompileTools.Sorter;
import de.ttsa.console.Compiler.Compiler.TestC.Test;

public class StartCompiler {

    String filePath;
    String errorText;
    boolean isHidden = false;
    ArrayList<ArrayList<String>> fileContent = new ArrayList<ArrayList<String>>();
    ArrayList<String> game = new ArrayList<String>();

    public StartCompiler(String path, boolean isHidden) {
        this.isHidden = isHidden;
        this.filePath = path;
        
    }

    public void compile() {
        startReading();
        startTesting();
        startCompiling();
        startSorting();
        startMerging();
        startBuilding();

    }

    private boolean startReading() {
        output("Start reading data...");
        CFileReader reader = new CFileReader(filePath);
        fileContent = reader.read();
        output("data reading finished.");
        return false;
    }
    
    
    private boolean startTesting() {
        output("Start testing...");
        Test test = new Test(fileContent);
        boolean testResult = true;
        testResult = test.test();
        output("Testing finished.");
        return testResult;
    }

    private boolean startCompiling() {
        output("Start compiling...");
        Compiler compiler = new Compiler(fileContent);
        fileContent = compiler.compile();
        output("Compiling finished.");
        return false;
    }

    private boolean startSorting() {
        output("Start sorting...");
        Sorter sorter = new Sorter(fileContent);
        fileContent = sorter.sort();
        output("Sorting finished.");
        return false;
    }

    private boolean startMerging() {
        output("Start merging...");
        Merger merger = new Merger(fileContent);
        game = merger.merge();
        output("Merging finished.");
        return false;
    }

    private boolean startBuilding() {
        output("Start building...");
        GameBuilder builder = new GameBuilder(game);
        builder.build();
        output("Building finished.");
        return false;
    }
    
    private void throwError() {
        throw new IllegalArgumentException(errorText);
    }
    
    private void output(String output) {
        if(!isHidden) {
            System.out.println(output);
        }
    }

}
