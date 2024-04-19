package de.ttsa.Logic.Features.Action;

import java.util.List;

import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeBlockTestable;

public class ActionOpCodeBlock implements OpCodeBlockTestable {

    @Override
    public boolean testOpCode(String args, List<String> lines) {
        return getActionBlockLength(args) <= lines.size();
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
