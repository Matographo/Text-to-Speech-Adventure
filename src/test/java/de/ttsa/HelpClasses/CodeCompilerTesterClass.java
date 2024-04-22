package de.ttsa.HelpClasses;

import java.util.ArrayList;

import de.ttsa.Logic.Compiler.CompilerSteps.CFileReader;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Logic.Compiler.CompilerSteps.Merger;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CodeCompilerTesterClass {
    
    
    
    // ------------------------------ PATHS ------------------------------



    protected final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/FeatureTest/";
    public String featureName = "";
    private final String TEST_FILE_TYPE_PATH = "/TestFiles/Code/";



    // ----------------------------- METHODS -----------------------------



    protected ArrayList<ArrayList<String>> getContent(String filePath) {
        CFileReader fileReader = new CFileReader(filePath);
        return fileReader.read();
    }

    protected ArrayList<String> compileFiles(ArrayList<ArrayList<String>> content) {
        Compiler compiler = new Compiler(content);
        Merger merger = new Merger(compiler.compile());
        return merger.merge();
    }

    protected boolean test(String testName) {
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(testName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        return opCodeTest.start(compiled);
    }



    protected String getFilePath(String fileName) {
        return TEST_FILE_PATH + featureName + TEST_FILE_TYPE_PATH + fileName;
    }

}
