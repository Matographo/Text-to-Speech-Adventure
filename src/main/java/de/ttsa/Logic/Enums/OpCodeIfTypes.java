package de.ttsa.Logic.Enums;

public enum OpCodeIfTypes {
    NUMBER('n'),
    STRING('s'),
    INPUT('i');

    private final char type;

    OpCodeIfTypes(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

}
