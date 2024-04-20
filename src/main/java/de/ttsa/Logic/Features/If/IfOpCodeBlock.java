package de.ttsa.Logic.Features.If;

import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeInnerBlockTestable;

public class IfOpCodeBlock implements OpCodeInnerBlockTestable {

    @Override
    public boolean test(String args, int position, int endOfStruct) {
        String[] toTest = args.split(OpCodeSeperators.IF_ELSE.getSeperator());
        int blockLenght = 0;

        for(String test : toTest) {
            blockLenght += getIfBlockLength(test);
        }

        return position + blockLenght + 1 <= endOfStruct;
    }

    /**
     * Get the length of the if block
     * @param args The arguments of the if command
     * @return The length of the if block
     */
    private int getIfBlockLength(String args) {
        return Integer.parseInt(args.split(OpCodeSeperators.IF_NUM.getSeperator())[1]);
    }
    
}
