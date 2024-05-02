package de.ttsa.HelpClasses;

import java.util.ArrayList;

import de.ttsa.Logic.Compiler.CompilerSteps.CFileReader;
import de.ttsa.Logic.Compiler.CompilerSteps.CodeTester;

public class CodeTesterClass {
    

     
    
    
    // ------------------------------ PATHS ------------------------------



    protected final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/FeatureTest/";
    private final String TEST_FILE_TYPE_PATH = "/TestFiles/Code/";
    protected String PATH;



    // ----------------------------- METHODS -----------------------------


    protected CodeTesterClass(String testName) {
        PATH = TEST_FILE_PATH + testName + TEST_FILE_TYPE_PATH;
    }

    protected boolean testCode(String fileName) {
        CFileReader fileReader = new CFileReader(PATH + fileName);
        CodeTester codeTester = new CodeTester(fileReader.read());
        return codeTester.test();
    }

}
