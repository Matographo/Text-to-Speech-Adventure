package de.ttsa.TestClasses;

import java.util.ArrayList;

import de.ttsa.Logic.Compiler.CompilerSteps.CFileReader;
import de.ttsa.Logic.Compiler.CompilerSteps.Compiler;
import de.ttsa.Logic.Compiler.CompilerSteps.Merger;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CodeCompilerTesterClass {
    
    
    
    // ------------------------------ PATHS ------------------------------



    protected final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/CompilerTests/";



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

    protected boolean test(String path, String fileName) {
        ArrayList<String> compiled = compileFiles(getContent(path + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        return opCodeTest.start(compiled);
    }



}
