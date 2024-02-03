package de.ttsa.ConsoleGame.Player;

import java.util.ArrayList;
import java.util.HashSet;

import de.ttsa.ConsoleGame.ConsoleLoadingSyntax;
import de.ttsa.ConsoleGame.Player.Datatypes.*;
import de.ttsa.ConsoleGame.Player.Scriptables.*;
import de.ttsa.ConsoleGame.Player.Structures.*;

class GameScriptBuilder extends ConsoleLoadingSyntax{



// ---------------------- Attributes ----------------------



    private ArrayList<String> game;

    private Input input = new Input();



// --------------------- Constructors ---------------------



    public GameScriptBuilder(ArrayList<String> gameContent) {
        game = gameContent;
    }



// ----------------------- Loading ----------------------------



    public Scriptable load() {
        return loadGame(game);
    }


    public Scriptable loadGame(ArrayList<String> game) {
        String opCode = "";
        String args   = "";
        String line   = "";

        ArrayList<Scriptable> gameScript = new ArrayList<Scriptable>();
        ArrayList<String> blockContent;


        for(int i = 0; i < game.size(); i++) {
            line   = game.get(i);
            opCode = line.split(COMMAND_SEPERATOR)[0];
            args   = line.substring(line.indexOf(COMMAND_SEPERATOR) + opCode.length()).strip();

            switch(opCode) {
                case INDEX_SAY:

                    gameScript.add(say(args));
                    break;

                case INDEX_ROOM:

                    int roomSize = getRoomSize(args);
                    blockContent = new ArrayList<String>(roomSize);
                    game.set(i, args);


                    for(int j = 0; j <= roomSize; j++) {
                        blockContent.add(game.get(i));
                        game.remove(i);
                    }

                    room(blockContent);
                    i--;
                    break;

                case INDEX_ROOM_JUMPER:

                    gameScript.add(new RoomJumper(args));
                    break;

                case INDEX_NUMBER_VARIABLE:

                    numVars(args);
                    break;

                case INDEX_STRING_VARIABLE:

                    strVars(args);
                    break;

                case INDEX_NUM_VARDEC:

                    gameScript.add(varDec(args));
                    break;

                case INDEX_IF:

                    int ifSize = getIfSize(args);
                    blockContent = new ArrayList<String>(ifSize);
                    game.set(i, args);


                    for(int j = 0; j <= ifSize; j++) {
                        blockContent.add(game.get(i));
                        game.remove(i);
                    }

                    gameScript.add(ifCalc(blockContent));
                    i--;
                    break;

                case INDEX_INPUT:

                    gameScript.add(input);
                    break;

                case INDEX_STR_VARDEC:

                    gameScript.add(strDec(args));
                    break;

                case INDEX_DEBUG:

                    gameScript.add(new DebugInput(args));
                    break;

                case INDEX_SAVE:

                    gameScript.add(new GameSavingScript());
                    break;

                case INDEX_LOAD:

                    gameScript.add(new GameLoaderScript());
                    break;

                case INDEX_EXIT:

                    gameScript.add(new GameExitScript(args));
                    break;

                case INDEX_LOOP:

                    int loopSize = getLoopSize(args);
                    blockContent = new ArrayList<String>(loopSize);
                    game.set(i, args);


                    for(int j = 0; j <= loopSize; j++) {
                        blockContent.add(game.get(i));
                        game.remove(i);
                    }

                    gameScript.add(loop(blockContent));
                    i--;
                    break;

                case INDEX_LOOP_BREAKER:

                    gameScript.add(new LoopBreaker());
                    break;

                case INDEX_SET:

                    set(args);
                    break;

                case INDEX_ACTION:

                    int actionSize = getActionSize(args);
                    blockContent = new ArrayList<String>(actionSize);
                    game.set(i, args);


                    for(int j = 0; j <= actionSize; j++) {
                        blockContent.add(game.get(i));
                        game.remove(i);
                    }

                    action(blockContent);
                    i--;
                    break;

                case INDEX_ACTION_CALL:

                    gameScript.add(actionCall(args));
                    break;

                default:
                    throw new RuntimeException("OpCode " + opCode + " is not valid!");
            }
        }

        return new Script(gameScript);
    }



// ------------------ Command Functions -------------------



    private Scriptable say(String args) {
        String[] sayArgs          = args.split(SAY_SEPERATOR);
        Printablable[] printables = new Printablable[sayArgs.length];
        String arg                = "";


        for(int i = 0; i < sayArgs.length; i++) {
            arg = sayArgs[i];

            if(arg.startsWith("\"") && arg.endsWith("\"")) {
                printables[i] = new PrintText(arg.substring(1, arg.length() - 1));
            } else if (isValidName(arg)) {

                if(GameManager.numVars.containsKey(arg)) {
                    printables[i] = GameManager.numVars.get(arg);
                } else if (GameManager.strVars.containsKey(arg)) {
                    printables[i] = GameManager.strVars.get(arg);
                } else {
                    throw new RuntimeException("Say argument " + arg + " is not valid!");
                }

            } else {
                throw new RuntimeException("Say argument " + arg + " is not valid!");
            }
        }

        return new Printer(printables);
    }


    private void room(ArrayList<String> roomContent) {
        String[] roomArgs = roomContent.get(0).split(ROOM_SEPERATOR);
        String roomName   = roomArgs[0];


        roomContent.remove(0);

        Scriptable roomScript = loadGame(roomContent);
        GameManager.rooms.put(roomName, new Room(roomScript));
    }


