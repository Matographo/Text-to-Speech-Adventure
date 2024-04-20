package de.ttsa.Logic.Features.Room;

import java.util.List;

import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeBlockTestable;

public class RoomOpCodeBlock implements OpCodeBlockTestable {

    @Override
    public int testOpCode(String args, List<String> nextLines) {
        if(getRoomBlockLength(args) > nextLines.size()) return -1;
        return getRoomBlockLength(args);
    }


    /**
     * Get the length of the room block
     * @param args The arguments of the room command
     * @return The length of the room block
     */
    private int getRoomBlockLength(String args) {
        return Integer.parseInt(args.split(OpCodeSeperators.ROOM.getSeperator())[1]);
    }
    
}
