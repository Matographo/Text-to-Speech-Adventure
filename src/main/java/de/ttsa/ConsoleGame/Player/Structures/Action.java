package de.ttsa.ConsoleGame.Player.Structures;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;
import de.ttsa.ConsoleGame.Player.Scriptables.Scriptable;

public class Action {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private Scriptable[] script;
    private String[] params;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    /**
     * Constructor for Action
     * @param script the script that should be executed
     * @param params the parameters that should be set
     */
    public Action(Scriptable[] script, String[] params) {
        this.script = script;
        this.params = params;
        char paramType;


        for(String param : params) {
            paramType = param.charAt(0);
            param     = param.substring(1);


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

    /**
     * Constructor for Action
     * @param script the script that should be executed
     * @param params the parameters that should be set
     */
    public Action(Scriptable script, String[] params) {
        this(new Scriptable[]{script}, params);
    }



// ---------------------------------------------- Run ------------------------------------------------- //


    /**
     * Run the script
     * @return true if the script was executed successfully
     */
    public boolean run() {
        for (Scriptable s : script) {
            if (!s.run()) return false;
        }

        return true;
    }

    /**
     * Get the parameters
     * @return the parameters
     */
    public String[] getParams() {
        return params;
    }


}
