package de.ttsa.ConsoleGame.Compiler.Compiler;

import java.util.ArrayList;

import de.ttsa.ConsoleGame.Compiler.Compiler.CompileC.Compiler;
import de.ttsa.ConsoleGame.Compiler.Compiler.CompileTools.CFileReader;
import de.ttsa.ConsoleGame.Compiler.Compiler.CompileTools.GameBuilder;
import de.ttsa.ConsoleGame.Compiler.Compiler.CompileTools.Merger;
import de.ttsa.ConsoleGame.Compiler.Compiler.CompileTools.Sorter;
import de.ttsa.ConsoleGame.Compiler.Compiler.TestC.Test;

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
        startBuilding();

    }



// ---------------------------------------------- Reading -------------------------------------------------- //



    private boolean startReading() {
        //output("Start reading data...");
        CFileReader reader = new CFileReader(filePath);
        fileContent = reader.read();
        //output("data reading finished.");
        return false;
    }
    
    

// ---------------------------------------------- Testing -------------------------------------------------- //



    private boolean startTesting() {
        //output("Start testing...");
        Test test = new Test(fileContent);
        boolean testResult = true;
        testResult = test.test();
        //output("Testing finished.");
        return testResult;
    }



// ---------------------------------------------- Compiling -------------------------------------------------- //



    private boolean startCompiling() {
        //output("Start compiling...");
        Compiler compiler = new Compiler(fileContent);
        fileContent = compiler.compile();
        //output("Compiling finished.");
        return false;
    }



// ---------------------------------------------- Sorting -------------------------------------------------- //



    private boolean startSorting() {
        //output("Start sorting...");
        Sorter sorter = new Sorter(fileContent);
        fileContent = sorter.sort();
        //output("Sorting finished.");
        return false;
    }



// ---------------------------------------------- Merging -------------------------------------------------- //



    private boolean startMerging() {
        //output("Start merging...");
        Merger merger = new Merger(fileContent);
        game = merger.merge();
        //output("Merging finished.");
        return false;
    }



// ---------------------------------------------- Building -------------------------------------------------- //



    private boolean startBuilding() {
        //output("Start building...");
        GameBuilder builder = new GameBuilder(game);
        builder.build();
        //output("Building finished.");
        return false;
    }

}
