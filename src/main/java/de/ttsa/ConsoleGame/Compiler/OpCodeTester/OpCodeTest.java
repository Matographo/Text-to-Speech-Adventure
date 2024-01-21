package de.ttsa.ConsoleGame.Compiler.OpCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class OpCodeTest {

    private File file;


// ------------------ Command Seperators ------------------

    private final String COMMAND_SEPERATOR = "::";
    private final String SAY_SEPERATOR = ",";
    private final String ROOM_SEPERATOR = ":";
    private final String NUMBER_VARIABLE_SEPERATOR = ":";
    private final String NUMBER_STRING_SEPERATOR = ":";
    private final String NUMBER_DEC_SEPERATOR = ":";

// ------------------ Command Inizes ----------------------
    private final String INDEX_SAY = "00";
    private final String INDEX_ROOM = "01";
    private final String INDEX_ROOM_JUMPER = "02";
    private final String INDEX_NUMBER_VARIABLE = "03";
    private final String INDEX_NUMBER_STRING = "04";
    private final String INDEX_NUM_VARDEC = "05";

// ------------------ Variables Memory --------------------

    private HashSet<String> roomNames = new HashSet<String>();
    private HashSet<String> varNames = new HashSet<String>();
    private HashSet<String> numNames = new HashSet<String>();
    private HashSet<String> strNames = new HashSet<String>();

// -------------------- Constructor -----------------------

    public OpCodeTest(String file) {
        this.file = new File(file);
        if(!this.file.exists()) {
            throw new IllegalArgumentException("The file " + file + " does not exist.");
        }
    }


// ----------------------- Start --------------------------


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


// -------------------- Load Data ------------------------


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


// ----------------- Test All Syntax ---------------------


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
                case INDEX_NUMBER_VARIABLE:
                    testResult = testResult && testNumberVariableSyntax(args);
                    break;
                case INDEX_NUMBER_STRING:
                    testResult = testResult && testStringVariableSyntax(args);
                    break;
                case INDEX_NUM_VARDEC:
                    testResult = testResult && testNumberDecSyntax(args);
                    break;
                default:
                    testResult = false;
                    break;
            }
        }

        return testResult;
    }


// ----------------- Test All Variables ----------------------


    private boolean testVariables(ArrayList<String> content) {
        boolean testResult = true;
        String command = "";
        String args = "";
        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(COMMAND_SEPERATOR)[0];
            args = content.get(i).substring(content.get(i).indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_SAY:
                    testResult = testResult && testSayVar(args);
                    break;
                case INDEX_ROOM:
                    testResult = testResult && testRoomVar(args);
                    break;
                case INDEX_ROOM_JUMPER:
                    testResult = testResult && testRoomJumperVar(args);
                    break;
                case INDEX_NUMBER_VARIABLE:
                    testResult = testResult && testNumberVariableVar(args);
                    break;
                case INDEX_NUMBER_STRING:
                    testResult = testResult && testStringVariableVar(args);
                    break;
                case INDEX_NUM_VARDEC:
                    testResult = testResult && testNumberDecVar(args);
                    break;
                default:
                    continue;
            }
        }
        return testResult;
    }


// ------------------ Test All Blocks -----------------------


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
            } else if (isValidName(arg)) {
                testResult = testResult && true;
            } else {
                testResult = false;
            }
        }
        return testResult;
    }

    private boolean testRoomSyntax(String args) {
        String[] arg = args.split(ROOM_SEPERATOR);
        if(arg.length != 2) return false;
        else if(!isValidName(arg[0])) return false;
        else if (!isNumber(arg[1])) return false;
        return true;
    }

    private boolean testRoomJumperSyntax(String args) {
        if(isValidName(args)) return true;
        return true;
    }

    private boolean testNumberVariableSyntax(String args) {
        String[] arg = args.split(NUMBER_VARIABLE_SEPERATOR);
        if(arg.length != 2) return false;
        else if(!isValidName(arg[0])) return false;
        else if (!isNumber(arg[1])) return false;
        return true;
    }

    private boolean testStringVariableSyntax(String args) {
        String[] arg = args.split(NUMBER_STRING_SEPERATOR);
        if(arg.length != 2) return false;
        else if(!isValidName(arg[0])) return false;
        return true;
    }

    private boolean testNumberDecSyntax(String args) {
        String[] arg = args.split(NUMBER_DEC_SEPERATOR);
        if(arg.length != 2) return false;
        else if(!isValidName(arg[0])) return false;
        else if (!isNumber(arg[1]) && !isValidName(arg[1])) return false;
        return true;
    }

// ------------------ Test Functions Variables -------------------


    private boolean testSayVar(String args) {
        String[] allArgs = args.split(SAY_SEPERATOR);
        boolean testResult = true;
        for(String arg : allArgs) {
            if(arg.startsWith("\"") && arg.endsWith("\"")) {
                continue;
            } else if (isValidName(arg)) {
                if(!varNames.contains(arg)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return testResult;
    }

    private boolean testRoomVar(String args) {
        String[] arg = args.split(ROOM_SEPERATOR);
        if(roomNames.contains(arg[0])) return false;
        roomNames.add(arg[0]);
        return true;
    }

    private boolean testRoomJumperVar(String args) {
        if(!roomNames.contains(args)) return true;
        return false;
    }

    private boolean testNumberVariableVar(String args) {
        String[] arg = args.split(NUMBER_VARIABLE_SEPERATOR);
        if(varNames.contains(arg[0])) return false;
        varNames.add(arg[0]);
        numNames.add(arg[0]);
        return true;
    }

    private boolean testStringVariableVar(String args) {
        String[] arg = args.split(NUMBER_STRING_SEPERATOR);
        if(varNames.contains(arg[0])) return false;
        varNames.add(arg[0]);
        strNames.add(arg[0]);
        return true;
    }

    private boolean testNumberDecVar(String args) {
        String[] arg = args.split(NUMBER_DEC_SEPERATOR);
        String numName = arg[0];
        String value = arg[1];
        if(!varNames.contains(numName)) return false;
        if(!isNumber(value) && !varNames.contains(value)) return false;
        if(!numNames.contains(value)) return false;
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



// ------------------ Test Help Functions ----------------------


    private boolean isValidName(String name) {
        if(Character.isDigit(name.charAt(0))) {
            return false;
        } else if (name.contains(" ")) {
            return false;
        } else if (!name.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String number) {
        if(number.matches("\\d+")) {
            return true;
        }
        return false;
    }
    

}
