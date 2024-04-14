package de.ttsa.ConsoleGame.Compiler.OpCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.ConsoleGame.ClassTools.OpCode;

public class OpCodeTest extends OpCode{



// --------------------------------------------- Attributes -------------------------------------------------- //



    private File file;



// ------------------------------------------- Variables Memory ---------------------------------------------- //



    private HashSet<String> roomNames   = new HashSet<String>();
    private HashSet<String> varNames    = new HashSet<String>();
    private HashSet<String> numNames    = new HashSet<String>();
    private HashSet<String> strNames    = new HashSet<String>();
    private HashSet<String> actionNames = new HashSet<String>();
    private HashSet<String> setNames    = new HashSet<String>();

    private HashMap<String, String> actionArgs = new HashMap<>();



// ---------------------------------------------- Constructor ----------------------------------------------- //



    /**
     * Constructor
     * @param fileName The file to test
     */
    public OpCodeTest(String fileName) {
        this.file = new File(fileName);


        if(!this.file.exists()) throw new IllegalArgumentException("The file " + fileName + " does not exist.");
    }

    public OpCodeTest() {
    }



// ---------------------------------------------- Start -------------------------------------------------- //



    /**
     * Start the test
     * @return true if the test is successful
     */
    public boolean start() {
        boolean testResult = true;


        try {
            ArrayList<String> content = getContent();

            testResult = testSyntax(new ArrayList<String>(content))    && testResult;
            testResult = testVariables(new ArrayList<String>(content)) && testResult;
            testResult = testBlocks(new ArrayList<String>(content))    && testResult;

        } catch(Exception e) {
            return false;
        }

        return testResult;
    }

    public boolean start(ArrayList<String> content) {
        boolean testResult = true;

        try {
            testResult = testSyntax(new ArrayList<String>(content)) && testResult;
            testResult = testVariables(new ArrayList<String>(content)) && testResult;
            testResult = testBlocks(new ArrayList<String>(content)) && testResult;

        } catch (Exception e) {
            return false;
        }

        return testResult;
    }

    public static boolean test(ArrayList<String> content) {
        boolean testResult = true;
        OpCodeTest test = new OpCodeTest();

        testResult = test.testSyntax(new ArrayList<String>(content)) && testResult;
        testResult = test.testVariables(new ArrayList<String>(content)) && testResult;
        testResult = test.testBlocks(new ArrayList<String>(content)) && testResult;

        return testResult;
    }

    public static boolean test(String line) {
        ArrayList<String> content = new ArrayList<String>();
        content.add(line);
        return new OpCodeTest().testSyntax(content);
    }



// ------------------------------------------- Load Data ---------------------------------------------- //



    /**
     * Load the content of the file
     * @return The content of the file
     * @throws IOException
     */
    private ArrayList<String> getContent() throws IOException {
        ArrayList<String> content = new ArrayList<String>();
        BufferedReader reader     = new BufferedReader(new FileReader(file));
        String line = "";


        while ((line = reader.readLine()) != null) {
            content.add(line);
        }

        reader.close();
        return content;
    }



// ---------------------------------------- Test All Syntax -------------------------------------------- //


