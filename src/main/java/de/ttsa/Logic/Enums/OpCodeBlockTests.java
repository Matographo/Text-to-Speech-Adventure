package de.ttsa.Logic.Enums;

import de.ttsa.Logic.Features.Action.ActionOpCodeBlock;
import de.ttsa.Logic.Features.If.IfOpCodeBlock;
import de.ttsa.Logic.Features.If.IfOpCodeVar;
import de.ttsa.Logic.Features.Loop.LoopOpCodeBlock;
import de.ttsa.Logic.Features.Loop.LoopOpCodeSyntax;
import de.ttsa.Logic.Features.Room.RoomOpCodeBlock;
import de.ttsa.Logic.Interfaces.OpCodeBlockTestable;
import de.ttsa.Logic.Interfaces.OpCodeInnerBlockTestable;

public enum OpCodeBlockTests {
    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, NONE;

    OpCodeBlockTests mode;

    private final ActionOpCodeBlock action;
    private final IfOpCodeBlock ifOpCode;
    private final LoopOpCodeBlock loop;
    private final RoomOpCodeBlock room;

    OpCodeBlockTests() {
        action   = new ActionOpCodeBlock();
        ifOpCode = new IfOpCodeBlock();
        loop     = new LoopOpCodeBlock();
        room     = new RoomOpCodeBlock();
    }

    public OpCodeBlockTestable getBlockTest(String mode) {
        getMode(mode);
        switch (this.mode) {
            case ROOM:
                return room;
            case ACTION:
                return action;
            default:
                return null;
        }
    }

    public OpCodeInnerBlockTestable getInnerBlockTest(String mode) {
        getMode(mode);
        switch (this.mode) {
            case IF:
                return ifOpCode;
            case LOOP:
                return loop;
            default:
                return null;
        }
    }

    private void getMode(String mode) {
        switch (mode) {
            case "00" -> this.mode = SAY;
            case "01" -> this.mode = ROOM;
            case "02" -> this.mode = ROOM_JUMPER;
            case "03" -> this.mode = NUM_DEC;
            case "04" -> this.mode = STR_DEC;
            case "05" -> this.mode = NUM_INIT;
            case "06" -> this.mode = IF;
            case "07" -> this.mode = INPUT;
            case "08" -> this.mode = STR_INIT;
            case "09" -> this.mode = DEBUG_INPUT;
            case "0A" -> this.mode = GAME_SAVING_SCRIPT;
            case "0B" -> this.mode = GAME_LOADER_SCRIPT;
            case "0C" -> this.mode = GAME_EXIT_SCRIPT;
            case "0D" -> this.mode = LOOP;
            case "0E" -> this.mode = LOOP_BREAKER;
            case "0F" -> this.mode = SET;
            case "10" -> this.mode = ACTION;
            case "11" -> this.mode = ACTION_CALL;
            default   -> this.mode = NONE;
        }
    }
}
