package de.ttsa.Logic.Enums;

public enum OpCodeSeperators {
    COMMAND("::"),
    SAY(","),
    ROOM(":"),
    LOOP(":"),
    NUMBER_VARIABLE(":"),
    NUMBER_STRING(":"),
    NUMBER_DEC(":"),
    IF_NUM(":"),
    IF_ELSE(";;"),
    OFFORDER("!!!"),
    VALUE("!!"),
    STR(":"),
    STR_CONTENT(","),
    SET(","),
    SET_NAME(":"),
    ACTION(":"),
    ACTION_ARGS(",");

    private final String seperator;

    OpCodeSeperators(String seperator) {
        this.seperator = seperator;
    }

    public String getSeperator() {
        return seperator;
    }
}
