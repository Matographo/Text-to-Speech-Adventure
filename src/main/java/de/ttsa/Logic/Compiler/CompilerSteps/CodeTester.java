package de.ttsa.Logic.Compiler.CompilerSteps;

import java.util.ArrayList;

import de.ttsa.Enums.CodeSyntaxTests;
import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Logic.Features.Set.SetCodeSyntax;


/**
 * This class is used to test the pre-compiled code
 */
public class CodeTester {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    ArrayList<ArrayList<String>> fileContent;
    CodeSyntaxTests codeSyntaxTest = CodeSyntaxTests.NONE;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    public CodeTester(ArrayList<ArrayList<String>> fileContent) {
        this.fileContent = fileContent;
    }



// ----------------------------------------------- Methods ---------------------------------------------------- //



    public boolean test() {
        for (ArrayList<String> file : fileContent) {
            if (!startTest(file)) return false;
        }
        return true;
    }

    private boolean startTest(ArrayList<String> file) {
        boolean testResult = true;


        try {
            testResult = testSyntax(new ArrayList<String>(file))    && testResult;
            testResult = testVariables(new ArrayList<String>(file)) && testResult;
            testResult = testBlocks(new ArrayList<String>(file))    && testResult;

        } catch(Exception e) {
            return false;
        }

        return testResult;
    }

    private boolean testSyntax(ArrayList<String> content) {
        boolean testResult = true;
        String command     = "";
        String args        = "";
        boolean isSet      = false;
        CodeSyntaxTestable test;


        for(String line : content) {
            if(line.strip().equals(CompilerSyntax.BLOCK_END.toString()) && isSet) isSet = false;

            if(line.startsWith(CompilerSyntax.COMMENT.toString()) ||
               line.strip().isEmpty() ||
               line.strip().equals(CompilerSyntax.BLOCK_END.toString())) continue;
               
            command = line.split(Seperators.CODE_COMMAND.getSeperator())[0];
            args    = line.substring(line.indexOf(Seperators.CODE_COMMAND.getSeperator()) + 1).strip();

            if(command.equals(line) && line.contains(" ")) {
                command = line.substring(0, line.indexOf(" "));
                args    = line.substring(line.indexOf(" ")+1).strip();
            }
            
            test = codeSyntaxTest.getTest(command);

            if(isSet) {
                testResult &= command.matches(Regex.SET_CONTENT.toString());
                continue;
            }

            if(test instanceof SetCodeSyntax) isSet = true;

            testResult &= test.testCode(args);
        }

        return testResult;
    }

    private boolean testVariables(ArrayList<String> content) {
        return true;
    }

    private boolean testBlocks(ArrayList<String> content) {
        return true;
    }
    
}
