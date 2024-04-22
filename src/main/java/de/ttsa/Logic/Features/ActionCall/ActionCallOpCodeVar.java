package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.IfTypes;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class ActionCallOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] actions    = toTest.split(Seperators.ACTION.getSeperator());
        String actionName   = actions[0];
        String[] actionArgs = actions[1].split(Seperators.ACTION_ARGS.getSeperator());
        IfTypes type;


        if(!opCodeVar.isActionName(actionName)) return false;

        String[] mainActionArgs = opCodeVar.getActionArgs(actionName).split(Seperators.ACTION_ARGS.getSeperator());

        if(!opCodeVar.isActionName(actionName)) return false;

        for(int i=0; i < actionArgs.length; i++) {
            if(isEmptyArg(actionArgs[i])) continue;


            type = IfTypes.convert(mainActionArgs[i].charAt(0));
            if(isValidName(actionArgs[i])) {
                if(type == IfTypes.STRING) {
                    if(!opCodeVar.isStrName(actionArgs[i])) return false;
                } else if (type == IfTypes.NUMBER) {
                    if(!opCodeVar.isNumName(actionArgs[i])) return false;
                }

            } else {

                if(isNumber(actionArgs[i])) {
                    if(type != IfTypes.NUMBER) return false;
                } else {
                    if(type != IfTypes.STRING) return false;
                }

            }
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
     * Test if the String is an Empty Argument
     * @param name String to test
     * @return true if the String is an Empty Argument
     */
    private boolean isEmptyArg(String name) {
        return name.equals("-");
    }
    
    /**
     * Test if the name is valid
     * @param name The name to test
     * @return true if the name is valid
     */
    private boolean isValidName(String name) {
        return name.matches(Regex.VALIDE_NAME.toString());
    }
}
