package de.ttsa.ConsoleGame.Player;

import java.util.ArrayList;

import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Datatypes.PrintText;
import de.ttsa.ConsoleGame.Player.Datatypes.Printablable;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;
import de.ttsa.ConsoleGame.Player.Datatypes.Script;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;
import de.ttsa.ConsoleGame.Player.Functions.Printer;
import de.ttsa.ConsoleGame.Player.Functions.RoomJumper;
import de.ttsa.ConsoleGame.Player.Functions.VarDec;
import de.ttsa.ConsoleGame.Player.Structures.Room;

public class GameScriptBuilder {


    private ArrayList<String> game;

// ------------------ Command Seperators ------------------

private final String COMMAND_SEPERATOR = "::";
private final String SAY_SEPERATOR = ",";
private final String ROOM_SEPERATOR = ":";
private final String VAR_SEPERATOR = ":";

// ------------------ Command Inizes ----------------------

private final String INDEX_SAY = "00";
private final String INDEX_ROOM = "01";
private final String INDEX_ROOM_JUMPER = "02";
private final String INDEX_NUMVAR = "03";
private final String INDEX_STRVAR = "04";
private final String INDEX_NUMDEC = "05";



    public GameScriptBuilder(ArrayList<String> gameContent) {
        game = gameContent;
    }

    public Scriptable load() {
        return loadGame(game);
    }


    public Scriptable loadGame(ArrayList<String> game) {
        String opCode = "";
        String args = "";
        String line = "";
        Script gameScript = new Script();
        ArrayList<String> roomContent;
        for(int i = 0; i < game.size(); i++) {
            line = game.get(i);
            opCode = line.split(COMMAND_SEPERATOR)[0];
            args = line.substring(line.indexOf(COMMAND_SEPERATOR) + opCode.length()).strip();

            switch(opCode) {
                case INDEX_SAY:
                    gameScript.add(say(args));
                    break;
                case INDEX_ROOM:
                    int roomSize = getRoomSize(args);
                    roomContent = new ArrayList<String>(roomSize);
                    game.set(i, args);
                    for(int j = 0; j <= roomSize; j++) {
                        roomContent.add(game.get(i));
                        game.remove(i);
                    }
                    room(roomContent);
                    i--;
                    break;
                case INDEX_ROOM_JUMPER:
                    gameScript.add(new RoomJumper(args));
                    break;
                case INDEX_NUMVAR:
                    numVars(args);
                    break;
                case INDEX_STRVAR:
                    strVars(args);
                    break;
                case INDEX_NUMDEC:
                    gameScript.add(varDec(args));
                default:
                    throw new RuntimeException("OpCode " + opCode + " is not valid!");
            }
        }
        return gameScript;
    }


// ------------------ Command Functions -------------------


    private Scriptable say(String args) {
        String[] sayArgs = args.split(SAY_SEPERATOR);
        Printablable[] printables = new Printablable[sayArgs.length];
        String arg = "";
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
        String roomName = roomArgs[0];
        roomContent.remove(0);
        Scriptable roomScript = loadGame(roomContent);
        GameManager.rooms.put(roomName, new Room(roomScript));
    }

    private void numVars(String args) {
        String[] numVarArgs = args.split(VAR_SEPERATOR);
        String numVarName = numVarArgs[0];
        if(!isValidName(numVarName)) {
            throw new RuntimeException("NumVar name " + numVarName + " is not valid!");
        }
        int numVarValue = Integer.parseInt(numVarArgs[1]);
        GameManager.numVars.put(numVarName, new INT(numVarValue));
    }

    private void strVars(String args) {
        String[] strVarArgs = args.split(VAR_SEPERATOR);
        String strVarName = strVarArgs[0];
        if(!isValidName(strVarName)) {
            throw new RuntimeException("StrVar name " + strVarName + " is not valid!");
        }
        String strVarValue = strVarArgs[1];
        GameManager.strVars.put(strVarName, new STRING(strVarValue));
    }

    private Scriptable varDec(String args) {
        String[] varDecArgs = args.split(VAR_SEPERATOR);
        String varDecName = varDecArgs[0];
        if(!isValidName(varDecName)) {
            throw new RuntimeException("VarDec name " + varDecName + " is not valid!");
        }
        String varDecValue = varDecArgs[1];
        return new VarDec(varDecName, varDecValue);
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
}
