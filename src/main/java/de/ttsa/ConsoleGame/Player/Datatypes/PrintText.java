package de.ttsa.ConsoleGame.Player.Datatypes;

public class PrintText implements Printablable{

    private final String text;
    
    public PrintText(String text) {
        this.text = text;
    }

    @Override
    public String print() {
        return text;
    }
}
