package de.ttsa.Logic.Player.PlayerLogic;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.Printablable;
import de.ttsa.Interfaces.Scriptable;
import de.ttsa.Logic.PlayerApp;
import de.ttsa.Logic.Features.Action.Action;
import de.ttsa.Logic.Features.ActionCall.ActionCall;
import de.ttsa.Logic.Features.DebugInput.DebugInput;
import de.ttsa.Logic.Features.GameExitScript.GameExitScript;
import de.ttsa.Logic.Features.GameLoaderScript.GameLoaderScript;
import de.ttsa.Logic.Features.GameSavingScript.GameSavingScript;
import de.ttsa.Logic.Features.If.If;
import de.ttsa.Logic.Features.Input.Input;
import de.ttsa.Logic.Features.Loop.Loop;
import de.ttsa.Logic.Features.LoopBreaker.LoopBreaker;
import de.ttsa.Logic.Features.MusicStarter.MusicStarter;
import de.ttsa.Logic.Features.NumInit.NumInit;
import de.ttsa.Logic.Features.Printer.Printer;
import de.ttsa.Logic.Features.Room.Room;
import de.ttsa.Logic.Features.RoomJumper.RoomJumper;
import de.ttsa.Logic.Features.Script.Script;
import de.ttsa.Logic.Features.Set.Set;
import de.ttsa.Logic.Features.StrInit.StrInit;
import de.ttsa.Logic.Player.Datatypes.*;
import de.ttsa.Tools.Formater;
import de.ttsa.Tools.SimpleLog;

class GameScriptBuilder {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    private List<String> game;

    private Input input = new Input();

    private Index opCodeIndex = Index.NONE;
    private SimpleLog log = PlayerApp.log;



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for GameScriptBuilder
     * @param gameContent the game content
     */
    public GameScriptBuilder(List<String> gameContent) {
        game = gameContent;
    }



// ---------------------------------------------- Loading ----------------------------------------------------- //


    /**
     * Load the game
     */
    public void load() {
        log.info("Start loading game data");
        long startTime = System.currentTimeMillis();
        loadGame(game);
        log.debug("Game data loaded in " + Formater.format(System.currentTimeMillis() - startTime));
    }

    /**
     * Load the games Line by Line and create the Scriptables
     * @param game game Data as a list of strings
     * @return the game as a scriptable
     */
    private Scriptable loadGame(List<String> game) {
        String opCode = "";
        String args   = "";
        String line   = "";


        ArrayList<Scriptable> gameScript = new ArrayList<Scriptable>();
        ArrayList<String> blockContent;


        for(int i = 0; i < game.size(); i++) {
            line   = game.get(i);
            opCode = line.substring(0, 2);
            args   = line.substring(2).strip();

            switch(opCodeIndex.convert(opCode)) {
                case SAY:

                    gameScript.add(say(args));
                    break;

                case ROOM:

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

                case ROOM_JUMPER:

                    gameScript.add(new RoomJumper(args));
                    break;

                case NUMBER_DEC:

                    numVars(args);
                    break;

                case STR_DEC:

                    strVars(args);
                    break;

                case NUM_INIT:

                    gameScript.add(varDec(args));
                    break;

                case IF:

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

                case INPUT:

                    gameScript.add(input);
                    break;

                case STR_INIT:

                    gameScript.add(strDec(args));
                    break;

                case DEBUG:

                    gameScript.add(new DebugInput(args));
                    break;

                case SAVE:

                    gameScript.add(new GameSavingScript());
                    break;

                case LOAD:

                    gameScript.add(new GameLoaderScript());
                    break;

                case EXIT:

                    gameScript.add(new GameExitScript(args));
                    break;

                case LOOP:

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

                case LOOP_BREAKER:

                    gameScript.add(new LoopBreaker());
                    break;

                case SET:

                    set(args);
                    break;

                case ACTION:

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

                case ACTION_CALL:

                    gameScript.add(actionCall(args));
                    break;
                
                case MUSIC_DEC:
                    
                    musicDec(args);
                    break;

                case MUSIC_STARTER:
                        
                        gameScript.add(new MusicStarter(args));
                        break;

                default:
                    throw new RuntimeException("OpCode " + opCode + " is not valid!");
            }
        }

        return new Script(gameScript);
    }



// ------------------------------------------ Command Functions ---------------------------------------------- //


