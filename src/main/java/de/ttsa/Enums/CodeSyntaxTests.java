package de.ttsa.Enums;

import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Logic.Features.NumDec.NumDecCodeSyntax;
import de.ttsa.Logic.Features.Printer.PrinterCodeSyntax;
import de.ttsa.Logic.Features.StrDec.StrDecCodeSyntax;
import de.ttsa.Logic.Player.Datatypes.AlwaysFalseCodeTest;

public enum CodeSyntaxTests {

    SAY, ACTION, ACTION_CALL, DEBUG_INPUT, GAME_EXIT_SCRIPT, GAME_LOADER_SCRIPT, 
    GAME_SAVING_SCRIPT, IF, INPUT, LOOP_BREAKER, LOOP, NUM_DEC, NUM_INIT, ROOM, 
    SET, ROOM_JUMPER, STR_DEC, STR_INIT, ALWAYS_FALSE, NONE;

    CodeSyntaxTests mode;

    private final AlwaysFalseCodeTest alwaysFalse;
    private final PrinterCodeSyntax printer;
    private final NumDecCodeSyntax numDec;
    private final StrDecCodeSyntax strDec;

    CodeSyntaxTests() {
        alwaysFalse = new AlwaysFalseCodeTest();
        printer = new PrinterCodeSyntax();
        numDec = new NumDecCodeSyntax();
        strDec = new StrDecCodeSyntax();
    }

    public CodeSyntaxTestable getTest(String mode) {
        getMode(mode);
        CodeSyntaxTestable test;
        switch(this.mode) {
            case SAY -> test = printer;
            case NUM_DEC -> test = numDec;
            case STR_DEC -> test = strDec;
            case NONE -> test = alwaysFalse;
            default -> test = alwaysFalse;
        }
        return test;
    }

    private void getMode(String mode) {
        if(mode.equals(CompilerSyntax.SAY.toString())) {
            this.mode = SAY;
        } else if(mode.equals(CompilerSyntax.NUM_DEC.toString())) {
            this.mode = NUM_DEC;
        } else if(mode.equals(CompilerSyntax.STR_DEC.toString())) {
            this.mode = STR_DEC;
        } else {
            this.mode = NONE;
        }
    }
}