    /**
     * Test the syntax of every line
     * @param content The lines to Test
     * @return true if the syntax is correct
     */
    private boolean testSyntax(ArrayList<String> content) {
        boolean testResult = true;
        String command     = "";
        String args        = "";


        for(String line : content) {
            command = line.split(COMMAND_SEPERATOR)[0];
            args    = line.substring(line.indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_SAY  ->              testResult = testResult && testSaySyntax(args);
                case INDEX_ROOM ->              testResult = testResult && testRoomSyntax(args);
                case INDEX_ROOM_JUMPER ->       testResult = testResult && testRoomJumperSyntax(args);
                case INDEX_NUMBER_VARIABLE ->   testResult = testResult && testNumberVariableSyntax(args);
                case INDEX_STRING_VARIABLE ->   testResult = testResult && testStringVariableSyntax(args);
                case INDEX_NUM_VARDEC ->        testResult = testResult && testNumberDecSyntax(args);
                case INDEX_IF ->                testResult = testResult && testIfSyntax(args);
                case INDEX_INPUT ->             testResult = testResult && testInputSyntax(args);
                case INDEX_STR_VARDEC ->        testResult = testResult && testStrDecSyntax(args);
                case INDEX_DEBUG ->             testResult = testResult && testDebugInputSyntax(args);
                case INDEX_SAVE ->              testResult = testResult && testSaveSyntax(args);
                case INDEX_LOAD ->              testResult = testResult && testLoadSyntax(args);
                case INDEX_EXIT ->              testResult = testResult && testExitSyntax(args);
                case INDEX_LOOP ->              testResult = testResult && testLoopSyntax(args);
                case INDEX_LOOP_BREAKER ->      testResult = testResult && testLoopBreakerSyntax(args);
                case INDEX_SET ->               testResult = testResult && testSetSyntax(args);
                case INDEX_ACTION ->            testResult = testResult && testActionSyntax(args);
                case INDEX_ACTION_CALL ->       testResult = testResult && testActionCallSyntax(args);
                default ->                      testResult = false;
            }
        }

        return testResult;
    }



// --------------------------------------------- Test All Variables ----------------------------------------- //



    /**
     * Test the variables of every line to make sure they dont use undeclared variables
     * or use variables that are not allowed or not double declared
     * @param content The lines to test
     * @return true if the variables are correct declared and used
     */
    private boolean testVariables(ArrayList<String> content) {
        boolean testResult = true;
        String command     = "";
        String args        = "";


        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(COMMAND_SEPERATOR)[0];
            args    = content.get(i).substring(content.get(i).indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_SAY ->               testResult = testResult && testSayVar(args);
                case INDEX_ROOM ->              testResult = testResult && testRoomVar(args);
                case INDEX_ROOM_JUMPER ->       testResult = testResult && testRoomJumperVar(args);
                case INDEX_NUMBER_VARIABLE ->   testResult = testResult && testNumberVariableVar(args);
                case INDEX_STRING_VARIABLE ->   testResult = testResult && testStringVariableVar(args);
                case INDEX_NUM_VARDEC ->        testResult = testResult && testNumberDecVar(args);
                case INDEX_IF ->                testResult = testResult && testIfVar(args);
                case INDEX_DEBUG ->             testResult = testResult && testDebugInputVar(args);
                case INDEX_STR_VARDEC ->        testResult = testResult && testStrVarDec(args);
                case INDEX_LOOP ->              testResult = testResult && testLoopVar(args);
                case INDEX_SET ->               testResult = testResult && testSetVar(args);
                case INDEX_ACTION ->            testResult = testResult && testActionVar(args);
                case INDEX_ACTION_CALL ->       testResult = testResult && testActionCallVar(args);
            }
        }

        return testResult;
    }



// -------------------------------------------- Test All Blocks -------------------------------------------- //



    /**
     * Test the blocks of the code if the block is correct and not to long
     * @param content The lines to test
     * @return true if the blocks are correct
     */
    private boolean testBlocks(ArrayList<String> content) {
        boolean testResult = true;
        String command     = "";
        String args        = "";
        int lastRoomLength = -1;


        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(COMMAND_SEPERATOR)[0];
            args    = content.get(i).substring(content.get(i).indexOf(COMMAND_SEPERATOR) + command.length()).strip();

            switch(command) {
                case INDEX_ROOM:
                    lastRoomLength = getRoomBlockLength(args);

                    testResult = testResult && testRoomBlock(args, content.size() - i);
                    break;
                case INDEX_IF:
                    testResult = testResult && testIfBlock(args, i, i + lastRoomLength);
                    break;
                case INDEX_LOOP:
                    testResult = testResult && testLoopBlock(args, i, i + lastRoomLength);
                    break;
                case INDEX_ACTION:
                    testResult = testResult && testActionBlock(args, content.size() - i);
                    break;
                default:
                    continue;
            }
        }

        return testResult;
    }



