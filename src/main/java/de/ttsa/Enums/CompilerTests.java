package de.ttsa.Enums;

import de.ttsa.Interfaces.CompilerLine;
import de.ttsa.Interfaces.CompilerStruct;
import de.ttsa.Logic.Features.Action.ActionCompiler;
import de.ttsa.Logic.Features.ActionCall.ActionCall;
import de.ttsa.Logic.Features.ActionCall.ActionCallCompiler;
import de.ttsa.Logic.Features.DebugInput.DebugInputCompiler;
import de.ttsa.Logic.Features.GameExitScript.GameExitScriptCompiler;
import de.ttsa.Logic.Features.GameLoaderScript.GameLoaderScriptCompiler;
import de.ttsa.Logic.Features.GameSavingScript.GameSavingScriptCompiler;
import de.ttsa.Logic.Features.If.IfCompiler;
import de.ttsa.Logic.Features.Input.InputCompiler;
import de.ttsa.Logic.Features.Loop.LoopCompiler;
import de.ttsa.Logic.Features.LoopBreaker.LoopBreakerCompiler;
import de.ttsa.Logic.Features.NumDec.NumDecCompiler;
import de.ttsa.Logic.Features.NumInit.NumInitCompiler;
import de.ttsa.Logic.Features.Printer.PrinterCompiler;
import de.ttsa.Logic.Features.Room.RoomCompiler;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperCompiler;
import de.ttsa.Logic.Features.Set.SetCompiler;
import de.ttsa.Logic.Features.StrDec.StrDecCompiler;
import de.ttsa.Logic.Features.StrInit.StrInitCompiler;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseOpCodeTest;

public enum CompilerTests {
    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, NONE;

    CompilerTests mode;
    CompilerSyntax syntax = CompilerSyntax.ACTION;

    private final AlwaysFalseOpCodeTest alwaysFalse;
    private final PrinterCompiler printer;
    private final ActionCompiler action;
    private final ActionCallCompiler actionCall;
    private final DebugInputCompiler debugInput;
    private final GameExitScriptCompiler gameExitScript;
    private final GameLoaderScriptCompiler gameLoaderScript;
    private final GameSavingScriptCompiler gameSavingScript;
    private final IfCompiler ifOpCode;
    private final InputCompiler input;
    private final LoopBreakerCompiler loopBreaker;
    private final LoopCompiler loop;
    private final NumDecCompiler numDec;
    private final NumInitCompiler numInit;
    private final RoomCompiler room;
    private final SetCompiler set;
    private final RoomJumperCompiler roomJumper;
    private final StrDecCompiler strDec;
    private final StrInitCompiler strInit;

    CompilerTests() {
        alwaysFalse = new AlwaysFalseOpCodeTest();
        printer = new PrinterCompiler();
        action = new ActionCompiler();
        actionCall = new ActionCallCompiler();
        debugInput = new DebugInputCompiler();
        gameExitScript = new GameExitScriptCompiler();
        gameLoaderScript = new GameLoaderScriptCompiler();
        gameSavingScript = new GameSavingScriptCompiler();
        ifOpCode = new IfCompiler();
        input = new InputCompiler();
        loopBreaker = new LoopBreakerCompiler();
        loop = new LoopCompiler();
        numDec = new NumDecCompiler();
        numInit = new NumInitCompiler();
        room = new RoomCompiler();
        set = new SetCompiler();
        roomJumper = new RoomJumperCompiler();
        strDec = new StrDecCompiler();
        strInit = new StrInitCompiler();
    }

    public CompilerLine getCompilerLine(String line) {
        getMode(line);
        switch (mode) {
            case SAY:
                return printer;
            case ACTION_CALL:
                return actionCall;
            case DEBUG_INPUT:
                return debugInput;
            case GAME_EXIT_SCRIPT:
                return gameExitScript;
            case GAME_LOADER_SCRIPT:
                return gameLoaderScript;
            case GAME_SAVING_SCRIPT:
                return gameSavingScript;
            case INPUT:
                return input;
            case LOOP_BREAKER:
                return loopBreaker;
            case NUM_DEC:
                return numDec;
            case NUM_INIT:
                return numInit;
            case ROOM_JUMPER:
                return roomJumper;
            case STR_DEC:
                return strDec;
            case STR_INIT:
                return strInit;
            default:
                return null;
        }
    }

    public CompilerStruct getCompilerStruct(String line) {
        getMode(line);
        switch (mode) {
            case ACTION:
                return action;
            case IF:
                return ifOpCode;
            case LOOP:
                return loop;
            case ROOM:
                return room;
            case SET:
                return set;
            default:
                return null;
        }
    }

    private void getMode(String mode) {
        switch(syntax.getSyntax(mode)) {
            case SAY -> this.mode = SAY;
            case ACTION -> this.mode = ACTION;
            case ACTION_CALL -> this.mode = ACTION_CALL;
            case DEBUG_INPUT -> this.mode = DEBUG_INPUT;
            case GAME_EXIT_SCRIPT -> this.mode = GAME_EXIT_SCRIPT;
            case GAME_LOADER_SCRIPT -> this.mode = GAME_LOADER_SCRIPT;
            case GAME_SAVING_SCRIPT -> this.mode = GAME_SAVING_SCRIPT;
            case IF -> this.mode = IF;
            case INPUT -> this.mode = INPUT;
            case LOOP_BREAKER -> this.mode = LOOP_BREAKER;
            case LOOP -> this.mode = LOOP;
            case NUM_DEC -> this.mode = NUM_DEC;
            case NUM_INIT -> this.mode = NUM_INIT;
            case ROOM -> this.mode = ROOM;
            case SET -> this.mode = SET;
            case ROOM_JUMPER -> this.mode = ROOM_JUMPER;
            case STR_DEC -> this.mode = STR_DEC;
            case STR_INIT -> this.mode = STR_INIT;
            default -> this.mode = NONE;
        }
    }

}
