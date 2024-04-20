package de.ttsa.Logic.Enums;

import de.ttsa.Logic.Features.Action.ActionOpCodeVar;
import de.ttsa.Logic.Features.ActionCall.ActionCallOpCodeVar;
import de.ttsa.Logic.Features.DebugInput.DebugInputOpCodeVar;
import de.ttsa.Logic.Features.If.IfOpCodeVar;
import de.ttsa.Logic.Features.Loop.LoopOpCodeVar;
import de.ttsa.Logic.Features.NumDec.NumDecOpCodeVar;
import de.ttsa.Logic.Features.NumInit.NumInitOpCodeVar;
import de.ttsa.Logic.Features.Printer.PrinterOpCodeVar;
import de.ttsa.Logic.Features.Room.RoomOpCodeVar;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperOpCodeVar;
import de.ttsa.Logic.Features.Set.SetOpCodeVar;
import de.ttsa.Logic.Features.StrDec.StrDecOpCodeVar;
import de.ttsa.Logic.Features.StrInit.StrInitOpCodeVar;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseOpCodeTest;
import de.ttsa.Logic.Player.Datatypes.AlwaysTrueOpCodeTest;

public enum OpCodeVarTests {
    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, NONE;

    OpCodeVarTests mode;

    private final AlwaysFalseOpCodeTest alwaysFalse;
    private final AlwaysTrueOpCodeTest alwaysTrue;
    private final PrinterOpCodeVar printer;
    private final ActionOpCodeVar action;
    private final ActionCallOpCodeVar actionCall;
    private final DebugInputOpCodeVar debugInput;
    private final IfOpCodeVar ifOpCode;
    private final LoopOpCodeVar loop;
    private final NumDecOpCodeVar numDec;
    private final NumInitOpCodeVar numInit;
    private final RoomOpCodeVar room;
    private final SetOpCodeVar set;
    private final RoomJumperOpCodeVar roomJumper;
    private final StrDecOpCodeVar strDec;
    private final StrInitOpCodeVar strInit;

    OpCodeVarTests() {
        alwaysFalse = new AlwaysFalseOpCodeTest();
        alwaysTrue = new AlwaysTrueOpCodeTest();
        printer = new PrinterOpCodeVar();
        action = new ActionOpCodeVar();
        actionCall = new ActionCallOpCodeVar();
        debugInput = new DebugInputOpCodeVar();
        ifOpCode = new IfOpCodeVar();
        loop = new LoopOpCodeVar();
        numDec = new NumDecOpCodeVar();
        numInit = new NumInitOpCodeVar();
        room = new RoomOpCodeVar();
        set = new SetOpCodeVar();
        roomJumper = new RoomJumperOpCodeVar();
        strDec = new StrDecOpCodeVar();
        strInit = new StrInitOpCodeVar();
    }

    public OpCodeVarTestable getTest(String mode) {
        getMode(mode);
        switch (this.mode) {
            case SAY:
                return printer;
            case ACTION:
                return action;
            case ACTION_CALL:
                return actionCall;
            case DEBUG_INPUT:
                return debugInput;
            case IF:
                return ifOpCode;
            case LOOP:
                return loop;
            case NUM_DEC:
                return numDec;
            case NUM_INIT:
                return numInit;
            case ROOM:
                return room;
            case SET:
                return set;
            case ROOM_JUMPER:
                return roomJumper;
            case STR_DEC:
                return strDec;
            case STR_INIT:
                return strInit;
            case NONE:
                return alwaysFalse;
            default:
                return alwaysTrue;

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
