package de.ttsa.ConsoleGame.Compiler.ComCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CCodeTest {

    File file;


// ------------------ Command Seperators ------------------

    private final String COMMAND_SEPERATOR = "::";
    private final String SAY_SEPERATOR = ",";

// ------------------ Command Inizes ----------------------
    private final String INDEX_SAY = "00";



    public CCodeTest(String file) {
        this.file = new File(file);
        if(!this.file.exists()) {
            throw new IllegalArgumentException("The file " + file + " does not exist.");
        }
    }

    public boolean start() {
        boolean testResult = true;
        try {
            ArrayList<String> content = getContent();
            testResult = testResult && testSyntax(content);
            testResult = testResult && testVariables(content);
            testResult = testResult && testBlocks(content);
        } catch(Exception e) {
            return false;
        }
        return testResult;
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

    private boolean testSyntax(ArrayList<String> content) {
        boolean testResult = true;
        String command = "";
        String args = "";
        for(String line : content) {
            command = line.split(COMMAND_SEPERATOR)[0];
            args = line.substring(line.indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_SAY:
                    testResult = testResult && testSay(args);
                    break;
                default:
                    testResult = false;
                    break;
            }
        }


        return testResult;
    }

    private boolean testVariables(ArrayList<String> content) {
        return true;
    }

    private boolean testBlocks(ArrayList<String> content) {
        return true;
    }



    private boolean testSay(String args) {
        String[] allArgs = args.split(SAY_SEPERATOR);
        boolean testResult = true;
        if(allArgs.length == 0) {
            return false;
        }
        for(String arg : allArgs) {
            if(arg.startsWith("\"") && arg.endsWith("\"")) {
                testResult = testResult && true;
            } else {
                testResult = false;
            }
        }
        return testResult;
    }






    public String getOutput() {
        return "";
    }
}
