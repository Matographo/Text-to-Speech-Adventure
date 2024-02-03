package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class ActionCall implements Scriptable{
    
    private String actionName;

    private String[] params;

    public ActionCall(String actionName, String[] params) {
        this.actionName = actionName;
        this.params     = params;
    }

    @Override
    public boolean run() {
        setValues();
        return GameManager.actions.get(actionName).run();
    }

    private void setValues() {
        String[] actionParams = GameManager.actions.get(actionName).getParams();
        String line;
        char paramType;
        String param;


        for (int i = 0; i < params.length; i++) {
            line      = params[i];
            param     = actionParams[i];
            paramType = param.charAt(0);
            param     = param.substring(1);


            switch (paramType) {
                case 's':
                    if(line.equals("-")) line = "";

                    if(line.startsWith("\"") && line.endsWith("\"")) {
                        GameManager.strVars.get(param).setValue(line.substring(1, line.length() - 1));
                    } else {
                        GameManager.strVars.get(param).setValue(GameManager.strVars.get(line).getValue());
                    }

                    break;
                case 'n':
                    if(line.equals("-")) line = "0";

                    if(line.matches("\\d+")) {
                        GameManager.numVars.get(param).setValue(Integer.parseInt(line));
                    } else {
                        GameManager.numVars.get(param).setValue(GameManager.numVars.get(line).getValue());
                    }
                    
                    break;
                default:
                    break;
            }
        }
    }

}
