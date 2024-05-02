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
        switch (this.mode) {
            case SAY -> test = printer;
            case ACTION -> test = action;
            case ACTION_CALL -> test = actionCall;
            case DEBUG_INPUT -> test = debugInput;
            case GAME_EXIT_SCRIPT -> test = gameExitScript;
            case GAME_LOADER_SCRIPT -> test = gameLoaderScript;
            case GAME_SAVING_SCRIPT -> test = gameSavingScript;
            case IF -> test = ifOpCode;
            case INPUT -> test = input;
            case LOOP_BREAKER -> test = loopBreaker;
            case LOOP -> test = loop;
            case NUM_DEC -> test = numDec;
            case NUM_INIT -> test = numInit;
            case ROOM -> test = room;
            case SET -> test = set;
            case ROOM_JUMPER -> test = roomJumper;
            case STR_DEC -> test = strDec;
            case STR_INIT -> test = strInit;
            default -> test = alwaysFalse;
        }
        return test;
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
        }
    }
}
