package de.ttsa.Logic.Compiler.CompilerSteps;

import java.util.ArrayList;
import java.util.Arrays;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.CodeBlockTests;
import de.ttsa.Enums.CodeSyntaxTests;
import de.ttsa.Enums.CodeVarTests;
import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.CodeBlockTestable;
import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Logic.Features.Set.SetCodeBlock;
import de.ttsa.Logic.Features.Set.SetCodeSyntax;
import de.ttsa.Logic.Features.Set.SetCodeVar;


/**
 * This class is used to test the pre-compiled code
 */
public class CodeTester {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    private ArrayList<ArrayList<String>> fileContent;
    private CodeSyntaxTests codeSyntaxTest = CodeSyntaxTests.NONE;
    private CodeVarTests codeVarTests = CodeVarTests.NONE;
    private CodeBlockTests codeBlockTests = CodeBlockTests.NONE;
    OpCodeVar opCodeVar = new OpCodeVar();



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
               isSet ||
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
        boolean testResult = true;
        boolean isSet      = false;
        String command     = "";
        String args        = "";

        CodeVarTestable test;

        for(int i = 0; i < content.size(); i++) {
            if(content.get(i).strip().equals(CompilerSyntax.BLOCK_END.toString())) {
                if(isSet) isSet = false;
                continue;
            }
            if(isSet) continue;

            command = content.get(i).split(CompilerSyntax.COMMAND.toString())[0];
            args    = content.get(i).substring(content.get(i).indexOf(":") +1).strip();
            
            if(command.equals(content.get(i))) {
                command = content.get(i).split(" ")[0];
                args    = content.get(i).substring(content.get(i).indexOf(" ")).strip();
            }
            
            test = codeVarTests.getTest(command);
            if(test instanceof SetCodeVar) isSet = true;

            testResult &= test.test(args, opCodeVar);
        }

        return testResult;
    }

    private boolean testBlocks(ArrayList<String> content) {
        boolean testResult = true;
        String command     = "";
        String args        = "";
        int setLength      = 0;

        CodeBlockTestable testBlock;


        for(int i = 0; i < content.size(); i++) {
            if(setLength > 0) {
                setLength--;
                continue;
            }

            command = content.get(i).split(CompilerSyntax.COMMAND.toString())[0];
            args    = content.get(i).substring(content.get(i).indexOf(":") +1).strip();
            
            if(command.equals(content.get(i))) {
                command = content.get(i).split(" ")[0];
                args    = content.get(i).substring(content.get(i).indexOf(" ")).strip();
            }

            testBlock   = codeBlockTests.getBlockTest(command);

            if(testBlock instanceof SetCodeBlock) {
                setLength = testBlock.testCode(args, content.subList(i, content.size()));
                testResult &= setLength >= 0;
                continue;
            }

            testResult &= testBlock.testCode(args, content.subList(i, content.size())) >= 0;
        }

        return testResult;
    }
    
}
