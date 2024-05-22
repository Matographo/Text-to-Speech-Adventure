package de.ttsa.Enums;

import de.ttsa.Interfaces.OpCodeVarTestable;
import de.ttsa.Logic.Features.Action.ActionOpCodeVar;
import de.ttsa.Logic.Features.ActionCall.ActionCallOpCodeVar;
import de.ttsa.Logic.Features.DebugInput.DebugInputOpCodeVar;
import de.ttsa.Logic.Features.If.IfOpCodeVar;
import de.ttsa.Logic.Features.Loop.LoopOpCodeVar;
import de.ttsa.Logic.Features.MusicDec.MusicDecOpCodeVar;
import de.ttsa.Logic.Features.MusicStarter.MusicStarterOpCodeVar;
import de.ttsa.Logic.Features.NumDec.NumDecOpCodeVar;
import de.ttsa.Logic.Features.NumInit.NumInitOpCodeVar;
import de.ttsa.Logic.Features.Printer.PrinterOpCodeVar;
import de.ttsa.Logic.Features.Room.RoomOpCodeVar;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperOpCodeVar;
import de.ttsa.Logic.Features.Set.SetOpCodeVar;
import de.ttsa.Logic.Features.StrDec.StrDecOpCodeVar;
import de.ttsa.Logic.Features.StrInit.StrInitOpCodeVar;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseOpCodeTest;
import de.ttsa.Logic.Player.Datatypes.AlwaysTrueOpCodeTest;

public enum OpCodeVarTests {
    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, MUSIC_DEC, MUSIC_STARTER, NONE;

    OpCodeVarTests mode;

    private final AlwaysFalseOpCodeTest alwaysFalse = new AlwaysFalseOpCodeTest();
    private final AlwaysTrueOpCodeTest alwaysTrue = new AlwaysTrueOpCodeTest();
    private final PrinterOpCodeVar printer = new PrinterOpCodeVar();
    private final ActionOpCodeVar action = new ActionOpCodeVar();
    private final ActionCallOpCodeVar actionCall = new ActionCallOpCodeVar();
    private final DebugInputOpCodeVar debugInput = new DebugInputOpCodeVar();
    private final IfOpCodeVar ifOpCode = new IfOpCodeVar();
    private final LoopOpCodeVar loop = new LoopOpCodeVar();
    private final NumDecOpCodeVar numDec = new NumDecOpCodeVar();
    private final NumInitOpCodeVar numInit = new NumInitOpCodeVar();
    private final RoomOpCodeVar room = new RoomOpCodeVar();
    private final SetOpCodeVar set = new SetOpCodeVar();
    private final RoomJumperOpCodeVar roomJumper = new RoomJumperOpCodeVar();
    private final StrDecOpCodeVar strDec = new StrDecOpCodeVar();
    private final StrInitOpCodeVar strInit = new StrInitOpCodeVar();
    private final MusicDecOpCodeVar musicDec = new MusicDecOpCodeVar();
    private final MusicStarterOpCodeVar musicStarter = new MusicStarterOpCodeVar();

    OpCodeVarTests() {
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
            case MUSIC_DEC:
                return musicDec;
            case MUSIC_STARTER:
                return musicStarter;
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
            case "12" -> this.mode = MUSIC_DEC;
            case "13" -> this.mode = MUSIC_STARTER;
            default   -> this.mode = NONE;
        }
    }
}
