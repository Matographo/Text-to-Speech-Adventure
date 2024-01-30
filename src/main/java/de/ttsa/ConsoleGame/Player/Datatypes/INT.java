package de.ttsa.ConsoleGame.Player.Datatypes;

public class INT implements Printablable {
    
    private int value;

    public INT(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String print() {
        return value + "";
    }

    @Override
    public String toString() {
        return print();
    }

}
