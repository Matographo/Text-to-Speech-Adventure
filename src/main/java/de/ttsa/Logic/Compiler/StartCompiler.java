package de.ttsa.Logic.Compiler;

import java.util.ArrayList;
import java.util.Arrays;

import de.ttsa.Logic.Compiler.CompilerSteps.CFileReader;
import de.ttsa.Logic.Compiler.CompilerSteps.CodeTester;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Logic.Compiler.CompilerSteps.GameBuilder;
import de.ttsa.Logic.Compiler.CompilerSteps.Merger;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.Logic.Compiler.CompilerSteps.Sorter;

public class StartCompiler {



// ---------------------------------------------- Attributes -------------------------------------------------- //



private ArrayList<ArrayList<String>> fileContent = new ArrayList<ArrayList<String>>();
private ArrayList<String> game                   = new ArrayList<String>();
private boolean isHidden                         = false;
private String fileSource;
private String fileDestination;
private String failedTest;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public StartCompiler(String sourcePath, String destinationPath, boolean isHidden) {
        this.isHidden   = isHidden;
        this.fileSource = sourcePath;
        this.fileDestination = destinationPath;
    }



// -------------------------------------- Start Compiler Lifecycle ------------------------------------------- //



    public boolean compile() {
        if(startReading() &&
        startMerging() &&
        startSorting() &&
        startTesting() &&
        startCompiling() &&
        startOpCodeTest() &&
        startBuilding()) {
            System.out.println("Compilation successful.");
            return true;
        } else {
            System.out.println("Compilation failed by " + failedTest + ".");
            return false;
        }
    }



// ---------------------------------------------- Reading -------------------------------------------------- //



    private boolean startReading() {
        failedTest = "reading";
        CFileReader reader = new CFileReader(fileSource);
        fileContent = reader.read();
        return fileContent != null;
    }
    
    

// ---------------------------------------------- Testing -------------------------------------------------- //



    private boolean startTesting() {
        failedTest = "testing";
        CodeTester test = new CodeTester(new ArrayList<ArrayList<String>>(Arrays.asList(game)));
        return test.test();
    }

    

// ---------------------------------------------- Compiling -------------------------------------------------- //



    private boolean startCompiling() {
        failedTest = "compiling";
        Compiler compiler = new Compiler(new ArrayList<ArrayList<String>>(Arrays.asList(game)));
        game = compiler.compile().get(0);
        return true;
    }



// ---------------------------------------------- Sorting -------------------------------------------------- //



    private boolean startSorting() {
        failedTest = "sorting";
        Sorter sorter = new Sorter(game);
        try {
            game = sorter.sort();
            return true;
        } catch (Exception e) {
            return false;
        }
    }



// ---------------------------------------------- Merging -------------------------------------------------- //



    private boolean startMerging() {
        failedTest = "merging";
        Merger merger = new Merger(fileContent);
        game = merger.merge();
        return game != null;
    }



// ---------------------------------------------- OpCodeTest -------------------------------------------------- //



    private boolean startOpCodeTest() {
        failedTest = "opcode testing";
        return OpCodeTest.test(game);
    }



// ---------------------------------------------- Building -------------------------------------------------- //


    private boolean startBuilding() {
        failedTest = "building";
        GameBuilder builder = new GameBuilder(game, fileSource, fileDestination);
        return builder.build();
    }

}