// ----------------------------------------- Test Functions Syntax ------------------------------------------ //



    /**
     * Test the syntax of the say command
     * @param args The arguments of the say command
     * @return true if the syntax is correct
     */
    private boolean testSaySyntax(String args) {
        return args.matches(REGEX_SAY);
    }

    /**
     * Test the syntax of the room command
     * @param args The arguments of the room command
     * @return true if the syntax is correct
     */
    private boolean testRoomSyntax(String args) {
        return args.matches(REGEX_ROOM);
    }

    /**
     * Test the syntax of the room jumper command
     * @param args The arguments of the room jumper command
     * @return true if the syntax is correct
     */
    private boolean testRoomJumperSyntax(String args) {
        return args.matches(REGEX_ROOM_JUMPER);
    }

    /**
     * Test the syntax of the number variable command
     * @param args The arguments of the number variable command
     * @return true if the syntax is correct
     */
    private boolean testNumberVariableSyntax(String args) {
        return args.matches(REGEX_NUMBER_VARIABLE);
    }

    /**
     * Test the syntax of the string variable command
     * @param args The arguments of the string variable command
     * @return true if the syntax is correct
     */
    private boolean testStringVariableSyntax(String args) {
        return args.matches(REGEX_STRING_VARIABLE);
    }

    /**
     * Test the syntax of the number variable declaration command
     * @param args The arguments of the number variable declaration command
     * @return true if the syntax is correct
     */
    private boolean testNumberDecSyntax(String args) {
        String[] arg = args.split(NUMBER_DEC_SEPERATOR);
        String value = arg[1];


        if(arg.length != 2)           return false;
        else if(!isValidName(arg[0])) return false;
        
        if(!value.contains("*") && !value.contains("/") && !value.contains("-") && !value.contains("+")) {
            if(!isNumber(value) && !isValidName(value)) return false;
            else                                        return true;
        }

        return isCalculatable(value);
    }

    /**
     * Test the syntax of the if command
     * @param args The arguments of the if command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntax(String args) {
        String[] toTest    = args.split(IF_ELSE_SEPERATOR);
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

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean isTestableElse(String test) {
        if(test.startsWith(":") && isNumber(test.substring(1))) return true;

        return testIfSyntaxSwitch(test);
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxSwitch(String args) {
        char i = args.charAt(0);
        args   = args.substring(1, args.indexOf(IF_NUM_SEPERATOR));
        boolean testResult;

        switch(i) {
            case IF_NUMBER -> testResult = testIfSyntaxNum(args);
            case IF_STRING -> testResult = testIfSyntaxStr(args);
            case IF_INPUT ->  testResult = testIfSyntaxIn(args);
            default ->        testResult = false;
        }

        return testResult;
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxNum(String args) {
        while(hasBrackets(args)) {
            if(!testIfSyntaxNumInnerBreckets(getInnerBreckets(args))) return false;
            args = removeInnerBrecketsAndSubstitut(args, "1");
        }
        return args.matches(REGEX_IF_NUMBER);
    }

    private boolean testIfSyntaxNumInnerBreckets(String args) {
        return args.matches(REGEX_IF_INNER_BRECKETS);
    }

    private String getInnerBreckets(String args) {
        int start = args.lastIndexOf("(") + 1;
        args = args.substring(start);
        return args.substring(0, args.indexOf(")"));
    }

    private String removeInnerBrecketsAndSubstitut(String args, String substitut) {
        int start = args.lastIndexOf("(");
        String startStr = args.substring(0, start);
        args = args.substring(start+1);
        String endStr = args.substring(args.indexOf(")") + 1);
        return startStr + substitut + endStr;
    }

    private boolean hasBrackets(String args) {
        return args.contains("(") || args.contains(")");
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxStr(String args) {
        return args.matches(REGEX_IF_STRING);
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testIfSyntaxIn(String args) {
        return args.matches(REGEX_IF_INPUT);
    }

    /**
     * Test the syntax of the input command
     * @param args The arguments of the input command
     * @return true if the syntax is correct
     */
    private boolean testInputSyntax(String args) {
        return args.strip().isEmpty();
    }

    /**
     * Test the syntax of the string variable declaration command
     * @param args The arguments of the string variable declaration command
     * @return true if the syntax is correct
     */
    private boolean testStrDecSyntax(String args) {
        return args.matches(REGEX_STR_VARDEC);
    }

    /**
     * Test the syntax of the debug input command
     * @param args The arguments of the debug input command
     * @return true if the syntax is correct
     */
    private boolean testDebugInputSyntax(String args) {
        return args.matches(REGEX_DEBUG);
    }

    /**
     * Test the syntax of the save command
     * @param args The arguments of the save command
     * @return true if the syntax is correct
     */
    private boolean testSaveSyntax(String args) {
        return args.strip().isEmpty();
    }

    /**
     * Test the syntax of the load command
     * @param args The arguments of the load command
     * @return true if the syntax is correct
     */
    private boolean testLoadSyntax(String args) {
        return args.strip().isEmpty();
    }

    /**
     * Test the syntax of the exit command
     * @param args The arguments of the exit command
     * @return true if the syntax is correct
     */
    private boolean testExitSyntax(String args) {
        return args.matches(REGEX_EXIT);
    }

    /**
     * Test the syntax of the loop command
     * @param args The arguments of the loop command
     * @return true if the syntax is correct
     */
    private boolean testLoopSyntax(String args) {
        String argsTyp2 = args.substring(0, args.indexOf(IF_NUM_SEPERATOR));


        return testIfSyntaxSwitch(args) || argsTyp2.matches(REGEX_LOOP);
    }

    /**
     * Test the syntax of the loop breaker command
     * @param args The arguments of the loop breaker command
     * @return true if the syntax is correct
     */
    private boolean testLoopBreakerSyntax(String args) {
        return args.strip().isEmpty();
    }

    /**
     * Test the syntax of the set command
     * @param args The arguments of the set command
     * @return true if the syntax is correct
     */
    private boolean testSetSyntax(String args) {
        return args.matches(REGEX_SET);
    }

    /**
     * Test the syntax of the action command
     * @param args The arguments of the action command
     * @return true if the syntax is correct
     */
    private boolean testActionSyntax(String arg) {
        return arg.matches(REGEX_ACTION);
    }

    /**
     * Test the syntax of the action call command
     * @param args The arguments of the action call command
     * @return true if the syntax is correct
     */
    private boolean testActionCallSyntax(String arg) {
        return arg.matches(REGEX_ACTION_CALL);
    }



