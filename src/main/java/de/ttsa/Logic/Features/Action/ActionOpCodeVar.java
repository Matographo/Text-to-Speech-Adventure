package de.ttsa.Logic.Features.Action;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Enums.OpCodeRegex;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class ActionOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] actionArgs = toTest.split(OpCodeSeperators.ACTION.getSeperator());
        OpCodeIfTypes type;


        if(opCodeVar.isActionName(actionArgs[0])) return false;

        opCodeVar.addActionName(actionArgs[0]);

        String[] actionArgss = actionArgs[1].split(OpCodeSeperators.ACTION_ARGS.getSeperator());

        for(String actionArg : actionArgss) {
            type = OpCodeIfTypes.convert(actionArg.charAt(0));

            if(type == OpCodeIfTypes.NONE_ARG) continue;

            actionArg = actionArg.substring(1);

            if(!type.isArgType())        return false;
            if(!isValidName(actionArg)) return false;


            if(type == OpCodeIfTypes.STRING) {

                if(opCodeVar.isStrName(actionArg)) return false;

                opCodeVar.addStrName(actionArg);

            } else if (type == OpCodeIfTypes.NUMBER) {

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
        return name.matches(OpCodeRegex.VALIDE_NAME.toString());
    }
    
}
