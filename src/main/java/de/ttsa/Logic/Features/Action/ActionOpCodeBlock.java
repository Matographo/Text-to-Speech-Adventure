package de.ttsa.Logic.Features.Action;

import java.util.List;

import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Interfaces.OpCodeBlockTestable;

public class ActionOpCodeBlock implements OpCodeBlockTestable {

    @Override
    public int testOpCode(String args, List<String> lines) {
        if(getActionBlockLength(args) > lines.size()) return -1;
        return getActionBlockLength(args);
    }

    /**
     * Get the length of the action block
     * @param args The arguments of the action command
     * @return The length of the action block
     */
    private int getActionBlockLength(String args) {
        return Integer.parseInt(args.split(OpCodeSeperators.ACTION.getSeperator())[2]);
    }
}
