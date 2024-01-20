package de.ttsa.ConsoleGame.Compiler.OpCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpCodeTest {

    private File file;


// ------------------ Command Seperators ------------------

    private final String COMMAND_SEPERATOR = "::";
    private final String SAY_SEPERATOR = ",";
    private final String ROOM_SEPERATOR = ":";

// ------------------ Command Inizes ----------------------
    private final String INDEX_SAY = "00";
    private final String INDEX_ROOM = "01";
    private final String INDEX_ROOM_JUMPER = "02";



    public OpCodeTest(String file) {
        this.file = new File(file);
        if(!this.file.exists()) {
            throw new IllegalArgumentException("The file " + file + " does not exist.");
        }
    }

    public boolean start() {
        boolean testResult = true;
        try {
            ArrayList<String> content = getContent();
            testResult = testResult && testSyntax(new ArrayList<String>(content));
            testResult = testResult && testVariables(new ArrayList<String>(content));
            testResult = testResult && testBlocks(new ArrayList<String>(content));
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
                    testResult = testResult && testSaySyntax(args);
                    break;
                case INDEX_ROOM:
                    testResult = testResult && testRoomSyntax(args);
                    break;
                case INDEX_ROOM_JUMPER:
                    testResult = testResult && testRoomJumperSyntax(args);
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
        boolean testResult = true;
        String command = "";
        String args = "";
        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(COMMAND_SEPERATOR)[0];
            args = content.get(i).substring(content.get(i).indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_ROOM:
                    testResult = testResult && testRoomBlock(args, new ArrayList<String>(content.subList(i, content.size())));
                    break;
                default:
                    continue;
            }
        }

        return testResult;
    }




// ------------------ Test Functions Syntax ----------------------



    private boolean testSaySyntax(String args) {
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

    private boolean testRoomSyntax(String args) {
        String[] arg = args.split(ROOM_SEPERATOR);
        if(arg.length != 2) {
            return false;
        }
        if(Character.isDigit(arg[0].charAt(0))) {
            return false;
        } else if (arg[0].contains(" ")) {
            return false;
        } else if(!arg[1].matches("\\d+")) {
            return false;
        }
        return true;
    }

    private boolean testRoomJumperSyntax(String args) {
        if(Character.isDigit(args.charAt(0))) {
            return false;
        } else if (args.contains(" ")) {
            return false;
        } else if (!args.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }
        return true;
    }


// ------------------ Test Functions Blocks ----------------------

    private boolean testRoomBlock(String args, ArrayList<String> content) {
        String[] arg = args.split(ROOM_SEPERATOR);
        if(Integer.parseInt(arg[1]) > content.size()) {
            return false;
        }
        return true;
    }

    

}
