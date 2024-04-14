package de.ttsa.ConsoleGame.Compiler.Compiler.CompileTools;

import java.util.ArrayList;

public class Merger {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    ArrayList<ArrayList<String>> fileContent;



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
        return merged;
    }


    
}
