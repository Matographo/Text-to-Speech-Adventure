package de.ttsa.Logic.Compiler.Compiler.TestC;

import java.io.File;
import java.util.ArrayList;

public class Test {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    ArrayList<ArrayList<String>> fileContent;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public Test(ArrayList<ArrayList<String>> fileContent) {
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
