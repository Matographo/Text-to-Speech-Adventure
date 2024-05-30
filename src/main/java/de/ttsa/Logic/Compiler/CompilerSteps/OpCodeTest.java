package de.ttsa.Logic.Compiler.CompilerSteps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.OpCodeBlockTests;
import de.ttsa.Frontend.Terminal.CompilerApp;
import de.ttsa.Enums.OpCodeSyntaxTests;
import de.ttsa.Enums.OpCodeVarTests;
import de.ttsa.Interfaces.OpCodeBlockTestable;
import de.ttsa.Interfaces.OpCodeInnerBlockTestable;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Interfaces.OpCodeVarTestable;
import de.ttsa.Tools.Formater;
import de.ttsa.Tools.SimpleLog;

public class OpCodeTest {

    // --------------------------------------------- Attributes
    // -------------------------------------------------- //

    private File file;
    private OpCodeSyntaxTests opCodeSyntaxTest;
    private OpCodeVarTests opCodeVarTests;
    private OpCodeBlockTests opCodeBlockTests;
    private SimpleLog log = CompilerApp.log;
    public static OpCodeVar opCodeVar = new OpCodeVar();

    // ---------------------------------------------- Constructor
    // ----------------------------------------------- //

    /**
     * Constructor
     * 
     * @param fileName The file to test
     */
    public OpCodeTest(String fileName) {
        this.file = new File(fileName);
        opCodeSyntaxTest = OpCodeSyntaxTests.ALWAYS_FALSE;
        opCodeBlockTests = OpCodeBlockTests.NONE;
        opCodeVarTests = OpCodeVarTests.NONE;

        if (!this.file.exists())
            throw new IllegalArgumentException("The file " + fileName + " does not exist.");
    }

    public OpCodeTest() {
        opCodeSyntaxTest = OpCodeSyntaxTests.ALWAYS_FALSE;
        opCodeBlockTests = OpCodeBlockTests.NONE;
        opCodeVarTests = OpCodeVarTests.NONE;
    }

    // ---------------------------------------------- Start
    // -------------------------------------------------- //

    /**
     * Start the test
     * 
     * @return true if the test is successful
     */
    public boolean start() {
        boolean testResult = true;
        long startTime;

        try {
            ArrayList<String> content = getContent();

            startTime = System.currentTimeMillis();
            testResult = testSyntax(content) && testResult;
            log.debug("OpCode Syntax Test took: " + Formater.format(System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            testResult = testVariables(new ArrayList<String>(content)) && testResult;
            log.debug("OpCode Variables Test took: " + Formater.format(System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            testResult = testBlocks(new ArrayList<String>(content)) && testResult;
            log.debug("OpCode Blocks Test took: " + Formater.format(System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            return false;
        }

        return testResult;
    }

    public boolean start(ArrayList<String> content) {
        boolean testResult = true;
        long startTime;

        try {
            startTime = System.currentTimeMillis();
            testResult = testSyntax(content) && testResult;
            log.debug("OpCode Syntax Test took: " + Formater.format(System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            testResult = testVariables(new ArrayList<String>(content)) && testResult;
            log.debug("OpCode Variables Test took: " + Formater.format(System.currentTimeMillis() - startTime));

            startTime = System.currentTimeMillis();
            testResult = testBlocks(new ArrayList<String>(content)) && testResult;
            log.debug("OpCode Blocks Test took: " + Formater.format(System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            return false;
        }

        return testResult;
    }

    public static boolean test(ArrayList<String> content) {
        boolean testResult = true;
        long startTime;
        OpCodeTest test = new OpCodeTest();
        SimpleLog log = CompilerApp.log;

        startTime = System.currentTimeMillis();
        testResult = test.testSyntax(content) && testResult;
        log.debug("OpCode Syntax Test took: " + Formater.format(System.currentTimeMillis() - startTime));
        
        startTime = System.currentTimeMillis();
        testResult = test.testVariables(new ArrayList<String>(content)) && testResult;
        log.debug("OpCode Variables Test took: " + Formater.format(System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        testResult = test.testBlocks(new ArrayList<String>(content)) && testResult;
        log.debug("OpCode Blocks Test took: " + Formater.format(System.currentTimeMillis() - startTime));

        return testResult;
    }

    public static boolean test(String line) {
        ArrayList<String> content = new ArrayList<String>();
        content.add(line);
        return new OpCodeTest().testSyntax(content);
    }

    // ------------------------------------------- Load Data
    // ---------------------------------------------- //

    /**
     * Load the content of the file
     * 
     * @return The content of the file
     * @throws IOException
     */
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

    // ---------------------------------------- Test All Syntax
    // -------------------------------------------- //

    /**
     * Test the syntax of every line
     * 
     * @param content The lines to Test
     * @return true if the syntax is correct
     */
    private boolean testSyntax(ArrayList<String> content) {
        boolean testResult = true;
        String command = "";
        String args = "";
        OpCodeSyntaxTestable test;

        for (String line : content) {
            command = line.substring(0, 2);
            args = line.substring(2).strip();
            test = opCodeSyntaxTest.getTest(command);

            testResult &= test.testOpCode(args);
        }

        return testResult;
    }

    // --------------------------------------------- Test All Variables
    // ----------------------------------------- //

    /**
     * Test the variables of every line to make sure they dont use undeclared
     * variables
     * or use variables that are not allowed or not double declared
     * 
     * @param content The lines to test
     * @return true if the variables are correct declared and used
     */
    private boolean testVariables(ArrayList<String> content) {
        boolean testResult = true;
        String command = "";
        String args = "";

        OpCodeVar opCodeVar = OpCodeTest.opCodeVar;
        OpCodeVarTestable test;

        for (int i = 0; i < content.size(); i++) {
            command = content.get(i).substring(0, 2);
            args = content.get(i).substring(2);
            test = opCodeVarTests.getTest(command);

            testResult &= test.test(args, opCodeVar);
        }

        return testResult;
    }

    // -------------------------------------------- Test All Blocks
    // -------------------------------------------- //

    /**
     * Test the blocks of the code if the block is correct and not to long
     * 
     * @param content The lines to test
     * @return true if the blocks are correct
     */
    private boolean testBlocks(ArrayList<String> content) {
        boolean testResult = true;
        String command = "";
        String args = "";
        int lastStrucLenght = -1;

        OpCodeInnerBlockTestable testInnerBlock;
        OpCodeBlockTestable testBlock;

        for (int i = 0; i < content.size(); i++) {
            command = content.get(i).substring(0, 2);
            args = content.get(i).substring(2);

            testInnerBlock = opCodeBlockTests.getInnerBlockTest(command);
            testBlock = opCodeBlockTests.getBlockTest(command);

            if (testInnerBlock != null) {
                testResult = testResult && testInnerBlock.test(args, i, i + lastStrucLenght);
            } else if (testBlock != null) {
                testResult = testResult
                        && (lastStrucLenght = testBlock.testOpCode(args, content.subList(i, content.size()))) >= 0;
            }
        }

        return testResult;
    }
}
