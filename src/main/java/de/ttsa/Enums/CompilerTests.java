package de.ttsa.Enums;

import de.ttsa.Interfaces.CompilerLine;
import de.ttsa.Interfaces.CompilerStruct;
import de.ttsa.Logic.Features.Action.ActionCompiler;
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

    private final AlwaysFalseOpCodeTest alwaysFalse = new AlwaysFalseOpCodeTest();
    private final PrinterCompiler printer = new PrinterCompiler();
    private final ActionCompiler action = new ActionCompiler();
    private final ActionCallCompiler actionCall = new ActionCallCompiler();
    private final DebugInputCompiler debugInput = new DebugInputCompiler();
    private final GameExitScriptCompiler gameExitScript = new GameExitScriptCompiler();
    private final GameLoaderScriptCompiler gameLoaderScript = new GameLoaderScriptCompiler();
    private final GameSavingScriptCompiler gameSavingScript = new GameSavingScriptCompiler();
    private final IfCompiler ifOpCode = new IfCompiler();
    private final InputCompiler input = new InputCompiler();
    private final LoopBreakerCompiler loopBreaker = new LoopBreakerCompiler();
    private final LoopCompiler loop = new LoopCompiler();
    private final NumDecCompiler numDec = new NumDecCompiler();
    private final NumInitCompiler numInit = new NumInitCompiler();
    private final RoomCompiler room = new RoomCompiler();
    private final SetCompiler set = new SetCompiler();
    private final RoomJumperCompiler roomJumper = new RoomJumperCompiler();
    private final StrDecCompiler strDec = new StrDecCompiler();
    private final StrInitCompiler strInit = new StrInitCompiler();

    CompilerTests() {
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
