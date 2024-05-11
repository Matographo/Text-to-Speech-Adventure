package de.ttsa.Enums;

import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Logic.Features.Action.ActionCodeVar;
import de.ttsa.Logic.Features.ActionCall.ActionCallCodeVar;
import de.ttsa.Logic.Features.DebugInput.DebugInputCodeVar;
import de.ttsa.Logic.Features.If.IfCodeVar;
import de.ttsa.Logic.Features.Loop.LoopCodeVar;
import de.ttsa.Logic.Features.NumDec.NumDecCodeVar;
import de.ttsa.Logic.Features.NumInit.NumInitCodeVar;
import de.ttsa.Logic.Features.Printer.PrinterCodeVar;
import de.ttsa.Logic.Features.Room.RoomCodeVar;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperCodeVar;
import de.ttsa.Logic.Features.Set.SetCodeVar;
import de.ttsa.Logic.Features.StrDec.StrDecCodeVar;
import de.ttsa.Logic.Features.StrInit.StrInitCodeVar;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseCodeTest;
import de.ttsa.Logic.Player.Datatypes.AlwaysTrueCodeTest;

public enum CodeVarTests {
    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, NONE;

    CodeVarTests mode;

    private final AlwaysFalseCodeTest alwaysFalse;
    private final AlwaysTrueCodeTest alwaysTrue;
    private final ActionCodeVar action;
    private final ActionCallCodeVar actionCall;
    private final PrinterCodeVar printer;
    private final DebugInputCodeVar debugInput;
    private final IfCodeVar ifOpCode;
    private final LoopCodeVar loop;
    private final NumDecCodeVar numDec;
    private final NumInitCodeVar numInit;
    private final RoomCodeVar room;
    private final SetCodeVar set;
    private final RoomJumperCodeVar roomJumper;
    private final StrDecCodeVar strDec;
    private final StrInitCodeVar strInit;

    CodeVarTests() {
        alwaysFalse = new AlwaysFalseCodeTest();
        alwaysTrue = new AlwaysTrueCodeTest();
        printer = new PrinterCodeVar();
        action = new ActionCodeVar();
        actionCall = new ActionCallCodeVar();
        ifOpCode = new IfCodeVar();
        loop = new LoopCodeVar();
        numDec = new NumDecCodeVar();
        numInit = new NumInitCodeVar();
        room = new RoomCodeVar();
        set = new SetCodeVar();
        roomJumper = new RoomJumperCodeVar();
        strDec = new StrDecCodeVar();
        strInit = new StrInitCodeVar();
        debugInput = new DebugInputCodeVar();
    }

    public CodeVarTestable getTest(String mode) {
        getMode(mode);
        CodeVarTestable test;
        return switch (this.mode) {
            case SAY         -> printer;
            case ACTION      -> action;
            case ACTION_CALL -> actionCall;
            case IF          -> ifOpCode;
            case LOOP        -> loop;
            case NUM_DEC     -> numDec;
            case NUM_INIT    -> numInit;
            case ROOM        -> room;
            case SET         -> set;
            case ROOM_JUMPER -> roomJumper;
            case STR_DEC     -> strDec;
            case STR_INIT    -> strInit;
            case DEBUG_INPUT -> debugInput;
            case NONE        -> alwaysTrue;
            default          -> alwaysTrue;
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
