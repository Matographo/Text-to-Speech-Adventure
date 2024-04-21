package de.ttsa.Logic.Compiler.Compiler;

import java.util.ArrayList;

import de.ttsa.Logic.Compiler.Compiler.CompileC.Compiler;
import de.ttsa.Logic.Compiler.Compiler.CompileTools.CFileReader;
import de.ttsa.Logic.Compiler.Compiler.CompileTools.GameBuilder;
import de.ttsa.Logic.Compiler.Compiler.CompileTools.Merger;
import de.ttsa.Logic.Compiler.Compiler.CompileTools.Sorter;
import de.ttsa.Logic.Compiler.Compiler.TestC.Test;
import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeTest;

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
        startTesting();
        startCompiling();
        startSorting();
        startMerging();
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
        Test test = new Test(fileContent);
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
