package de.ttsa.Logic.Enums;

public enum CompilerSyntax {
    SAY("Say"), 
    ACTION("Action"), 
    ACTION_CALL("Do"), 
    DEBUG_INPUT("Debug"), 
    GAME_EXIT_SCRIPT("Exit"), 
    GAME_LOADER_SCRIPT("Load"), 
    GAME_SAVING_SCRIPT("Save"), 
    IF("If"), 
    INPUT("Input"), 
    LOOP_BREAKER("Break"), 
    LOOP("Loop"), 
    NUM_INIT("NumDec"), 
    NUM_DEC("Num"), 
    ROOM("Room"), 
    SET("Set"), 
    ROOM_JUMPER("Jump"), 
    STR_INIT("StrDec"),
    STR_DEC("Str"), 
    COMMENT("//"),
    BLOCK_START("{"),
    BLOCK_END("}"),
    COMMAND(":"),
    NONE("");

    private final String syntax;

    CompilerSyntax(String syntax) {
        this.syntax = syntax;
    }
    private String getSyntax() {
        return syntax;
    }

    public static CompilerSyntax getSyntax(String line) {
        for (CompilerSyntax syntax : CompilerSyntax.values()) {
            if (line.startsWith(syntax.getSyntax())) {
                return syntax;
            }
        }
        return null;
    }


}