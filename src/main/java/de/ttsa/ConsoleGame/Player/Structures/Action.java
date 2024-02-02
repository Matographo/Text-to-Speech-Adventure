package de.ttsa.ConsoleGame.Player.Structures;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;
import de.ttsa.ConsoleGame.Player.Scriptables.Scriptable;

public class Action {
    
    private Scriptable[] script;

    private String[] params;

    public Action(Scriptable[] script, String[] params) {
        this.script = script;
        this.params = params;
        char paramType;
        for(String param : params) {
            paramType = param.charAt(0);
            param = param.substring(1);
            switch (paramType) {
                case 's':
                        GameManager.strVars.put(param, new STRING(""));
                    break;
                case 'n':
                        GameManager.numVars.put(param, new INT(0));
                    break;
                default:
                    break;
            }
        }
    }

    public Action(Scriptable script, String[] params) {
        this(new Scriptable[]{script}, params);
    }

    public boolean run() {
        for (Scriptable s : script) {
            if (!s.run()) {
                return false;
            }
        }
        return true;
    }

    public String[] getParams() {
        return params;
    }


}
