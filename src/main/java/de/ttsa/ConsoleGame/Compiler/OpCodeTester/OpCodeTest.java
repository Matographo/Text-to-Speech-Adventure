package de.ttsa.ConsoleGame.Compiler.OpCodeTester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.ConsoleGame.OpCode;

public class OpCodeTest extends OpCode{



// ---------------------- Attributes -----------------------



    private File file;

    private final String CALCULATABLE = "^(([-]?([0-9]))*|([-]?([a-zA-Z]+[a-zA-Z0-9])))*(?:[-+*/][-]?[a-zA-Z0-9]+)*$";



// ------------------ Variables Memory --------------------



    private HashSet<String> roomNames   = new HashSet<String>();
    private HashSet<String> varNames    = new HashSet<String>();
    private HashSet<String> numNames    = new HashSet<String>();
    private HashSet<String> strNames    = new HashSet<String>();
    private HashSet<String> actionNames = new HashSet<String>();
    private HashSet<String> setNames    = new HashSet<String>();

    private HashMap<String, String> actionArgs = new HashMap<>();



// -------------------- Constructor -----------------------



    public OpCodeTest(String fileName) {
        this.file = new File(fileName);


        if(!this.file.exists()) throw new IllegalArgumentException("The file " + fileName + " does not exist.");
    }



// ----------------------- Start --------------------------



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



// -------------------- Load Data ------------------------



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



// ----------------- Test All Syntax ---------------------



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
                default -> testResult = false;
            }
        }

        return testResult;
    }



// ----------------- Test All Variables ----------------------



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



// ------------------ Test All Blocks -----------------------



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



