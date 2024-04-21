package de.ttsa.Logic.Compiler.CompilerSteps;

import java.io.File;
import java.util.ArrayList;


/**
 * This class is used to test the pre-compiled code
 */
public class CodeTester {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    ArrayList<ArrayList<String>> fileContent;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public CodeTester(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
    }



// ----------------------------------------------- Methods ---------------------------------------------------- //



    public boolean test() {
        return true;
    }

    private boolean startTests(File file) {
        return false;
    }

    private boolean startTest(File file) {
        return false;
    }
    
}
