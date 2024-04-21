package de.ttsa.Logic.Compiler;

import java.util.ArrayList;

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
private String filePath;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public StartCompiler(String path, boolean isHidden) {
        this.isHidden = isHidden;
        this.filePath = path;
        
    }



// -------------------------------------- Start Compiler Lifecycle ------------------------------------------- //



    public void compile() {
        startReading();
        startMerging();
        startSorting();
        startTesting();
        startCompiling();
        startOpCodeTest();
        startBuilding();
    }



// ---------------------------------------------- Reading -------------------------------------------------- //



    private boolean startReading() {
        CFileReader reader = new CFileReader(filePath);
        fileContent = reader.read();
        return false;
    }
    
    

// ---------------------------------------------- Testing -------------------------------------------------- //



    private boolean startTesting() {
        CodeTester test = new CodeTester(fileContent);
        boolean testResult = true;
        testResult = test.test();
        return testResult;
    }



// ---------------------------------------------- Compiling -------------------------------------------------- //



    private boolean startCompiling() {
        Compiler compiler = new Compiler(fileContent);
        fileContent = compiler.compile();
        return false;
    }



// ---------------------------------------------- Sorting -------------------------------------------------- //



    private boolean startSorting() {
        Sorter sorter = new Sorter(fileContent);
        fileContent = sorter.sort();
        return false;
    }



// ---------------------------------------------- Merging -------------------------------------------------- //



    private boolean startMerging() {
        Merger merger = new Merger(fileContent);
        game = merger.merge();
        return false;
    }



// ---------------------------------------------- OpCodeTest -------------------------------------------------- //



    private boolean startOpCodeTest() {
        return OpCodeTest.test(game);
    }



// ---------------------------------------------- Building -------------------------------------------------- //


    private boolean startBuilding() {
        GameBuilder builder = new GameBuilder(game);
        builder.build();
        return false;
    }

}