    private void numVars(String args) {
        String[] numVarArgs = args.split(NUMBER_VARIABLE_SEPERATOR);
        String numVarName   = numVarArgs[0];


        if(!isValidName(numVarName)) {
            throw new RuntimeException("NumVar name " + numVarName + " is not valid!");
        }

        int numVarValue = Integer.parseInt(numVarArgs[1]);
        GameManager.numVars.put(numVarName, new INT(numVarValue));
    }


    private void strVars(String args) {
        String[] strVarArgs = args.split(NUMBER_STRING_SEPERATOR);
        String strVarName   = strVarArgs[0];


        if(!isValidName(strVarName)) {
            throw new RuntimeException("StrVar name " + strVarName + " is not valid!");
        }

        String strVarValue = strVarArgs[1];
        GameManager.strVars.put(strVarName, new STRING(strVarValue));
    }


    private Scriptable varDec(String args) {
        String[] varDecArgs = args.split(NUMBER_DEC_SEPERATOR);
        String varDecName   = varDecArgs[0];


        if(!isValidName(varDecName)) {
            throw new RuntimeException("VarDec name " + varDecName + " is not valid!");
        }

        String varDecValue = varDecArgs[1];
        return new VarDec(varDecName, varDecValue);
    }


    private Scriptable ifCalc(ArrayList<String> ifContent) {
        String ifBlockArg = ifContent.get(0);


        ifContent.remove(0);

        String[] ifArgs      = ifBlockArg.split(IF_ELSE_SEPERATOR);
        Scriptable[] scripts = new Scriptable[ifArgs.length];

        ArrayList<String> code;


        for(int i=0; i < ifArgs.length; i++) {
            String con = ifArgs[i].substring(0, ifArgs[i].lastIndexOf(":"));
            int length = Integer.parseInt(ifArgs[i].substring(ifArgs[i].lastIndexOf(":") + 1));
            code       = new ArrayList<>(length);


            for(int j=0; j < length; j++) {
                code.add(ifContent.get(0));
                ifContent.remove(0);
            }

            if(i == ifArgs.length - 1 && con.strip().isEmpty()) {
                ifArgs[i]  = con;
                scripts[i] = loadGame(code);
                break;
            }

            ifArgs[i]  = con;
            scripts[i] = loadGame(code);
        }

        return new If(ifArgs, scripts);
    }


    private Scriptable strDec(String args) {
        String[] strDecArgs = args.split(STR_SEPERATOR);
        String strDecName   = strDecArgs[0];


        if(!isValidName(strDecName)) {
            throw new RuntimeException("StrDec name " + strDecName + " is not valid!");
        }

        String operation = strDecArgs[1];
        return new StrDec(strDecName, operation);
    }


    private Scriptable loop(ArrayList<String> args) {
        String loopArg         = args.get(0);
        ArrayList<String> code = new ArrayList<String>();
        char conditionType;


        args.remove(0);

        String[] loopArgs = loopArg.split(":");
        String condition  = loopArgs[0];


        if(isNumber(condition)) conditionType           = 'i';
        else if(condition.equals("true")) conditionType = 't';
        else conditionType                              = 'c';

        for(String codeLine : args) {
            code.add(codeLine);
        }

        Scriptable script = loadGame(code);
        return new Loop(condition, conditionType, script);
    }


    private void set(String args) {
        String[] setArgs      = args.split(SET_NAME_SEPERATOR);
        String setName        = setArgs[0];
        String[] setVariables = setArgs[1].split(SET_SEPERATOR);


        if(!isValidName(setName)) {
            throw new RuntimeException("Set name " + setName + " is not valid!");
        }

        HashSet<String> strValues = new HashSet<>();
        HashSet<String> varValues = new HashSet<>();


        for(String value : setVariables) {

            if(value.startsWith("\"") && value.endsWith("\"")) {
                strValues.add(value.substring(1, value.length() - 1));
            } else {
                varValues.add(value);
            }

        }

        GameManager.sets.put(setName, new Set(strValues, varValues));
    }


    private void action(ArrayList<String> actionContent) {
        String[] actionArgs   = actionContent.get(0).split(ACTION_SEPERATOR);
        String actionName     = actionArgs[0];
        String[] actionParams = actionArgs[1].split(ACTION_ARGS_SEPERATOR);


        actionContent.remove(0);

        Scriptable actionScript = loadGame(actionContent);
        GameManager.actions.put(actionName, new Action(actionScript, actionParams));
    }


    private Scriptable actionCall(String args) {
        String[] actionCallArgs = args.split(ACTION_SEPERATOR);
        String actionName       = actionCallArgs[0];
        String[] actionParams   = actionCallArgs[1].split(ACTION_ARGS_SEPERATOR);


        return new ActionCall(actionName, actionParams);
    }



// ------------------ Helper Functions -------------------
    
    private int getRoomSize(String args) {
        String[] roomArgs = args.split(ROOM_SEPERATOR);


        return Integer.parseInt(roomArgs[1]);
    }


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


    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private int getIfSize(String args) {
        String[] lengthS = args.split(IF_ELSE_SEPERATOR);
        int length       = 0;


        for(String l : lengthS) {
            length += Integer.parseInt(l.substring(l.lastIndexOf(":") + 1));
        }

        return length;
    }


    private int getLoopSize(String args) {
        String[] loopArgs = args.split(":");


        return Integer.parseInt(loopArgs[1]);
    }


    private int getActionSize(String args) {
        String[] actionArgs = args.split(":");

        
        return Integer.parseInt(actionArgs[2]);
    }



}
