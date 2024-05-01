package de.ttsa.Enums;

public enum InputChecker {

    INORDER_START("["),
    INORDER_END("]"),
    OFFORDER_START("{"),
    OFFORDER_END("}"),
    VAR("@"),
    STRING("\""),
    SET("'"),
    ONLY_MODE("~"),
    NOT("-"),
    AND("&"),
    OR("!"),
    RANGE("-"),
    QUANTOR("*");


    
    private String mode;

    InputChecker(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}
