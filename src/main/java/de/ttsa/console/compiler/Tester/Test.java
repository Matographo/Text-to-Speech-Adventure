package de.ttsa.console.compiler.Tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    File file;

    public Test(String file) {
        this.file = new File(file);
        if(!this.file.exists()) {
            throw new IllegalArgumentException("The file " + file + " does not exist.");
        }
    }

    public void start() throws IOException {
        ArrayList<String> content = getContent();
        testSyntax(content);
        testVariables(content);
        testBlocks(content);
    }




    private ArrayList<String> getContent() throws IOException {
        ArrayList<String> content = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = reader.readLine()) != null) {
            content.add(line);
        }
        reader.close();
        return content;
    }

    private void testSyntax(ArrayList<String> content) {
    
    }

    private void testVariables(ArrayList<String> content) {
    
    }

    private void testBlocks(ArrayList<String> content) {
    
    }
}
