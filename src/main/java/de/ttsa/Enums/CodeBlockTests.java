package de.ttsa.Enums;

import de.ttsa.Interfaces.CodeBlockTestable;
import de.ttsa.Logic.Features.Action.ActionCodeBlock;
import de.ttsa.Logic.Features.If.IfCodeBlock;
import de.ttsa.Logic.Features.Loop.LoopCodeBlock;
import de.ttsa.Logic.Features.Room.RoomCodeBlock;
import de.ttsa.Logic.Player.Datatypes.AlwaysTrueCodeTest;

public enum CodeBlockTests {
    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, NONE;

    CodeBlockTests mode;

    private final AlwaysTrueCodeTest alwaysTrue;
    private final ActionCodeBlock action;
    private final IfCodeBlock ifCode;
    private final LoopCodeBlock loop;
    private final RoomCodeBlock room;

    CodeBlockTests() {
        alwaysTrue = new AlwaysTrueCodeTest();
        action   = new ActionCodeBlock();
        ifCode   = new IfCodeBlock();
        loop     = new LoopCodeBlock();
        room     = new RoomCodeBlock();
    }

    public CodeBlockTestable getBlockTest(String mode) {
        getMode(mode);
        return switch (this.mode) {
            case ROOM   -> room;
            case ACTION -> action;
            case IF     -> ifCode;
            case LOOP   -> loop;
            default     -> alwaysTrue;
        };
    }

    private void getMode(String mode) {
        this.mode = switch (mode) {
            case "Say"    -> SAY;
            case "Room"   -> ROOM;
            case "Jump"   -> ROOM_JUMPER;
            case "Num"    -> NUM_DEC;
            case "Str"    -> STR_DEC;
            case "NumDec" -> NUM_INIT;
            case "If"     -> IF;
            case "Input"  -> INPUT;
            case "StrDec" -> STR_INIT;
            case "Debug"  -> DEBUG_INPUT;
            case "Save"   -> GAME_SAVING_SCRIPT;
            case "Load"   -> GAME_LOADER_SCRIPT;
            case "Exit"   -> GAME_EXIT_SCRIPT;
            case "Loop"   -> LOOP;
            case "Break"  -> LOOP_BREAKER;
            case "Set"    -> SET;
            case "Action" -> ACTION;
            case "Do"     -> ACTION_CALL;
            default       -> NONE;
        };
    }
}
