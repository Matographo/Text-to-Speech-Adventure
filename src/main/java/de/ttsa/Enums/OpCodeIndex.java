package de.ttsa.Enums;

public enum OpCodeIndex {
    NONE("--"),
    SAY("00"), 
    ROOM("01"), 
    ROOM_JUMPER("02"), 
    NUMBER_DEC("03"), 
    STR_DEC("04"), 
    NUM_INIT("05"), 
    IF("06"), 
    INPUT("07"), 
    STR_INIT("08"), 
    DEBUG("09"), 
    SAVE("0A"), 
    LOAD("0B"), 
    EXIT("0C"), 
    LOOP("0D"), 
    LOOP_BREAKER("0E"), 
    SET("0F"), 
    ACTION("10"), 
    ACTION_CALL("11");

    private String command;

    public final String Say = "00";

    OpCodeIndex(String index) {
        this.command = index;
    }

    public String getIndex() {
        return command;
    }

    public OpCodeIndex convert(String command) {
        for (OpCodeIndex index : OpCodeIndex.values()) {
            if (index.getIndex().equals(command)) {
                return index;
            }
        }
        return NONE;
    }

}