// ------------------------------------------- Test Functions Variables ---------------------------------------- //



    /**
     * Test the variables of the say command
     * @param args The arguments of the say command
     * @return true if the variables are correct
     */
    private boolean testSayVar(String args) {
        String[] allArgs   = args.split(SAY_SEPERATOR);
        boolean testResult = true;


        for(String arg : allArgs) {
            if(arg.startsWith("\"") && arg.endsWith("\"")) continue;
            else if (isValidName(arg)) {

                if(!varNames.contains(arg)) {
                    return false;
                }

            } else {
                return false;
            }
        }

        return testResult;
    }

    /**
     * Test the variables of the room command
     * @param args The arguments of the room command
     * @return true if the variables are correct
     */
    private boolean testRoomVar(String args) {
        String[] arg = args.split(ROOM_SEPERATOR);

        if(roomNames.contains(arg[0])) return false;

        roomNames.add(arg[0]);

        return true;
    }

    /**
     * Test the variables of the room jumper command
     * @param args The arguments of the room jumper command
     * @return true if the variables are correct
     */
    private boolean testRoomJumperVar(String args) {
        return roomNames.contains(args);
    }

    /**
     * Test the variables of the number variable command
     * @param args The arguments of the number variable command
     * @return true if the variables are correct
     */
    private boolean testNumberVariableVar(String args) {
        String[] arg = args.split(NUMBER_VARIABLE_SEPERATOR);


        if(varNames.contains(arg[0])) return false;

        varNames.add(arg[0]);
        numNames.add(arg[0]);

        return true;
    }

    /**
     * Test the variables of the string variable command
     * @param args The arguments of the string variable command
     * @return true if the variables are correct
     */
    private boolean testStringVariableVar(String args) {
        String[] arg = args.split(NUMBER_STRING_SEPERATOR);


        if(varNames.contains(arg[0])) return false;

        varNames.add(arg[0]);
        strNames.add(arg[0]);

        return true;
    }

    /**
     * Test the variables of the number variable declaration command
     * @param args The arguments of the number variable declaration command
     * @return true if the variables are correct
     */
    private boolean testNumberDecVar(String args) {
        String[] arg   = args.split(NUMBER_DEC_SEPERATOR);
        String numName = arg[0];
        String value   = arg[1];


        if(!varNames.contains(numName))              return false;

        if(!value.contains("*") && !value.contains("/") && !value.contains("-") && !value.contains("+")) {
            if(!isNumber(value) && !isNumVar(value)) return false;
            else return true;
        }

        return isCalculatableVar(value);
    }

    /**
     * Test the variables of the if command
     * @param args The arguments of the if command
     * @return true if the variables are correct
     */
    private boolean testIfVar(String args) {
        String[] toTest    = args.split(IF_ELSE_SEPERATOR);
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

    /**
     * Test the variables of the debug input command
     * @param args The arguments of the debug input command
     * @return true if the variables are correct
     */
    private boolean testIfVarNum(String args) {
        String[] tests     = args.split(IF_NUM_SEPERATOR);
        boolean testResult = true;
        String[] toTest    = tests[0].split("[&]{2} | [|]{2}");


        for (String test : toTest) {
            testResult = testResult && isTestableVar(test);
        }

        return testResult;
    }

    /**
     * Test the variables of the debug input command
     * @param args The arguments of the debug input command
     * @return true if the variables are correct
     */
    private boolean testIfVarStr(String args) {
        args           = args.substring(0, args.indexOf(":"));
        String[] tests;
        if (args.contains("!=")) {
            tests = args.split("!=");
        } else {
            tests = args.split("==");
        }


        if(!strNames.contains(tests[0]) && !tests[0].startsWith("\"") && !tests[0].endsWith("\"")) return false;
        if(!strNames.contains(tests[1]) && !tests[1].startsWith("\"") && !tests[1].endsWith("\"")) return false;

        return true;
    }

    /**
     * Test the variables of the debug input command
     * @param args The arguments of the debug input command
     * @return true if the variables are correct
     */
    private boolean testDebugInputVar(String args) {
        return isValidName(args) && strNames.contains(args) || !isValidName(args);
    }

    /**
     * Test the variables of the set command
     * @param args The arguments of the set command
     * @return true if the variables are correct
     */
    private boolean testLoopVar(String args) {
        return testIfVar(args);
    }

    /**
     * Test the variables of the set command
     * @param args The arguments of the set command
     * @return true if the variables are correct
     */
    private boolean testStrVarDec(String args) {
        String[] strDecArgs = args.split(STR_SEPERATOR);


        if(!isStrVar(strDecArgs[0]))                          return false;
        String[] tokens = strDecArgs[1].split(STR_CONTENT_SEPERATOR);
        for(String token : tokens) {
            if(!isStrVar(token) && !isStr(token)) return false;
        }

        return true;
    }

    /**
     * Test the variables of the set command
     * @param args The arguments of the set command
     * @return true if the variables are correct
     */
    private boolean testActionCallVar(String args) {
        String[] actions    = args.split(ACTION_SEPERATOR);
        String actionName   = actions[0];
        String[] actionArgs = actions[1].split(ACTION_ARGS_SEPERATOR);


        if(!actionNames.contains(actionName)) return false;

        String[] mainActionArgs = this.actionArgs.get(actionName).split(ACTION_ARGS_SEPERATOR);

        if(!actionNames.contains(actionName)) return false;

        for(int i=0; i < actionArgs.length; i++) {
            if(isEmptyArg(actionArgs[i])) continue;

            if(isValidName(actionArgs[i])) {

                if(mainActionArgs[i].charAt(0) == IF_STRING) {
                    if(!strNames.contains(actionArgs[i])) return false;
                } else if (mainActionArgs[i].charAt(0) == IF_NUMBER) {
                    if(!numNames.contains(actionArgs[i])) return false;
                }

            } else {

                if(isNumber(actionArgs[i])) {
                    if(mainActionArgs[i].charAt(0) != IF_NUMBER) return false;
                } else {
                    if(mainActionArgs[i].charAt(0) != IF_STRING) return false;
                }

            }
        }

        return true;
    }

    /**
     * Test the variables of the set command
     * @param args The arguments of the set command
     * @return true if the variables are correct
     */
    private boolean testActionVar(String args) {
        String[] actionArgs = args.split(ACTION_SEPERATOR);


        if(actionNames.contains(actionArgs[0])) return false;

        actionNames.add(actionArgs[0]);

        char type;
        String[] actionArgss = actionArgs[1].split(ACTION_ARGS_SEPERATOR);

        for(String actionArg : actionArgss) {
            type = actionArg.charAt(0);

            if(type == '-') continue;

            actionArg = actionArg.substring(1);

            if(!isArgType(type))        return false;
            if(!isValidName(actionArg)) return false;

            if(type == IF_STRING) {

                if(strNames.contains(actionArg)) return false;

                strNames.add(actionArg);

            } else if (type == IF_NUMBER) {

                if(numNames.contains(actionArg)) return false;

                numNames.add(actionArg);

            }
        }

        this.actionArgs.put(actionArgs[0], actionArgs[1]);

        return true;
    }

    /**
     * Test the variables of the set command
     * @param args The arguments of the set command
     * @return true if the variables are correct
     */
    private boolean testSetVar(String args) {
        String setName = args.substring(0, args.indexOf(SET_NAME_SEPERATOR));

        if(setNames.contains(setName)) return false;

        setNames.add(setName);

        return true;
    }



// -------------------------------------------- Test Functions Blocks ------------------------------------------- //



    /**
     * Test the block of the room command
     * @param args The arguments of the room command
     * @param nextCodeLines The number of lines left in the code
     * @return true if the block is correct
     */
    private boolean testRoomBlock(String args, int nextCodeLines) {
        return getRoomBlockLength(args) <= nextCodeLines;
    }

    /**
     * Test the block of the if command
     * @param args The arguments of the if command
     * @param ifPosition The position of the if command in the code
     * @param endOfRoom The end of the room
     * @return true if the block is correct
     */
    private boolean testIfBlock(String args, int ifPosition, int endOfRoom) {
        String[] toTest = args.split(IF_ELSE_SEPERATOR);
        int blockLenght = 0;

        for(String test : toTest) {
            blockLenght += getIfBlockLength(test);
        }

        return ifPosition + blockLenght + 1 <= endOfRoom;
    }

    /**
     * Test the block of the loop command
     * @param args The arguments of the loop command
     * @param loopPosition The position of the loop command in the code
     * @param endOfRoom The end of the room
     * @return true if the block is correct
     */
    private boolean testLoopBlock(String args, int loopPosition, int endOfRoom) {
        return testIfBlock(args, loopPosition, endOfRoom);
    }

    /**
     * Test the block of the action command
     * @param args The arguments of the action command
     * @param nextCodeLines The number of lines left in the code
     * @return true if the block is correct
     */
    private boolean testActionBlock(String args, int nextCodeLines) {
        return getActionBlockLength(args) <= nextCodeLines;
    }



// ------------------------------------------- Test Help Functions --------------------------------------------- //



    /**
     * Test if the name is valid
     * @param name The name to test
     * @return true if the name is valid
     */
    private boolean isValidName(String name) {
        return name.matches(REGEX_VALIDE_NAME);
    }

    /**
     * Test if the String is a Number
     * @param number String to test
     * @return true if the String is a Number
     */
    private boolean isNumber(String number) {
        return number.matches(REGEX_VALIDE_NUMBER);
    }

    /**
     * Test if the String is a Number Variable
     * @param name String to test
     * @return true if the String is a Number Variable
     */
    private boolean isNumVar(String name) {
        return !isNumber(name) && numNames.contains(name);
    }

    /**
     * Test if the String is a String Variable
     * @param name String to test
     * @return true if the String is a String Variable
     */
    private boolean isStrVar(String name) {
        return !isNumber(name) && strNames.contains(name);
    }

    /**
     * Test if the String is a Calculatable
     * @param value String to test
     * @return true if the String is a Calculatable
     */
    private boolean isCalculatable(String value) {
        return testBreacketsCount(value) && testBreackets(value);
    }

    /**
     * Test if the String is a Calculatable Variable
     * @param value String to test
     * @return true if the String is a Calculatable Variable
     */
    private boolean isCalculatableVar(String value) {
        String[] values = value.split("[\\+\\-\\*/\\(\\)]");
        

        for(String val : values) {
            if(val.equals("")) continue;
            if(!isNumber(val) && !isNumVar(val)) return false;
        }

        return true;
    }

    /**
     * Test if there is an equal amount of brackets
     * @param value String to test
     * @return true if there is an equal amount of brackets
     */
    private boolean testBreacketsCount(String value) {
        int count = 0;


        for(int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '(') count++;
            else if (value.charAt(i) == ')') count--;
        }

        return count == 0;
    }

    /**
     * Test if the brackets are correct and the Content is calculatable
     * @param value String to test
     * @return true if the brackets are correct and the Content is calculatable
     */
    private boolean testBreackets(String value) {
        boolean testResult = true;
        String toTest = "";
        int begin;
        int end;


        if(value.contains("(") && value.contains(")")) {

            while (value.contains("(") && value.contains(")")) {
                begin      = value.lastIndexOf("(");
                end        = value.lastIndexOf(toTest, value.indexOf(")"));
                toTest     = value.substring(begin+1, end);
                value      = value.substring(0, begin) + 1 + value.substring(end+1, value.length());
                testResult = testResult && testBreackets(toTest);
            }

        } 

        if (value.contains("(") || value.contains(")")) {
            return false;
        }

        return value.matches(CALCULATABLE);
    }

    /**
     * Test if the String is a Testable Variable
     * @param test String to test
     * @return true if the String is a Testable Variable
     */
    private boolean isTestableVar(String test) {
        String[] tests     = test.split(IF_ELSE_SEPERATOR);
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

    /**
     * Test if the String is a Testable Number Variable
     * @param test String to test
     * @return true if the String is a Testable Number Variable
     */
    private boolean isTestableVarNum(String test) {
        if(test.contains("=") || test.contains("<") || test.contains(">")) {
            String[] toTest = test.split("[=<>!]");
            toTest          = removeEmpty(toTest);


            if(toTest.length != 2) return false;

            return isCalculatableVar(toTest[0]) && isCalculatableVar(toTest[1]);
        } else {
            return false;
        }
    }

    /**
     * Test if the String is a Testable String Variable
     * @param test String to test
     * @return true if the String is a Testable String Variable
     */
    private boolean isTestableVarStr(String test) {
        String[] arg = test.split("==");


        if(!strNames.contains(arg[0]) && !arg[0].startsWith("\"") && !arg[0].endsWith("\"")) return false;
        if(!strNames.contains(arg[1]) && !arg[0].startsWith("\"") && !arg[0].endsWith("\"")) return false;

        return true;
    }

    /**
     * Get the length of the if block
     * @param args The arguments of the if command
     * @return The length of the if block
     */
    private int getIfBlockLength(String args) {
        return Integer.parseInt(args.split(IF_NUM_SEPERATOR)[1]);
    }

    /**
     * Get the length of the room block
     * @param args The arguments of the room command
     * @return The length of the room block
     */
    private int getRoomBlockLength(String args) {
        return Integer.parseInt(args.split(ROOM_SEPERATOR)[1]);
    }

    /**
     * Remove empty Strings from an Array
     * @param toTest The Array to test
     * @return The Array without empty Strings
     */
    private String[] removeEmpty(String[] toTest) {
        ArrayList<String> list = new ArrayList<String>(toTest.length);


        for(String test : toTest) {
            if(!test.strip().isEmpty()) {
                list.add(test);
            }
        }

        return list.toArray(new String[list.size()]);
    }

    /**
     * Get the length of the action block
     * @param args The arguments of the action command
     * @return The length of the action block
     */
    private int getActionBlockLength(String args) {
        return Integer.parseInt(args.split(ACTION_SEPERATOR)[2]);
    }

    /**
     * Test if the String is a String
     * @param name String to test
     * @return true if the String is a String
     */
    private boolean isStr(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }

    /**
     * Test if the String is an Empty Argument
     * @param name String to test
     * @return true if the String is an Empty Argument
     */
    private boolean isEmptyArg(String name) {
        return name.equals("-");
    }

    /**
     * Test if the String is an Argument Type
     * @param type String to test
     * @return true if the String is an Argument Type
     */
    private boolean isArgType(char type) {
        return type == IF_NUMBER || type == IF_STRING;
    }


}
