package de.ttsa.Logic.Features.Action;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeIfTypes;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class ActionOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        /*String[] actionArgs = toTest.split(OpCodeSeperators.ACTION.getSeperator());
        OpCodeIfTypes type;


        if(actionNames.contains(actionArgs[0])) return false;

        actionNames.add(actionArgs[0]);

        String[] actionArgss = actionArgs[1].split(OpCodeSeperators.ACTION_ARGS.getSeperator());

        for(String actionArg : actionArgss) {
            type = OpCodeIfTypes.convert(actionArg.charAt(0));

            if(type == OpCodeIfTypes.NONE_ARG) continue;

            actionArg = actionArg.substring(1);

            if(!type.isArgType())        return false;
            if(!isValidName(actionArg)) return false;


            if(type == OpCodeIfTypes.STRING) {

                if(strNames.contains(actionArg)) return false;

                strNames.add(actionArg);

            } else if (type == OpCodeIfTypes.NUMBER) {

                if(numNames.contains(actionArg)) return false;

                numNames.add(actionArg);

            }

            varNames.add(actionArg);
        }

        this.actionArgs.put(actionArgs[0], actionArgs[1]);

        return true;*/
        return false;
    }
    
}
