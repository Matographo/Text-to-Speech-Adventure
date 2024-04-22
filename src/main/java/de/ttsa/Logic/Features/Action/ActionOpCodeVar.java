package de.ttsa.Logic.Features.Action;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.IfTypes;
import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class ActionOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] actionArgs = toTest.split(Seperators.ACTION.getSeperator());
        IfTypes type;


        if(opCodeVar.isActionName(actionArgs[0])) return false;

        opCodeVar.addActionName(actionArgs[0]);

        String[] actionArgss = actionArgs[1].split(Seperators.ACTION_ARGS.getSeperator());

        for(String actionArg : actionArgss) {
            type = IfTypes.convert(actionArg.charAt(0));

            if(type == IfTypes.NONE_ARG) continue;

            actionArg = actionArg.substring(1);

            if(!type.isArgType())        return false;
            if(!isValidName(actionArg)) return false;


            if(type == IfTypes.STRING) {

                if(opCodeVar.isStrName(actionArg)) return false;

                opCodeVar.addStrName(actionArg);

            } else if (type == IfTypes.NUMBER) {

                if(opCodeVar.isNumName(actionArg)) return false;

                opCodeVar.addNumName(actionArg);

            }

        }

        opCodeVar.addActionArgs(actionArgs[0], actionArgs[1]);

        return true;
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
