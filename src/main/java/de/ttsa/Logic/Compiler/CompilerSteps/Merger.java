package de.ttsa.Logic.Compiler.CompilerSteps;

import java.util.ArrayList;

import de.ttsa.Frontend.Terminal.CompilerApp;
import de.ttsa.Tools.SimpleLog;

public class Merger {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    private ArrayList<ArrayList<String>> fileContent;
    private SimpleLog log = CompilerApp.log;



// ---------------------------------------------- Constructor -------------------------------------------------- //



    public Merger(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
    }



// ---------------------------------------------- Methods -------------------------------------------------- //



    public ArrayList<String> merge() {
        ArrayList<String> merged = new ArrayList<String>();
        for (ArrayList<String> file : fileContent) {
            merged.addAll(file);
        }
        log.debug("Merged " + merged.size() + " lines.");
        return merged;
    }


    
}
