package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.Datatypes.Printablable;

public class Printer implements Scriptable {

    Printablable[] textToPrint;
    
    public Printer(Printablable... text) {
        textToPrint = text;
    }


    @Override
    public boolean run() {
        String text = "";


        for (Printablable printablable : textToPrint) {
            text += printablable.print();
        }

        System.out.println(text);
        return true;
    }
}
