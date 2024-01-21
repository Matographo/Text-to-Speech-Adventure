package de.ttsa.ConsoleGame.Player.Datatypes;

public class STRING implements Printablable {

    private String value;

    public STRING(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    @Override
    public String print() {
        return value;
    }


    
}
