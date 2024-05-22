package de.ttsa.Enums;

import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Logic.Features.Action.ActionCodeVar;
import de.ttsa.Logic.Features.ActionCall.ActionCallCodeVar;
import de.ttsa.Logic.Features.DebugInput.DebugInputCodeVar;
import de.ttsa.Logic.Features.If.IfCodeVar;
import de.ttsa.Logic.Features.Loop.LoopCodeVar;
import de.ttsa.Logic.Features.MusicDec.MusicDecCodeVar;
import de.ttsa.Logic.Features.MusicStarter.MusicStarterCodeVar;
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
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, MUSIC_DEC, MUSIC_STARTER, NONE;

    CodeVarTests mode;

    private final AlwaysFalseCodeTest alwaysFalse = new AlwaysFalseCodeTest();
    private final AlwaysTrueCodeTest alwaysTrue = new AlwaysTrueCodeTest();
    private final ActionCodeVar action = new ActionCodeVar();
    private final ActionCallCodeVar actionCall = new ActionCallCodeVar();
    private final PrinterCodeVar printer = new PrinterCodeVar();
    private final DebugInputCodeVar debugInput = new DebugInputCodeVar();
    private final IfCodeVar ifOpCode = new IfCodeVar();
    private final LoopCodeVar loop = new LoopCodeVar();
    private final NumDecCodeVar numDec = new NumDecCodeVar();
    private final NumInitCodeVar numInit = new NumInitCodeVar();
    private final RoomCodeVar room = new RoomCodeVar();
    private final SetCodeVar set = new SetCodeVar();
    private final RoomJumperCodeVar roomJumper = new RoomJumperCodeVar();
    private final StrDecCodeVar strDec = new StrDecCodeVar();
    private final StrInitCodeVar strInit = new StrInitCodeVar();
    private final MusicDecCodeVar musicDec = new MusicDecCodeVar();
    private final MusicStarterCodeVar musicStarter = new MusicStarterCodeVar();

    CodeVarTests() {
    }

    public CodeVarTestable getTest(String mode) {
        getMode(mode);
        CodeVarTestable test;
        return switch (this.mode) {
            case SAY           -> printer;
            case ACTION        -> action;
            case ACTION_CALL   -> actionCall;
            case IF            -> ifOpCode;
            case LOOP          -> loop;
            case NUM_DEC       -> numDec;
            case NUM_INIT      -> numInit;
            case ROOM          -> room;
            case SET           -> set;
            case ROOM_JUMPER   -> roomJumper;
            case STR_DEC       -> strDec;
            case STR_INIT      -> strInit;
            case DEBUG_INPUT   -> debugInput;
            case MUSIC_DEC     -> musicDec;
            case MUSIC_STARTER -> musicStarter;
            case NONE          -> alwaysTrue;
            default            -> alwaysTrue;
        };
    }

    private void getMode(String mode) {
        this.mode = switch (mode) {
            case "Say"       -> SAY;
            case "Room"      -> ROOM;
            case "Jump"      -> ROOM_JUMPER;
            case "Num"       -> NUM_DEC;
            case "Str"       -> STR_DEC;
            case "NumDec"    -> NUM_INIT;
            case "If"        -> IF;
            case "Input"     -> INPUT;
            case "StrDec"    -> STR_INIT;
            case "Debug"     -> DEBUG_INPUT;
            case "Save"      -> GAME_SAVING_SCRIPT;
            case "Load"      -> GAME_LOADER_SCRIPT;
            case "Exit"      -> GAME_EXIT_SCRIPT;
            case "Loop"      -> LOOP;
            case "Break"     -> LOOP_BREAKER;
            case "Set"       -> SET;
            case "Action"    -> ACTION;
            case "Do"        -> ACTION_CALL;
            case "Music"     -> MUSIC_DEC;
            case "PlayMusic" -> MUSIC_STARTER;
            default          -> NONE;
        };
    }
}
