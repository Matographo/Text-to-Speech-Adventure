package de.ttsa.Logic.Compiler.CompilerSteps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Frontend.Terminal.CompilerApp;
import de.ttsa.Tools.SimpleLog;


public class CFileReader {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    private final String CODE_FILE_EXTENSION = "tac";
    private File data;
    private SimpleLog log = CompilerApp.log;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public CFileReader(String path) {
        data = new File(path);
    }



// ----------------------------------------------- Methods ---------------------------------------------------- //



    public ArrayList<ArrayList<String>> read() {
        if(isFile(data) && data.getName().endsWith("." + CODE_FILE_EXTENSION)) {
            ArrayList<ArrayList<String>> readed = new ArrayList<ArrayList<String>>();
            readed.add(readFile(data));
            return readed;
        } else {
            return readFolder(data);
        }
    }

    
    private ArrayList<ArrayList<String>> readFolder(File folder) {
        ArrayList<ArrayList<String>> readed = new ArrayList<>();
        File[] files = folder.listFiles();
        if(files != null) {
            for(File file : files) {
                if(isFile(file) && file.getName().endsWith("." + CODE_FILE_EXTENSION)) {
                    readed.add(readFile(file));
                } else {
                    readed.addAll(readFolder(file));
                }
            }
            return readed;
        }
        return readed;
    }
    
    
    private ArrayList<String> readFile(File file) {
        if(!file.getAbsolutePath().endsWith("." + CODE_FILE_EXTENSION)) return new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> readed = new ArrayList<>();
            String line = "";
            while((line = reader.readLine()) != null) {
                line = line.strip();
                if(line.isEmpty()) {
                    continue;
                }
                if(line.startsWith(CompilerSyntax.COMMENT.toString())) {
                    continue;
                }
                readed.add(line);
            }
            reader.close();
            return readed;
        } catch(Exception e) {
            log.trace(e.getStackTrace().toString());
        }
        return null;
    }

    private boolean isFile(File file) {
        if(file.isDirectory()) {
            return false;
        } else if (file.isFile()){
            return true;
        } else {
            log.error("Path " + file.getAbsolutePath() + " is not valid.");
            throw new IllegalArgumentException("Path is not valid");
        }
    }
    
}
