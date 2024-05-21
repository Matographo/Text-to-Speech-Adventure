package de.ttsa.Logic.Compiler;

import java.util.ArrayList;
import java.util.Arrays;

import de.ttsa.Frontend.Terminal.CompilerApp;
import de.ttsa.Logic.Compiler.CompilerSteps.CFileReader;
import de.ttsa.Logic.Compiler.CompilerSteps.CodeTester;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Logic.Compiler.CompilerSteps.GameBuilder;
import de.ttsa.Logic.Compiler.CompilerSteps.Merger;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.Logic.Compiler.CompilerSteps.Sorter;
import de.ttsa.Tools.Formater;
import de.ttsa.Tools.SimpleLog;

public class StartCompiler {



// ---------------------------------------------- Attributes -------------------------------------------------- //



private ArrayList<ArrayList<String>> fileContent = new ArrayList<ArrayList<String>>();
private ArrayList<String> game                   = new ArrayList<String>();
private String fileSource;
private String fileDestination;
private String failedTest;
private SimpleLog log = CompilerApp.log;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public StartCompiler(String sourcePath, String destinationPath) {
        this.fileSource = sourcePath;
        this.fileDestination = destinationPath;
        log.info("Compiler received data");
        log.debug("Compiler received source path: " + sourcePath);
        log.debug("Compiler received destination path: " + destinationPath);
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
            log.info("Compilation successful.");
            return true;
        } else {
            log.error("Compilation failed");
            return false;
        }
    }



// ---------------------------------------------- Reading -------------------------------------------------- //



    private boolean startReading() {
        log.info("Reading file(s)...");
        long startTime = System.currentTimeMillis();
        CFileReader reader = new CFileReader(fileSource);
        fileContent = reader.read();
        log.debug("Reading time: " + Formater.format(System.currentTimeMillis() - startTime));
        log.debug("Files read: " + fileContent.size());
        return fileContent != null;
    }
    
    

// ---------------------------------------------- Testing -------------------------------------------------- //



    private boolean startTesting() {
        log.info("Testing code...");
        long startTime = System.currentTimeMillis();
        CodeTester test = new CodeTester(new ArrayList<ArrayList<String>>(Arrays.asList(game)));
        boolean result = test.test();
        log.debug("Testing time: " + Formater.format(System.currentTimeMillis() - startTime));
        return result;
    }

    

// ---------------------------------------------- Compiling -------------------------------------------------- //



    private boolean startCompiling() {
        log.info("Compiling code...");
        long startTime = System.currentTimeMillis();
        Compiler compiler = new Compiler(new ArrayList<ArrayList<String>>(Arrays.asList(game)));
        game = compiler.compile().get(0);
        log.debug("Compiling time: " + Formater.format(System.currentTimeMillis() - startTime));
        return game != null;
    }



// ---------------------------------------------- Sorting -------------------------------------------------- //



    private boolean startSorting() {
        log.info("Sorting code...");
        long startTime = System.currentTimeMillis();
        Sorter sorter = new Sorter(game);
        try {
            game = sorter.sort();
            log.debug("Sorting time: " + Formater.format(System.currentTimeMillis() - startTime));
            return true;
        } catch (Exception e) {
            return false;
        }
    }



// ---------------------------------------------- Merging -------------------------------------------------- //



    private boolean startMerging() {
        log.info("Merging code...");
        long startTime = System.currentTimeMillis();
        Merger merger = new Merger(fileContent);
        game = merger.merge();
        log.debug("Merging time: " + Formater.format(System.currentTimeMillis() - startTime));
        return game != null;
    }



// ---------------------------------------------- OpCodeTest -------------------------------------------------- //



    private boolean startOpCodeTest() {
        log.info("Testing Compiled Code...");
        long startTime = System.currentTimeMillis();
        boolean result = OpCodeTest.test(game);
        log.debug("OpCodeTest time: " + Formater.format(System.currentTimeMillis() - startTime));
        return result;
    }



// ---------------------------------------------- Building -------------------------------------------------- //


    private boolean startBuilding() {
        log.info("Building Game File...");
        long startTime = System.currentTimeMillis();
        GameBuilder builder = new GameBuilder(game, fileSource, fileDestination);
        boolean result = builder.build();
        log.debug("Building time: " + Formater.format(System.currentTimeMillis() - startTime));
        return result;
    }

}
