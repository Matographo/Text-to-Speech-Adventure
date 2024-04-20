package de.ttsa.Logic.Compiler.OpCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Enums.OpCodeBlockTests;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Enums.OpCodeSyntaxTests;
import de.ttsa.Logic.Enums.OpCodeVarTests;
import de.ttsa.Logic.Features.Action.ActionOpCodeBlock;
import de.ttsa.Logic.Features.Action.ActionOpCodeVar;
import de.ttsa.Logic.Features.ActionCall.ActionCallOpCodeVar;
import de.ttsa.Logic.Features.DebugInput.DebugInput;
import de.ttsa.Logic.Features.DebugInput.DebugInputOpCodeVar;
import de.ttsa.Logic.Features.If.IfOpCodeVar;
import de.ttsa.Logic.Features.Loop.LoopOpCodeVar;
import de.ttsa.Logic.Features.NumDec.NumDecOpCodeVar;
import de.ttsa.Logic.Features.NumInit.NumInitOpCodeVar;
import de.ttsa.Logic.Features.Printer.PrinterOpCodeVar;
import de.ttsa.Logic.Features.Room.RoomOpCodeBlock;
import de.ttsa.Logic.Features.Room.RoomOpCodeVar;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperOpCodeVar;
import de.ttsa.Logic.Features.Set.SetOpCodeVar;
import de.ttsa.Logic.Features.StrDec.StrDecOpCodeVar;
import de.ttsa.Logic.Features.StrInit.StrInitOpCodeVar;
import de.ttsa.Logic.Interfaces.OpCodeBlockTestable;
import de.ttsa.Logic.Interfaces.OpCodeInnerBlockTestable;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class OpCodeTest extends OpCode{



// --------------------------------------------- Attributes -------------------------------------------------- //



    private File file;
    private OpCodeSyntaxTests opCodeSyntaxTest = OpCodeSyntaxTests.ALWAYS_FALSE;
    private OpCodeVarTests opCodeVarTests = OpCodeVarTests.NONE;
    private OpCodeBlockTests opCodeBlockTests = OpCodeBlockTests.NONE;
    private OpCodeIndex opCodeIndex = OpCodeIndex.NONE;
    private OpCodeIfTypes ifTypes = OpCodeIfTypes.NONE;



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
        OpCodeSyntaxTestable test;


        for(String line : content) {
            command = line.split(OpCodeSeperators.COMMAND.getSeperator())[0];
            args    = line.substring(line.indexOf(OpCodeSeperators.COMMAND.getSeperator()) + command.length()).strip();
            test    = opCodeSyntaxTest.getTest(command);

            testResult &= test.testOpCode(args);
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

        OpCodeVar opCodeVar = new OpCodeVar();
        OpCodeVarTestable test;

        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(OpCodeSeperators.COMMAND.getSeperator())[0];
            args    = content.get(i).substring(content.get(i).indexOf(OpCodeSeperators.COMMAND.getSeperator()) + command.length()).strip();
            test    = opCodeVarTests.getTest(command);

            testResult &= test.test(args, opCodeVar);
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
        int lastStrucLenght = -1;

        OpCodeInnerBlockTestable testInnerBlock;
        OpCodeBlockTestable testBlock;


        for(int i = 0; i < content.size(); i++) {
            command = content.get(i).split(OpCodeSeperators.COMMAND.getSeperator())[0];
            args    = content.get(i).substring(content.get(i).indexOf(OpCodeSeperators.COMMAND.getSeperator()) + command.length()).strip();

            testInnerBlock = opCodeBlockTests.getInnerBlockTest(command);
            testBlock      = opCodeBlockTests.getBlockTest(command);

            if(testInnerBlock == null && testBlock == null) {
                continue;
            }

            if(testInnerBlock != null) {
                testResult = testResult && testInnerBlock.test(args, i, i + lastStrucLenght);
            } else {
                testResult = testResult && (lastStrucLenght = testBlock.testOpCode(args, content.subList(i, content.size()))) >= 0;
            }

            /*
            switch(opCodeIndex.convert(command)) {
                case ROOM:
                    testResult = testResult && (lastStrucLenght = new RoomOpCodeBlock().testOpCode(args, content.subList(i, content.size()))) >= 0;
                    break;
                case IF:
                    testResult = testResult && testIfBlock(args, i, i + lastStrucLenght);
                    break;
                case LOOP:
                    testResult = testResult && testLoopBlock(args, i, i + lastStrucLenght);
                    break;
                case ACTION:
                    testResult = testResult && (lastStrucLenght = new ActionOpCodeBlock().testOpCode(args, content.subList(i, content.size()))) >= 0;
                    break;
                default:
                    continue;
            }*/
        }

        return testResult;
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
        String[] toTest = args.split(OpCodeSeperators.IF_ELSE.getSeperator());
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
        String[] tests     = test.split(OpCodeSeperators.IF_ELSE.getSeperator());
        OpCodeIfTypes type;
        boolean testResult = true;


        for(String toTest : tests) {
            type = OpCodeIfTypes.convert(toTest.charAt(0));

            switch(type) {
                case NUMBER -> testResult = testResult && isTestableVarNum(toTest.substring(1));
                case STRING -> testResult = testResult && isTestableVarStr(toTest.substring(1));
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
        return Integer.parseInt(args.split(OpCodeSeperators.IF_NUM.getSeperator())[1]);
    }

    /**
     * Get the length of the room block
     * @param args The arguments of the room command
     * @return The length of the room block
     */
    private int getRoomBlockLength(String args) {
        return Integer.parseInt(args.split(OpCodeSeperators.ROOM.getSeperator())[1]);
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
        return Integer.parseInt(args.split(OpCodeSeperators.ACTION.getSeperator())[2]);
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


}
