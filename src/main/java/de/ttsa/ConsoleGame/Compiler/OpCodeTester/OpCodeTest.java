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
    private final char IF_NUMBER = 'n';
    private final char IF_STRING = 's';
    private final char IF_INPUT = 'i';


// ------------------ Command Seperators ------------------

    private final String COMMAND_SEPERATOR = "::";
    private final String SAY_SEPERATOR = ",";
    private final String ROOM_SEPERATOR = ":";
    private final String NUMBER_VARIABLE_SEPERATOR = ":";
    private final String NUMBER_STRING_SEPERATOR = ":";
    private final String NUMBER_DEC_SEPERATOR = ":";
    private final String IF_NUM_SEPERATOR = ":";
    private final String IF_ELSE_SEPERATOR = ";;";
    private final String OFFORDER_SEPERATOR = "!!!";
    private final String VALUE_SEPERATOR = "!!";
    private final String STR_SEPERATOR = ":";

// ------------------ Command Inizes ----------------------
    private final String INDEX_SAY = "00";
    private final String INDEX_ROOM = "01";
    private final String INDEX_ROOM_JUMPER = "02";
    private final String INDEX_NUMBER_VARIABLE = "03";
    private final String INDEX_STRING_VARIABLE = "04";
    private final String INDEX_NUM_VARDEC = "05";
    private final String INDEX_IF = "06";
    private final String INDEX_INPUT = "07";
    private final String INDEX_STR_VARDEC = "08";
    private final String INDEX_DEBUG = "09";
    private final String INDEX_SAVE = "0A";
    private final String INDEX_LOAD = "0B";

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
                case INDEX_SAY -> testResult = testResult && testSaySyntax(args);
                case INDEX_ROOM -> testResult = testResult && testRoomSyntax(args);
                case INDEX_ROOM_JUMPER -> testResult = testResult && testRoomJumperSyntax(args);
                case INDEX_NUMBER_VARIABLE -> testResult = testResult && testNumberVariableSyntax(args);
                case INDEX_STRING_VARIABLE -> testResult = testResult && testStringVariableSyntax(args);
                case INDEX_NUM_VARDEC -> testResult = testResult && testNumberDecSyntax(args);
                case INDEX_IF -> testResult = testResult && testIfSyntax(args);
                case INDEX_INPUT -> testResult = testResult && testInputSyntax(args);
                case INDEX_STR_VARDEC -> testResult = testResult && testStrDecSyntax(args);
                case INDEX_DEBUG -> testResult = testResult && testDebugInputSyntax(args);
                case INDEX_SAVE -> testResult = testResult && testSaveSyntax(args);
                case INDEX_LOAD -> testResult = testResult && testLoadSyntax(args);
                default -> testResult = false;
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
                case INDEX_SAY -> testResult = testResult && testSayVar(args);
                case INDEX_ROOM -> testResult = testResult && testRoomVar(args);
                case INDEX_ROOM_JUMPER -> testResult = testResult && testRoomJumperVar(args);
                case INDEX_NUMBER_VARIABLE -> testResult = testResult && testNumberVariableVar(args);
                case INDEX_STRING_VARIABLE -> testResult = testResult && testStringVariableVar(args);
                case INDEX_NUM_VARDEC -> testResult = testResult && testNumberDecVar(args);
                case INDEX_IF -> testResult = testResult && testIfVar(args);
                case INDEX_DEBUG -> testResult = testResult && testDebugInputVar(args);
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
        else if(!isValideRoomName(arg[0])) return false;
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
        String[] toTest = args.split(IF_ELSE_SEPERATOR);
        boolean testResult = true;
        for(int i=0; i < toTest.length; i++) {
            if(i == toTest.length - 1) {
                testResult = testResult && isTestableElse(toTest[i]);
            } else {
                testResult = testResult && testIfSyntaxSwitch(toTest[i]);
            }
        }
        return testResult;
    }

    private boolean isTestableElse(String test) {
        if(test.startsWith(":") && isNumber(test.substring(1))) return true;
        return testIfSyntaxSwitch(test);
    }

    private boolean testIfSyntaxSwitch(String args) {
        char i = args.charAt(0);
        boolean testResult;
        switch(i) {
            case IF_NUMBER -> testResult = testIfSyntaxNum(args.substring(1));
            case IF_STRING -> testResult = testIfSyntaxStr(args.substring(1));
            case IF_INPUT -> testResult = testIfSyntaxIn(args.substring(1));
            default -> testResult = false;
        }
        return testResult;
    }

    private boolean testIfSyntaxNum(String args) {
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

    private boolean testIfSyntaxStr(String args) {
        if(!args.contains("==")) return false;
        if(!args.contains(":")) return false;
        if(!isNumber(args.substring(args.indexOf(":")+1))) return false;
        args = args.substring(0, args.indexOf(":"));
        String[] arg = args.split("==");
        if(arg.length != 2) return false;
        if(!isValidName(arg[0]) && !(arg[0].startsWith("\"") && arg[0].endsWith("\""))) return false;
        if(!isValidName(arg[1]) && !(arg[1].startsWith("\"") && arg[1].endsWith("\""))) return false;
        return true; 
    }

    private boolean testIfSyntaxIn(String args) {
        return checkOrderSyntax(args);
    }

    private boolean testInputSyntax(String args) {
        if(!args.strip().isEmpty()) return false;
        return true;
    }

    private boolean testStrDecSyntax(String args) {
        String[] strDecArgs = args.split(STR_SEPERATOR);
        if(strDecArgs.length != 2) return false;
        String strDecName = strDecArgs[0];
        if(!isValidName(strDecName)) return false;
        String operation = strDecArgs[1];
        if(!operation.startsWith("\"") && !operation.endsWith("\"") && !isValidName(operation)) return false;
        return true;
    }

    private boolean testDebugInputSyntax(String args) {
        if(args.strip().isEmpty()) return false;
        if(!isValidName(args) && !args.startsWith("\"") && !args.endsWith("\"")) return true;
        return true;
    }

    private boolean testSaveSyntax(String args) {
        if(!args.strip().isEmpty()) return false;
        return true;
    }

    private boolean testLoadSyntax(String args) {
        if(!args.strip().isEmpty()) return false;
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
        String[] toTest = args.split(IF_ELSE_SEPERATOR);
        boolean testResult = true;
        char i;
        for(String test : toTest) {
            i = test.charAt(0);
            switch(i) {
                case IF_NUMBER -> testResult = testResult && testIfVarNum(test.substring(1));
                case IF_STRING -> testResult = testResult && testIfVarStr(test.substring(1));
            }
        }
        return testResult;
    }

    private boolean testIfVarNum(String args) {
        String[] tests = args.split(IF_NUM_SEPERATOR);
        boolean testResult = true;
        String[] toTest = tests[0].split("[&]{2} | [|]{2}");
        for (String test : toTest) {
            testResult = testResult && isTestableVar(test);
        }
        return testResult;
    }

    private boolean testIfVarStr(String args) {
        args = args.substring(0, args.indexOf(":"));
        String[] tests = args.split("==");
        if(!strNames.contains(tests[0]) && !tests[0].startsWith("\"") && !tests[0].endsWith("\"")) return false;
        if(!strNames.contains(tests[1]) && !tests[1].startsWith("\"") && !tests[1].endsWith("\"")) return false;
        return true;
    }


    private boolean testDebugInputVar(String args) {
        if(isValidName(args)) {
            if(!strNames.contains(args)) return false;
        }
        return true;
    }




// ------------------ Test Functions Blocks ----------------------



    private boolean testRoomBlock(String args, int nextCodeLines) {
        if(getRoomBlockLength(args) <= nextCodeLines) return true;
        return false;
    }

    private boolean testIfBlock(String args, int ifPosition, int endOfRoom) {
        String[] toTest = args.split(IF_ELSE_SEPERATOR);
        int blockLenght = 0;
        for(String test : toTest) {
            blockLenght += getIfBlockLength(test);
        }
        return ifPosition + blockLenght + 1 <= endOfRoom;
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
            String[] toTest = test.split("[=<>!]");
            toTest = removeEmpty(toTest);
            if(toTest.length != 2) return false;
            return isCalculatable(toTest[0]) && isCalculatable(toTest[1]);
        } else {
            return false;
        }
    }

    private boolean isTestableVar(String test) {
        String[] tests = test.split(IF_ELSE_SEPERATOR);
        boolean testResult = true;
        char i;
        for(String toTest : tests) {
            i = toTest.charAt(0);
            switch(i) {
                case IF_NUMBER -> testResult = testResult && isTestableVarNum(toTest.substring(1));
                case IF_STRING -> testResult = testResult && isTestableVarStr(toTest.substring(1));
            }
        }
        return testResult;
    }

    private boolean isTestableVarNum(String test) {
        if(test.contains("=") || test.contains("<") || test.contains(">")) {
            String[] toTest = test.split("[=<>!]");
            toTest = removeEmpty(toTest);
            if(toTest.length != 2) return false;
            return isCalculatableVar(toTest[0]) && isCalculatableVar(toTest[1]);
        } else {
            return false;
        }
    }

    private boolean isTestableVarStr(String test) {
        String[] arg = test.split("==");
        if(!strNames.contains(arg[0]) && !arg[0].startsWith("\"") && !arg[0].endsWith("\"")) return false;
        if(!strNames.contains(arg[1]) && !arg[0].startsWith("\"") && !arg[0].endsWith("\"")) return false;
        return true;
    }

    private int getIfBlockLength(String args) {
        String[] arg = args.split(IF_NUM_SEPERATOR);
        return Integer.parseInt(arg[1]);
    }

    private int getRoomBlockLength(String args) {
        String[] arg = args.split(ROOM_SEPERATOR);
        return Integer.parseInt(arg[1]);
    }

    private String[] removeEmpty(String[] toTest) {
        ArrayList<String> list = new ArrayList<String>(toTest.length);
        for(String test : toTest) {
            if(!test.strip().isEmpty()) {
                list.add(test);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private boolean isValideRoomName(String name) {
        String[] names = name.split(" ");
        for(String n : names) {
            if(!isValidName(n)) return false;
        }
        return true;
    }

    private boolean checkOrderSyntax(String args) {
        boolean testResult = true;
        if(args.startsWith("(") && args.endsWith(")")) {
            args = args.substring(1, args.length()-1);
            String[] offOrder = args.split(OFFORDER_SEPERATOR);
            for(String order : offOrder) {
                testResult = testResult && checkOffOrderSyntax(order);
            }
        } else {
            testResult = testResult && checkOffOrderSyntax(args);
        }
        return testResult;
    }

    private boolean checkOffOrderSyntax(String args) {
        boolean testResult = true;
        if(args.startsWith("\"") && args.endsWith("\"")) {
            args = args.substring(1, args.length()-1);
            String[] values = args.split(VALUE_SEPERATOR);
            for(String value : values) {
                testResult = testResult && checkValueSyntax(value);
            }
        } else {
            testResult = testResult && checkValueSyntax(args);
        }
        return testResult;
    }

    private boolean checkValueSyntax(String args) {
        if(args.startsWith("'") && args.endsWith("'")) {
            args = args.substring(1, args.length()-1);
            if(!isValidName(args)) return false;
        }
        return true;
    }

}
