package de.ttsa.Logic.Features.If;

import java.util.ArrayList;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.IfTypes;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class IfOpCodeVar implements OpCodeVarTestable {

    private OpCodeVar opCodeVar;

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        this.opCodeVar = opCodeVar;
        String[] args    = toTest.split(Seperators.IF_ELSE.getSeperator());
        boolean testResult = true;
        char i;


        for(String test : args) {
            i = test.charAt(0);

            switch(IfTypes.convert(i)) {
                case NUMBER -> testResult = testResult && testIfVarNum(test.substring(1));
                case STRING -> testResult = testResult && testIfVarStr(test.substring(1));
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
        String[] tests     = args.split(Seperators.IF_NUM.getSeperator());
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


        if(!opCodeVar.isStrName(tests[0]) && !tests[0].startsWith("\"") && !tests[0].endsWith("\"")) return false;
        if(!opCodeVar.isStrName(tests[1]) && !tests[1].startsWith("\"") && !tests[1].endsWith("\"")) return false;

        return true;
    }

    /**
     * Test if the String is a Testable Variable
     * @param test String to test
     * @return true if the String is a Testable Variable
     */
    private boolean isTestableVar(String test) {
        String[] tests     = test.split(Seperators.IF_ELSE.getSeperator());
        IfTypes type;
        boolean testResult = true;


        for(String toTest : tests) {
            type = IfTypes.convert(toTest.charAt(0));

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


        if(!opCodeVar.isStrName(arg[0]) && !arg[0].startsWith("\"") && !arg[0].endsWith("\"")) return false;
        if(!opCodeVar.isStrName(arg[1]) && !arg[0].startsWith("\"") && !arg[0].endsWith("\"")) return false;

        return true;
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
     * Test if the String is a Number
     * @param number String to test
     * @return true if the String is a Number
     */
    private boolean isNumber(String number) {
        return number.matches(Regex.VALIDE_NUMBER.toString());
    }
    
    /**
     * Test if the String is a Number Variable
     * @param name String to test
     * @return true if the String is a Number Variable
     */
    private boolean isNumVar(String name) {
        return !isNumber(name) && opCodeVar.isNumName(name);
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
}