    /**
     * Create a say Scriptable
     * @param args the arguments
     * @return the say Scriptable
     */
    private Scriptable say(String args) {
        String[] sayArgs          = args.split(Seperators.SAY.getSeperator());
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

    /**
     * Create a Room and adding it to the GameManager
     * @param roomContent the room content
     */
    private void room(ArrayList<String> roomContent) {
        try {
            String[] roomArgs = roomContent.get(0).split(Seperators.ROOM.getSeperator());
            String roomName   = roomArgs[0];
            
            
            roomContent.remove(0);
            
            Scriptable roomScript = loadGame(roomContent);
            GameManager.rooms.put(roomName, new Room(roomScript));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a NumVar and adding it to the GameManager
     * @param args the arguments
     */
    private void numVars(String args) {
        String[] numVarArgs = args.split(Seperators.NUMBER_VARIABLE.getSeperator());
        String numVarName   = numVarArgs[0];


        if(!isValidName(numVarName)) {
            throw new RuntimeException("NumVar name " + numVarName + " is not valid!");
        }

        int numVarValue = Integer.parseInt(numVarArgs[1]);
        GameManager.numVars.put(numVarName, new INT(numVarValue));
    }

    /**
     * Create a StrVar and adding it to the GameManager
     * @param args the arguments
     */
    private void strVars(String args) {
        String[] strVarArgs = args.split(Seperators.NUMBER_STRING.getSeperator());
        String strVarName   = strVarArgs[0];


        if(!isValidName(strVarName)) {
            throw new RuntimeException("StrVar name " + strVarName + " is not valid!");
        }

        String strVarValue = strVarArgs[1];
        GameManager.strVars.put(strVarName, new STRING(strVarValue));
    }

    /**
     * Create a VarDec Scriptable
     * @param args the arguments
     * @return the VarDec Scriptable
     */
    private Scriptable varDec(String args) {
        String[] varDecArgs = args.split(Seperators.NUMBER_DEC.getSeperator());
        String varDecName   = varDecArgs[0];


        if(!isValidName(varDecName)) {
            throw new RuntimeException("VarDec name " + varDecName + " is not valid!");
        }

        String varDecValue = varDecArgs[1];
        return new NumInit(varDecName, varDecValue);
    }

    /**
     * Create a If Scriptable
     * @param ifContent the if content
     * @return the If Scriptable
     */
    private Scriptable ifCalc(ArrayList<String> ifContent) {
        String ifBlockArg = ifContent.get(0);


        ifContent.remove(0);

        String[] ifArgs      = ifBlockArg.split(Seperators.IF_ELSE.getSeperator());
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

    /**
     * Create a StrDec Scriptable
     * @param args the arguments
     * @return the StrDec Scriptable
     */
    private Scriptable strDec(String args) {
        String[] strDecArgs = args.split(Seperators.STR.getSeperator());
        String strDecName   = strDecArgs[0];


        if(!isValidName(strDecName)) {
            throw new RuntimeException("StrDec name " + strDecName + " is not valid!");
        }

        String operation = strDecArgs[1];
        return new StrInit(strDecName, operation);
    }

    /**
     * Create a Loop Scriptable
     * @param args the arguments
     * @return the Loop Scriptable
     */
    private Scriptable loop(ArrayList<String> args) {
        String loopArg         = args.get(0);
        ArrayList<String> code = new ArrayList<String>();
        char conditionType;


        args.remove(0);

        String[] loopArgs = loopArg.split(":");
        String condition  = loopArgs[0];


        if(isNumber(condition)) conditionType                      = 'i';
        else if(condition.equals("true")) conditionType            = 't';
        else if(condition.matches("[a-zA-Z][\\w]*")) {
            conditionType = 'v';
            condition = condition.substring(1);
        } else conditionType                                       = 'c';

        for(String codeLine : args) {
            code.add(codeLine);
        }

        Scriptable script = loadGame(code);
        return new Loop(condition, conditionType, script);
    }

    /**
     * Create a Set and adding it to the GameManager
     * @param args the arguments
     */
    private void set(String args) {
        String[] setArgs      = args.split(Seperators.SET_NAME.getSeperator());
        String setName        = setArgs[0];
        String[] setVariables = setArgs[1].split(Seperators.SET.getSeperator());


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

    /**
     * Create a Action and adding it to the GameManager
     * @param actionContent the action content
     */
    private void action(ArrayList<String> actionContent) {
        String[] actionArgs   = actionContent.get(0).split(Seperators.ACTION.getSeperator());
        String[] actionParams = actionArgs[1].split(Seperators.ACTION_ARGS.getSeperator());


        actionContent.remove(0);

        Scriptable actionScript = loadGame(actionContent);
        GameManager.actions.put(actionArgs[0], new Action(actionScript, actionParams));
    }

    /**
     * Create a ActionCall Scriptable
     * @param args the arguments
     * @return the ActionCall Scriptable
     */
    private Scriptable actionCall(String args) {
        String[] actionCallArgs = args.split(Seperators.ACTION.getSeperator());
        String[] actionParams   = actionCallArgs[1].split(Seperators.ACTION_ARGS.getSeperator());


        return new ActionCall(actionCallArgs[0], actionParams);
    }

    private void musicDec(String args) {
        String[] musicArgs = args.split(Seperators.MUSIC_DEC.getSeperator());
        GameManager.music.put(musicArgs[0], musicArgs[1]);
    }



// ---------------------------------------------- Help Functions -------------------------------------------- //
    

    /**
     * Get the size of a room
     * @param args the arguments
     * @return the size of the room
     */
    private int getRoomSize(String args) {
        String[] roomArgs = args.split(Seperators.ROOM.getSeperator());


        return Integer.parseInt(roomArgs[1]);
    }

    /**
     * Check if a name is valid
     * @param name the name
     * @return if the name is valid
     */
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


    /**
     * Check if a string is a number
     * @param num the string
     * @return if the string is a number
     */
    private boolean isNumber(String num) {
        return num.matches("-?\\d+");
    }

    /**
     * Get the size of an if
     * @param args the arguments
     * @return the size of the if
     */
    private int getIfSize(String args) {
        String[] lengthS = args.split(Seperators.IF_ELSE.getSeperator());
        int length       = 0;


        for(String l : lengthS) {
            length += Integer.parseInt(l.substring(l.lastIndexOf(":") + 1));
        }

        return length;
    }

    /**
     * Get the size of a loop
     * @param args the arguments
     * @return the size of the loop
     */
    private int getLoopSize(String args) {
        String[] loopArgs = args.split(":");


        return Integer.parseInt(loopArgs[1]);
    }

    /**
     * Get the size of an action
     * @param args the arguments
     * @return the size of the action
     */
    private int getActionSize(String args) {
        String[] actionArgs = args.split(":");

        
        return Integer.parseInt(actionArgs[2]);
    }

}
