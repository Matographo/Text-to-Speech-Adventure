package de.ttsa.Logic.Features.Loop;

import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Interfaces.OpCodeInnerBlockTestable;

public class LoopOpCodeBlock implements OpCodeInnerBlockTestable {

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
