package de.ttsa.Enums;

public enum IfTypes {
    NONE(' '),
    NUMBER('n'),
    STRING('s'),
    INPUT('i'),
    NONE_ARG('-');

    private final char type;

    IfTypes(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public static IfTypes convert(char type) {
        for (IfTypes index : IfTypes.values()) {
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
