package de.ttsa.Logic.Enums;

public enum OpCodeIfTypes {
    NONE(' '),
    NUMBER('n'),
    STRING('s'),
    INPUT('i'),
    NONE_ARG('-');

    private final char type;

    OpCodeIfTypes(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public static OpCodeIfTypes convert(char type) {
        for (OpCodeIfTypes index : OpCodeIfTypes.values()) {
            if (index.getType() == type) {
                return index;
            }
        }
        return NONE;
    }

    public boolean isArgType() {
        return this != NONE;
    }

}
