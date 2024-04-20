package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Enums.OpCodeRegex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class ActionCallOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] actions    = toTest.split(OpCodeSeperators.ACTION.getSeperator());
        String actionName   = actions[0];
        String[] actionArgs = actions[1].split(OpCodeSeperators.ACTION_ARGS.getSeperator());
        OpCodeIfTypes type;


        if(!opCodeVar.isActionName(actionName)) return false;

        String[] mainActionArgs = opCodeVar.getActionArgs(actionName).split(OpCodeSeperators.ACTION_ARGS.getSeperator());

        if(!opCodeVar.isActionName(actionName)) return false;

        for(int i=0; i < actionArgs.length; i++) {
            if(isEmptyArg(actionArgs[i])) continue;


            type = OpCodeIfTypes.convert(mainActionArgs[i].charAt(0));
            if(isValidName(actionArgs[i])) {
                if(type == OpCodeIfTypes.STRING) {
                    if(!opCodeVar.isStrName(actionArgs[i])) return false;
                } else if (type == OpCodeIfTypes.NUMBER) {
                    if(!opCodeVar.isNumName(actionArgs[i])) return false;
                }

            } else {

                if(isNumber(actionArgs[i])) {
                    if(type != OpCodeIfTypes.NUMBER) return false;
                } else {
                    if(type != OpCodeIfTypes.STRING) return false;
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
        return number.matches(OpCodeRegex.VALIDE_NUMBER.toString());
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
        return name.matches(OpCodeRegex.VALIDE_NAME.toString());
    }
}