// ------------------ Test Functions Syntax ----------------------



    private boolean testSaySyntax(String args) {
        return args.matches(REGEX_SAY);
    }


    private boolean testRoomSyntax(String args) {
        return args.matches(REGEX_ROOM);
    }


    private boolean testRoomJumperSyntax(String args) {
        if(!isValidName(args)) return false;

        return true;
    }


    private boolean testNumberVariableSyntax(String args) {
        return args.matches(REGEX_NUMBER_VARIABLE);
    }


    private boolean testStringVariableSyntax(String args) {
        return args.matches(REGEX_STRING_VARIABLE);
    }


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
            case IF_INPUT ->  testResult = testIfSyntaxIn(args.substring(1));
            default ->        testResult = false;
        }

        return testResult;
    }


    private boolean testIfSyntaxNum(String args) {
        String[] toTest    = args.split(IF_NUM_SEPERATOR);
        boolean testResult = true;


        if(toTest.length != 2)   return false;
        if(!isNumber(toTest[1])) return false;

        String[] toTestBig = toTest[0].split("[&]{2} | [|]{2}");

        for (String test : toTestBig) {
            testResult = testResult && isTestable(test);
        }

        return testResult;
    }


    private boolean testIfSyntaxStr(String args) {
        args = args.substring(0, args.indexOf(":"));
        // if(!args.contains("=="))                           return false;
        // if(!args.contains(":"))                            return false;
        // if(!isNumber(args.substring(args.indexOf(":")+1))) return false;

        // args         = args.substring(0, args.indexOf(":"));
        // String[] arg = args.split("==");

        // if(arg.length != 2) return false;
        // if(!isValidName(arg[0]) && !(arg[0].startsWith("\"") && arg[0].endsWith("\""))) return false;
        // if(!isValidName(arg[1]) && !(arg[1].startsWith("\"") && arg[1].endsWith("\""))) return false;

        // return true; 
        return args.matches(REGEX_IF_STRING);
    }


    private boolean testIfSyntaxIn(String args) {
        args = args.substring(0, args.indexOf(":"));
        return args.matches(REGEX_IF_INPUT);
    }


    private boolean testInputSyntax(String args) {
        if(!args.strip().isEmpty()) return false;

        return true;
    }


    private boolean testStrDecSyntax(String args) {
        String[] strDecArgs = args.split(STR_SEPERATOR);


        if(strDecArgs.length != 2)   return false;

        String strDecName = strDecArgs[0];

        if(!isValidName(strDecName)) return false;

        String operation  = strDecArgs[1];

        if(!operation.startsWith("\"") && !operation.endsWith("\"") && !isValidName(operation)) return false;

        return true;
    }


    private boolean testDebugInputSyntax(String args) {
        if(args.strip().isEmpty())                                               return false;
        if(!isValidName(args) && !args.startsWith("\"") && !args.endsWith("\"")) return false;

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


    private boolean testExitSyntax(String args) {
        if(!args.equals("0") && !args.equals("1")) return false;

        return true;
    }


    private boolean testLoopSyntax(String args) {
        String argsTyp2 = args.substring(0, args.indexOf(IF_NUM_SEPERATOR));


        return testIfSyntaxSwitch(args) || isNumber(argsTyp2) || isValidName(argsTyp2) || argsTyp2.equals("true");
    }


    private boolean testLoopBreakerSyntax(String args) {
        if(!args.strip().isEmpty()) return false;

        return true;
    }


    private boolean testSetSyntax(String args) {
        String setName = args.substring(0, args.indexOf(SET_NAME_SEPERATOR));


        if(!isValidName(setName)) return false;

        args         = args.substring(args.indexOf(SET_NAME_SEPERATOR) + SET_NAME_SEPERATOR.length());
        String[] arg = args.split(SET_SEPERATOR);

        for(String set : arg) {
            set = set.substring(1, set.length()-1);

            if(!isValideSetContent(set)) return false;
        }

        return true;
    }


    private boolean testActionSyntax(String arg) {
        String[] args = arg.split(ACTION_SEPERATOR);
        char type;


        if(args.length != 3)            return false;

        String actionName   = args[0];
        String[] actionArgs = args[1].split(ACTION_ARGS_SEPERATOR);
        String codeLines    = args[2];

        if(!isValidName(actionName))    return false;

        for(String actionArg : actionArgs) {
            if(isEmptyArg(actionArg)) continue;

            type      = actionArg.charAt(0);
            actionArg = actionArg.substring(1);

            if(!isArgType(type))        return false;
            if(!isValidName(actionArg)) return false;
        }

        if(!isNumber(codeLines))        return false;

        return true;
    }


    private boolean testActionCallSyntax(String arg) {
        String[] args     = arg.split(ACTION_SEPERATOR);
        String actionName = args[0];
        String actionArgs = args[1];


        if(!isValidName(actionName))  return false;
        if(!isActionArgs(actionArgs)) return false;

        return true;
    }



// ------------------ Test Functions Variables -------------------



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


    private boolean testIfVarNum(String args) {
        String[] tests     = args.split(IF_NUM_SEPERATOR);
        boolean testResult = true;
        String[] toTest    = tests[0].split("[&]{2} | [|]{2}");


        for (String test : toTest) {
            testResult = testResult && isTestableVar(test);
        }

        return testResult;
    }


    private boolean testIfVarStr(String args) {
        args           = args.substring(0, args.indexOf(":"));
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


    private boolean testLoopVar(String args) {
        return testIfVar(args);
    }


    private boolean testStrVarDec(String args) {
        String[] strDecArgs = args.split(STR_SEPERATOR);


        if(!isStrVar(strDecArgs[0]))                          return false;
        if(!isStrVar(strDecArgs[1]) && !isStr(strDecArgs[1])) return false;

        strNames.add(strDecArgs[0]);

        return true;
    }


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


    private boolean testSetVar(String args) {
        String setName = args.substring(0, args.indexOf(SET_NAME_SEPERATOR));

        if(setNames.contains(setName)) return false;

        setNames.add(setName);

        return true;
    }



// ----------------------- Test Functions Blocks ---------------------------



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


    private boolean testLoopBlock(String args, int loopPosition, int endOfRoom) {
        return testIfBlock(args, loopPosition, endOfRoom);
    }


    private boolean testActionBlock(String args, int nextCodeLines) {
        if(getActionBlockLength(args) <= nextCodeLines) return true;

        return false;
    }



// ------------------------- Test Help Functions ------------------------------



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


    private boolean isValideSetContent(String args) {
        if (args.contains(" ")) {
            return false;
        } else if (!args.matches("^[a-zA-Z]+$")) {
            return false;
        }

        return true;
    }


    private int getActionBlockLength(String args) {
        return Integer.parseInt(args.split(ACTION_SEPERATOR)[2]);
    }


    private boolean isStr(String name) {
        if(name.startsWith("\"") && name.endsWith("\"")) return true;

        return false;
    }


    private boolean isEmptyArg(String name) {
        if(name.equals("-")) return true;

        return false;
    }


    private boolean isArgType(char type) {
        if(type == IF_NUMBER || type == IF_STRING) return true;

        return false;
    }


    private boolean isActionArgs(String args) {
        String[] actionArgs = args.split(ACTION_ARGS_SEPERATOR);


        for(String actionArg : actionArgs) {
            if(isEmptyArg(actionArg)) continue;
            if(!isValidName(actionArg) && !isNumber(actionArg) && !isStr(actionArg)) return false;
        }

        return true;
    }

}
