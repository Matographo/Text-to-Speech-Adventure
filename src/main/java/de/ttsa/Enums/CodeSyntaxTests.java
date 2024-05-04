package de.ttsa.Enums;

import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Logic.Features.Action.ActionCodeSyntax;
import de.ttsa.Logic.Features.ActionCall.ActionCallCodeSyntax;
import de.ttsa.Logic.Features.DebugInput.DebugInputCodeSyntax;
import de.ttsa.Logic.Features.GameExitScript.GameExitScriptCodeSyntax;
import de.ttsa.Logic.Features.GameLoaderScript.GameLoaderScriptCodeSyntax;
import de.ttsa.Logic.Features.GameSavingScript.GameSavingScriptCodeSyntax;
import de.ttsa.Logic.Features.If.IfCodeSyntax;
import de.ttsa.Logic.Features.Input.InputCodeSyntax;
import de.ttsa.Logic.Features.Loop.LoopCodeSyntax;
import de.ttsa.Logic.Features.LoopBreaker.LoopBreakerCodeSyntax;
import de.ttsa.Logic.Features.NumDec.NumDecCodeSyntax;
import de.ttsa.Logic.Features.NumInit.NumInitCodeSyntax;
import de.ttsa.Logic.Features.Printer.PrinterCodeSyntax;
import de.ttsa.Logic.Features.Room.RoomCodeSyntax;
import de.ttsa.Logic.Features.RoomJumper.RoomJumperCodeSyntax;
import de.ttsa.Logic.Features.Set.SetCodeSyntax;
import de.ttsa.Logic.Features.StrDec.StrDecCodeSyntax;
import de.ttsa.Logic.Features.StrInit.StrInitCodeSyntax;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseCodeTest;

public enum CodeSyntaxTests {

    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT,
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM,
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, ALWAYS_FALSE, NONE;

    CodeSyntaxTests mode;

    private final AlwaysFalseCodeTest alwaysFalse;
    private final PrinterCodeSyntax printer;
    private final ActionCodeSyntax action;
    private final ActionCallCodeSyntax actionCall;
    private final DebugInputCodeSyntax debugInput;
    private final GameExitScriptCodeSyntax gameExitScript;
    private final GameLoaderScriptCodeSyntax gameLoaderScript;
    private final GameSavingScriptCodeSyntax gameSavingScript;
    private final IfCodeSyntax ifOpCode;
    private final InputCodeSyntax input;
    private final LoopBreakerCodeSyntax loopBreaker;
    private final LoopCodeSyntax loop;
    private final NumDecCodeSyntax numDec;
    private final NumInitCodeSyntax numInit;
    private final RoomCodeSyntax room;
    private final SetCodeSyntax set;
    private final RoomJumperCodeSyntax roomJumper;
    private final StrDecCodeSyntax strDec;
    private final StrInitCodeSyntax strInit;

    CodeSyntaxTests() {
        alwaysFalse = new AlwaysFalseCodeTest();
        printer = new PrinterCodeSyntax();
        numDec = new NumDecCodeSyntax();
        strDec = new StrDecCodeSyntax();
        action = new ActionCodeSyntax();
        actionCall = new ActionCallCodeSyntax();
        debugInput = new DebugInputCodeSyntax();
        gameExitScript = new GameExitScriptCodeSyntax();
        gameLoaderScript = new GameLoaderScriptCodeSyntax();
        gameSavingScript = new GameSavingScriptCodeSyntax();
        ifOpCode = new IfCodeSyntax();
        input = new InputCodeSyntax();
        loopBreaker = new LoopBreakerCodeSyntax();
        loop = new LoopCodeSyntax();
        numInit = new NumInitCodeSyntax();
        room = new RoomCodeSyntax();
        set = new SetCodeSyntax();
        roomJumper = new RoomJumperCodeSyntax();
        strInit = new StrInitCodeSyntax();
    }

    public CodeSyntaxTestable getTest(String mode) {
        getMode(mode);
        CodeSyntaxTestable test;
        switch (this.mode) {
            case SAY -> test = printer;
            case NUM_DEC -> test = numDec;
            case STR_DEC -> test = strDec;
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
            case NUM_INIT -> test = numInit;
            case ROOM -> test = room;
            case SET -> test = set;
            case ROOM_JUMPER -> test = roomJumper;
            case STR_INIT -> test = strInit;
            case ALWAYS_FALSE -> test = alwaysFalse;
            case NONE -> test = alwaysFalse;
            default -> test = alwaysFalse;
        }
        return test;
    }

    private void getMode(String mode) {
        if (mode.equals(CompilerSyntax.SAY.toString())) {
            this.mode = SAY;
        } else if (mode.equals(CompilerSyntax.NUM_DEC.toString())) {
            this.mode = NUM_DEC;
        } else if (mode.equals(CompilerSyntax.STR_DEC.toString())) {
            this.mode = STR_DEC;
        } else if (mode.equals(CompilerSyntax.ACTION.toString())) {
            this.mode = ACTION;
        } else if (mode.equals(CompilerSyntax.ACTION_CALL.toString())) {
            this.mode = ACTION_CALL;
        } else if (mode.equals(CompilerSyntax.DEBUG_INPUT.toString())) {
            this.mode = DEBUG_INPUT;
        } else if (mode.equals(CompilerSyntax.GAME_EXIT_SCRIPT.toString())) {
            this.mode = GAME_EXIT_SCRIPT;
        } else if (mode.equals(CompilerSyntax.GAME_LOADER_SCRIPT.toString())) {
            this.mode = GAME_LOADER_SCRIPT;
        } else if (mode.equals(CompilerSyntax.GAME_SAVING_SCRIPT.toString())) {
            this.mode = GAME_SAVING_SCRIPT;
        } else if (mode.equals(CompilerSyntax.IF.toString()) || mode.startsWith("} ")) {
            if(!mode.startsWith(CompilerSyntax.ELSE.toString()) && !mode.startsWith(CompilerSyntax.ELSE_IF.toString())) {
                this.mode = NONE;
                return;
            }
            this.mode = IF;
        } else if (mode.equals(CompilerSyntax.INPUT.toString())) {
            this.mode = INPUT;
        } else if (mode.equals(CompilerSyntax.LOOP_BREAKER.toString())) {
            this.mode = LOOP_BREAKER;
        } else if (mode.equals(CompilerSyntax.LOOP.toString())) {
            this.mode = LOOP;
        } else if (mode.equals(CompilerSyntax.NUM_INIT.toString())) {
            this.mode = NUM_INIT;
        } else if (mode.equals(CompilerSyntax.ROOM.toString())) {
            this.mode = ROOM;
        } else if (mode.equals(CompilerSyntax.SET.toString())) {
            this.mode = SET;
        } else if (mode.equals(CompilerSyntax.ROOM_JUMPER.toString())) {
            this.mode = ROOM_JUMPER;
        } else if (mode.equals(CompilerSyntax.STR_INIT.toString())) {
            this.mode = STR_INIT;
        } else {
            this.mode = NONE;
        }
    }
}