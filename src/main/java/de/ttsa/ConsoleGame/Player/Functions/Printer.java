package de.ttsa.ConsoleGame.Player.Functions;

import java.util.ArrayList;
import java.util.Arrays;

import de.ttsa.ConsoleGame.Player.Datatypes.Printablable;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class Printer implements Scriptable {

    ArrayList<Printablable> textToPrint;
    
    public Printer(Printablable... text) {
        textToPrint = new ArrayList<>(text.length);
        textToPrint.addAll(Arrays.asList(text));
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
