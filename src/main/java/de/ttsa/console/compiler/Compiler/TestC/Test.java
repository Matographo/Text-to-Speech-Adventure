package de.ttsa.console.compiler.Compiler.TestC;

import java.io.File;
import java.util.ArrayList;

public class Test {

    ArrayList<ArrayList<String>> fileContent;

    public Test(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
    }

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
