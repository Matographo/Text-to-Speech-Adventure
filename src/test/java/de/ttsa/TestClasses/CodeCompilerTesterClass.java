package de.ttsa.TestClasses;

import java.util.ArrayList;

import de.ttsa.Logic.Compiler.Compiler.CompileC.Compiler;
import de.ttsa.Logic.Compiler.Compiler.CompileTools.CFileReader;
import de.ttsa.Logic.Compiler.Compiler.CompileTools.Merger;
import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeTest;

public class CodeCompilerTesterClass {
    
    
    
    // ------------------------------ PATHS ------------------------------



    protected final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/CompilerTests/";

    protected final String TO_COMPILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/CompileTmpFiles/";



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
