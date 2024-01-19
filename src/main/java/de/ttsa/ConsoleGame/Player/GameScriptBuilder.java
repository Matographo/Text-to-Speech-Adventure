package de.ttsa.ConsoleGame.Player;

import java.util.ArrayList;

import de.ttsa.ConsoleGame.Player.Datatypes.PrintText;
import de.ttsa.ConsoleGame.Player.Datatypes.Printablable;
import de.ttsa.ConsoleGame.Player.Datatypes.Script;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;
import de.ttsa.ConsoleGame.Player.Functions.Printer;

public class GameScriptBuilder {


    private ArrayList<String> game;

// ------------------ Command Seperators ------------------

private final String COMMAND_SEPERATOR = "::";
private final String SAY_SEPERATOR = ",";

// ------------------ Command Inizes ----------------------

private final String INDEX_SAY = "00";



    public GameScriptBuilder(ArrayList<String> gameContent) {
        game = gameContent;
    }

    public Scriptable load() {
        return loadGame(game);
    }


    public Scriptable loadGame(ArrayList<String> game) {
        String opCode = "";
        String args = "";
        Script gameScript = new Script();
        for(String line : game) {
            opCode = line.split(COMMAND_SEPERATOR)[0];
            args = line.substring(line.indexOf(COMMAND_SEPERATOR) + opCode.length()).strip();

            switch(opCode) {
                case INDEX_SAY:
                    gameScript.add(say(args));
                    break;
                default:
                    throw new RuntimeException("OpCode " + opCode + " is not valid!");
            }
        }
        return gameScript;
    }

    private Scriptable say(String args) {
        String[] sayArgs = args.split(SAY_SEPERATOR);
        Printablable[] printables = new Printablable[sayArgs.length];
        String arg = "";
        for(int i = 0; i < sayArgs.length; i++) {
            arg = sayArgs[i];
            if(arg.startsWith("\"") && arg.endsWith("\"")) {
                printables[i] = new PrintText(arg.substring(1, arg.length() - 1));
            } else {
                throw new RuntimeException("Say argument " + arg + " is not valid!");
            }
        }
        return new Printer(printables);
    }
}
