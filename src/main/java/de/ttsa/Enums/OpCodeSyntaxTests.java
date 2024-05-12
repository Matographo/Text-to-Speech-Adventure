package de.ttsa.Enums;

import de.ttsa.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Logic.Features.Action.ActionOpCodeSyntax;
import de.ttsa.Logic.Features.ActionCall.ActionCallOpCodeSyntax;
import de.ttsa.Logic.Features.DebugInput.DebugInputOpCodeSyntax;
import de.ttsa.Logic.Features.GameExitScript.GameExitScriptOpCodeSyntax;
import de.ttsa.Logic.Features.GameLoaderScript.GameLoaderScriptOpCodeSyntax;
import de.ttsa.Logic.Features.GameSavingScript.GameSavingScriptOpCodeSyntax;
import de.ttsa.Logic.Features.If.IfOpCodeSyntax;
import de.ttsa.Logic.Features.Input.InputOpCodeSyntax;
import de.ttsa.Logic.Features.Loop.LoopOpCodeSyntax;
import de.ttsa.Logic.Features.LoopBreaker.LoopBreakerOpCodeSyntax;
import de.ttsa.Logic.Features.NumDec.NumDecOpCodeSyntax;
import de.ttsa.Logic.Features.NumInit.NumInitOpCodeSyntax;
import de.ttsa.Logic.Features.Printer.PrinterOpCodeSyntax;
import de.ttsa.Logic.Features.Room.RoomOpCodeSyntax;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperOpCodeSyntax;
import de.ttsa.Logic.Features.Set.SetOpCodeSyntax;
import de.ttsa.Logic.Features.StrDec.StrDecOpCodeSyntax;
import de.ttsa.Logic.Features.StrInit.StrInitOpCodeSyntax;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseOpCodeTest;

public enum OpCodeSyntaxTests {

    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT,
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM,
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, ALWAYS_FALSE;

    OpCodeSyntaxTests mode;

    private final AlwaysFalseOpCodeTest alwaysFalse;
    private final PrinterOpCodeSyntax printer;
    private final ActionOpCodeSyntax action;
    private final ActionCallOpCodeSyntax actionCall;
    private final DebugInputOpCodeSyntax debugInput;
    private final GameExitScriptOpCodeSyntax gameExitScript;
    private final GameLoaderScriptOpCodeSyntax gameLoaderScript;
    private final GameSavingScriptOpCodeSyntax gameSavingScript;
    private final IfOpCodeSyntax ifOpCode;
    private final InputOpCodeSyntax input;
    private final LoopBreakerOpCodeSyntax loopBreaker;
    private final LoopOpCodeSyntax loop;
    private final NumDecOpCodeSyntax numDec;
    private final NumInitOpCodeSyntax numInit;
    private final RoomOpCodeSyntax room;
    private final SetOpCodeSyntax set;
    private final RoomJumperOpCodeSyntax roomJumper;
    private final StrDecOpCodeSyntax strDec;
    private final StrInitOpCodeSyntax strInit;

    OpCodeSyntaxTests() {
        alwaysFalse = new AlwaysFalseOpCodeTest();
        printer = new PrinterOpCodeSyntax();
        action = new ActionOpCodeSyntax();
        actionCall = new ActionCallOpCodeSyntax();
        debugInput = new DebugInputOpCodeSyntax();
        gameExitScript = new GameExitScriptOpCodeSyntax();
        gameLoaderScript = new GameLoaderScriptOpCodeSyntax();
        gameSavingScript = new GameSavingScriptOpCodeSyntax();
        ifOpCode = new IfOpCodeSyntax();
        input = new InputOpCodeSyntax();
        loopBreaker = new LoopBreakerOpCodeSyntax();
        loop = new LoopOpCodeSyntax();
        numDec = new NumDecOpCodeSyntax();
        numInit = new NumInitOpCodeSyntax();
        room = new RoomOpCodeSyntax();
        set = new SetOpCodeSyntax();
        roomJumper = new RoomJumperOpCodeSyntax();
        strDec = new StrDecOpCodeSyntax();
        strInit = new StrInitOpCodeSyntax();

    }

    public OpCodeSyntaxTestable getTest(String mode) {
        getMode(mode);
        OpCodeSyntaxTestable test;
        return switch (this.mode) {
            case SAY -> printer;
            case ACTION -> action;
            case ACTION_CALL -> actionCall;
            case DEBUG_INPUT -> debugInput;
            case GAME_EXIT_SCRIPT -> gameExitScript;
            case GAME_LOADER_SCRIPT -> gameLoaderScript;
            case GAME_SAVING_SCRIPT -> gameSavingScript;
            case IF -> ifOpCode;
            case INPUT -> input;
            case LOOP_BREAKER -> loopBreaker;
            case LOOP -> loop;
            case NUM_DEC -> numDec;
            case NUM_INIT -> numInit;
            case ROOM -> room;
            case SET -> set;
            case ROOM_JUMPER -> roomJumper;
            case STR_DEC -> strDec;
            case STR_INIT -> strInit;
            default -> alwaysFalse;
        };
    }

    private void getMode(String mode) {
        this.mode = switch (mode) {
            case "00" -> SAY;
            case "01" -> ROOM;
            case "02" -> ROOM_JUMPER;
            case "03" -> NUM_DEC;
            case "04" -> STR_DEC;
            case "05" -> NUM_INIT;
            case "06" -> IF;
            case "07" -> INPUT;
            case "08" -> STR_INIT;
            case "09" -> DEBUG_INPUT;
            case "0A" -> GAME_SAVING_SCRIPT;
            case "0B" -> GAME_LOADER_SCRIPT;
            case "0C" -> GAME_EXIT_SCRIPT;
            case "0D" -> LOOP;
            case "0E" -> LOOP_BREAKER;
            case "0F" -> SET;
            case "10" -> ACTION;
            case "11" -> ACTION_CALL;
            default -> ALWAYS_FALSE;
        };
    }
}
