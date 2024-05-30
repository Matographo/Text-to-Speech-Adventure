package de.ttsa.Enums;

import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Logic.Features.Action.ActionCodeSyntax;
import de.ttsa.Logic.Features.ActionCall.ActionCallCodeSyntax;
import de.ttsa.Logic.Features.DebugInput.DebugInputCodeSyntax;
import de.ttsa.Logic.Features.GameExitScript.GameExitScriptCodeSyntax;
import de.ttsa.Logic.Features.GameLoaderScript.GameLoaderScriptCodeSyntax;
import de.ttsa.Logic.Features.GameSavingScript.GameSavingScriptCodeSyntax;
import de.ttsa.Logic.Features.If.ElseCodeSyntax;
import de.ttsa.Logic.Features.If.IfCodeSyntax;
import de.ttsa.Logic.Features.Input.InputCodeSyntax;
import de.ttsa.Logic.Features.Loop.LoopCodeSyntax;
import de.ttsa.Logic.Features.LoopBreaker.LoopBreakerCodeSyntax;
import de.ttsa.Logic.Features.MusicDec.MusicDecCodeSyntax;
import de.ttsa.Logic.Features.MusicStarter.MusicStarterCodeSyntax;
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
    GAME_SAVING_SCRIPT, IF, ELSE, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM,
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, MUSIC_DEC, MUSIC_STARTER, ALWAYS_FALSE, NONE;

    CodeSyntaxTests mode;

    private static final AlwaysFalseCodeTest alwaysFalse = new AlwaysFalseCodeTest();
    private static final PrinterCodeSyntax printer = new PrinterCodeSyntax();
    private static final ActionCodeSyntax action = new ActionCodeSyntax();
    private static final ActionCallCodeSyntax actionCall = new ActionCallCodeSyntax();
    private static final DebugInputCodeSyntax debugInput = new DebugInputCodeSyntax();
    private static final GameExitScriptCodeSyntax gameExitScript = new GameExitScriptCodeSyntax();
    private static final GameLoaderScriptCodeSyntax gameLoaderScript = new GameLoaderScriptCodeSyntax();
    private static final GameSavingScriptCodeSyntax gameSavingScript = new GameSavingScriptCodeSyntax();
    private static final IfCodeSyntax ifCode = new IfCodeSyntax();
    private static final ElseCodeSyntax elseCode = new ElseCodeSyntax();
    private static final InputCodeSyntax input = new InputCodeSyntax();
    private static final LoopBreakerCodeSyntax loopBreaker = new LoopBreakerCodeSyntax();
    private static final LoopCodeSyntax loop = new LoopCodeSyntax();
    private static final NumDecCodeSyntax numDec = new NumDecCodeSyntax();
    private static final NumInitCodeSyntax numInit = new NumInitCodeSyntax();
    private static final RoomCodeSyntax room = new RoomCodeSyntax();
    private static final SetCodeSyntax set = new SetCodeSyntax();
    private static final RoomJumperCodeSyntax roomJumper = new RoomJumperCodeSyntax();
    private static final StrDecCodeSyntax strDec = new StrDecCodeSyntax();
    private static final StrInitCodeSyntax strInit = new StrInitCodeSyntax();
    private static final MusicDecCodeSyntax musicDec = new MusicDecCodeSyntax();
    private static final MusicStarterCodeSyntax musicStarter = new MusicStarterCodeSyntax();

    CodeSyntaxTests() {
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
            case IF -> test = ifCode;
            case ELSE -> test = elseCode;
            case INPUT -> test = input;
            case LOOP_BREAKER -> test = loopBreaker;
            case LOOP -> test = loop;
            case NUM_INIT -> test = numInit;
            case ROOM -> test = room;
            case SET -> test = set;
            case ROOM_JUMPER -> test = roomJumper;
            case STR_INIT -> test = strInit;
            case MUSIC_DEC -> test = musicDec;
            case MUSIC_STARTER -> test = musicStarter;
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
        } else if (mode.equals(CompilerSyntax.IF.toString())) {
            this.mode = IF;
        } else if (mode.equals("} " + CompilerSyntax.ELSE.toString())) {
            this.mode = ELSE;
        } else if (mode.equals("} " + CompilerSyntax.ELSE_IF.toString())) {
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
        } else if (mode.equals(CompilerSyntax.MUSIC_DEC.toString())) {
            this.mode = MUSIC_DEC;
        } else if (mode.equals(CompilerSyntax.MUSIC_STARTER.toString())) {
            this.mode = MUSIC_STARTER;
        } else {
            this.mode = NONE;
        }
    }
}