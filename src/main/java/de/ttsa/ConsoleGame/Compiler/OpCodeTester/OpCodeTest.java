package de.ttsa.ConsoleGame.Compiler.OpCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class OpCodeTest {

    private File file;
// ------------------ Attributs ---------------------------

    private final String CALCULATABLE = "^(([-]?([0-9]))*|([-]?([a-zA-Z]+[a-zA-Z0-9])))*(?:[-+*/][-]?[a-zA-Z0-9]+)*$";
    private final String AND = "&&";
    private final String OR = "||";
    private final String NOT = "!";


// ------------------ Command Seperators ------------------

    private final String COMMAND_SEPERATOR = "::";
    private final String SAY_SEPERATOR = ",";
    private final String ROOM_SEPERATOR = ":";
    private final String NUMBER_VARIABLE_SEPERATOR = ":";
    private final String NUMBER_STRING_SEPERATOR = ":";
    private final String NUMBER_DEC_SEPERATOR = ":";
    private final String IF_NUM_SEPERATOR = ":";

// ------------------ Command Inizes ----------------------
    private final String INDEX_SAY = "00";
    private final String INDEX_ROOM = "01";
    private final String INDEX_ROOM_JUMPER = "02";
    private final String INDEX_NUMBER_VARIABLE = "03";
    private final String INDEX_NUMBER_STRING = "04";
    private final String INDEX_NUM_VARDEC = "05";
    private final String INDEX_IF = "06";

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
                case INDEX_IF:
                    testResult = testResult && testIfSyntax(args);
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
                case INDEX_IF:
                    testResult = testResult && testIfVar(args);
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
        int lastRoomLength = -1;
        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(COMMAND_SEPERATOR)[0];
            args = content.get(i).substring(content.get(i).indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_ROOM:
                    lastRoomLength = getRoomBlockLength(args);
                    testResult = testResult && testRoomBlock(args, content.size() - i);
                    break;
                case INDEX_IF:
                    testResult = testResult && testIfBlock(args, i, i + lastRoomLength);
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
        if(!isValidName(args)) return false;
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
        String value = arg[1];
        if(arg.length != 2) return false;
        else if(!isValidName(arg[0])) return false;
        if(!value.contains("*") && !value.contains("/") && !value.contains("-") && !value.contains("+")) {
            if(!isNumber(value) && !isNumVar(value)) return false;
            else return true;
        }
        return isCalculatable(value);
    }

    private boolean testIfSyntax(String args) {
        String[] toTest = args.split(IF_NUM_SEPERATOR);
        boolean testResult = true;
        if(toTest.length != 2) return false;
        if(!isNumber(toTest[1])) return false;
        String[] toTestBig = toTest[0].split("[&]{2} | [|]{2}");
        for (String test : toTestBig) {
            testResult = testResult && isTestable(test);
        }
        return testResult;
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
        if(!roomNames.contains(args)) return false;
        return true;
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
        if(!value.contains("*") && !value.contains("/") && !value.contains("-") && !value.contains("+")) {
            if(!isNumber(value) && !isNumVar(value)) return false;
            else return true;
        }
        return isCalculatableVar(value);
    }

    private boolean testIfVar(String args) {
        String[] tests = args.split(IF_NUM_SEPERATOR);
        boolean testResult = true;
        String[] toTest = tests[0].split("[&]{2} | [|]{2}");
        for (String test : toTest) {
            testResult = testResult && isTestableVar(test);
        }
        return testResult;
    }



// ------------------ Test Functions Blocks ----------------------



    private boolean testRoomBlock(String args, int nextCodeLines) {
        if(getRoomBlockLength(args) <= nextCodeLines) return true;
        return false;
    }

    private boolean testIfBlock(String args, int ifPosition, int endOfRoom) {
        return ifPosition + getIfBlockLength(args) + 1 <= endOfRoom;
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

    private boolean isNumVar(String name) {
        if(!isNumber(name) && numNames.contains(name)) return true;
        return false;
    }

    private boolean isStrVar(String name) {
        if(!isNumber(name) && strNames.contains(name)) return true;
        return false;
    }

    private boolean isCalculatable(String value) {
        return testBreacketsCount(value) && testBreackets(value);
    }

    private boolean isCalculatableVar(String value) {
        String[] values = value.split("[\\+\\-\\*/\\(\\)]");
        String[] ops = value.split("[a-zA-Z0-9]");
        
        for(String val : values) {
            if(val.equals("")) continue;
            if(!isNumber(val) && !isNumVar(val)) return false;
        }
        return true;
    }

    private boolean testBreacketsCount(String value) {
        int count = 0;
        for(int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '(') count++;
            else if (value.charAt(i) == ')') count--;
        }
        return count == 0;
    }

    private boolean testBreackets(String value) {
        boolean testResult = true;
        String toTest = "";
        int begin;
        int end;
        if(value.contains("(") && value.contains(")")) {
            while (value.contains("(") && value.contains(")")) {
                begin = value.lastIndexOf("(");
                end = value.lastIndexOf(toTest, value.indexOf(")"));
                toTest = value.substring(begin+1, end);
                value = value.substring(0, begin) + 1 + value.substring(end+1, value.length());
                testResult = testResult && testBreackets(toTest);
            }
        } 
        if (value.contains("(") || value.contains(")")) {
            return false;
        }
        return value.matches(CALCULATABLE);
    }

    private boolean isTestable(String test) {
        if(test.contains("=") || test.contains("<") || test.contains(">")) {
            String[] toTest = test.split("[=<>]");
            if(toTest.length != 3) return false;
            return isCalculatable(toTest[0]) && isCalculatable(toTest[1]);
        } else {
            return false;
        }
    }

    private boolean isTestableVar(String test) {
        if(test.contains("=") || test.contains("<") || test.contains(">")) {
            String[] toTest = test.split("[=<>]");
            if(toTest.length != 3) return false;
            return isCalculatableVar(toTest[0]) && isCalculatableVar(toTest[2]);
        } else {
            return false;
        }
    }

    private int getIfBlockLength(String args) {
        String[] arg = args.split(IF_NUM_SEPERATOR);
        return Integer.parseInt(arg[1]);
    }

    private int getRoomBlockLength(String args) {
        String[] arg = args.split(ROOM_SEPERATOR);
        return Integer.parseInt(arg[1]);
    }

}
