package de.ttsa.ConsoleGame.Compiler.Compiler.CompileTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CFileReader {

    File data;

    public CFileReader(String path) {
        data = new File(path);
    }

    public ArrayList<ArrayList<String>> read() {
        if(isFile(data)) {
            ArrayList<ArrayList<String>> readed = new ArrayList<ArrayList<String>>();
            readed.add(readFile(data));
            return readed;
        } else {
            return readFolder(data);
        }
    }

    
    private ArrayList<ArrayList<String>> readFolder(File folder) {
        ArrayList<ArrayList<String>> readed = new ArrayList<ArrayList<String>>();
        if(folder.listFiles() != null) {
            File[] files = folder.listFiles();
            for(File file : files) {
                if(isFile(file)) {
                    readed.add(readFile(file));
                } else {
                    readed.addAll(readFolder(file));
                }
            }
            return readed;
        } else {
            return null;
        }
    }
    
    
    private ArrayList<String> readFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> readed = new ArrayList<String>();
            String line = "";
            while((line = reader.readLine()) != null) {
                readed.add(line);
            }
            reader.close();
            return readed;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isFile(File file) {
        if(file.isDirectory()) {
            output("Path is a directory");
            return false;
        } else if (file.isFile()){
            output("Path is a file");
            return true;
        } else {
            throw new IllegalArgumentException("Path is not valid");
        }
    }

    private void output(String message) {
        System.out.println(message);
    }
    
}
