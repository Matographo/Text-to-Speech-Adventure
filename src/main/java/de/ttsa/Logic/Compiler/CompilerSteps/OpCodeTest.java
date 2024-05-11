package de.ttsa.Logic.Compiler.CompilerSteps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.OpCodeBlockTests;
import de.ttsa.Enums.Seperators;
import de.ttsa.Enums.OpCodeSyntaxTests;
import de.ttsa.Enums.OpCodeVarTests;
import de.ttsa.Interfaces.OpCodeBlockTestable;
import de.ttsa.Interfaces.OpCodeInnerBlockTestable;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class OpCodeTest {



// --------------------------------------------- Attributes -------------------------------------------------- //



    private File file;
    private OpCodeSyntaxTests opCodeSyntaxTest;
    private OpCodeVarTests    opCodeVarTests;
    private OpCodeBlockTests  opCodeBlockTests;



// ---------------------------------------------- Constructor ----------------------------------------------- //



    /**
     * Constructor
     * @param fileName The file to test
     */
    public OpCodeTest(String fileName) {
        this.file = new File(fileName);
        opCodeSyntaxTest = OpCodeSyntaxTests.ALWAYS_FALSE;
        opCodeBlockTests = OpCodeBlockTests.NONE;
        opCodeVarTests   = OpCodeVarTests.NONE;


        if(!this.file.exists()) throw new IllegalArgumentException("The file " + fileName + " does not exist.");
    }

    public OpCodeTest() {
        opCodeSyntaxTest = OpCodeSyntaxTests.ALWAYS_FALSE;
        opCodeBlockTests = OpCodeBlockTests.NONE;
        opCodeVarTests   = OpCodeVarTests.NONE;
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
            command = line.split(Seperators.COMMAND.getSeperator())[0];
            args    = line.substring(line.indexOf(Seperators.COMMAND.getSeperator()) + command.length()).strip();
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
            command = content.get(i).split(Seperators.COMMAND.getSeperator())[0];
            args    = content.get(i).substring(content.get(i).indexOf(Seperators.COMMAND.getSeperator()) + command.length()).strip();
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
            command = content.get(i).split(Seperators.COMMAND.getSeperator())[0];
            args    = content.get(i).substring(content.get(i).indexOf(Seperators.COMMAND.getSeperator()) + command.length()).strip();

            testInnerBlock = opCodeBlockTests.getInnerBlockTest(command);
            testBlock      = opCodeBlockTests.getBlockTest(command);

            if(testInnerBlock != null) {
                testResult = testResult && testInnerBlock.test(args, i, i + lastStrucLenght);
            } else if(testBlock != null){
                testResult = testResult && (lastStrucLenght = testBlock.testOpCode(args, content.subList(i, content.size()))) >= 0;
            }
        }

        return testResult;
    }
}
