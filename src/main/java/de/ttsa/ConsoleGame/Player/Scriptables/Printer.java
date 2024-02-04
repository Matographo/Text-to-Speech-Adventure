package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.Printablable;

public class Printer implements Scriptable {


// ---------------------------- Attributes ----------------------------



    Printablable[] textToPrint;
    


// --------------------------- Constructor ---------------------------


    /**
     * Constructor for Printer
     * @param text the text that should be printed
     */
    public Printer(Printablable... text) {
        textToPrint = text;
    }



// ----------------------------- Methods -----------------------------



    @Override
    public boolean run() {
        String text = "";


        for (Printablable printablable : textToPrint) {
            text += printablable.print();
        }

        if(GameManager.isTerminalGame) {
            System.out.println(text);
        } else {
            GameManager.output.add(text);
        }
        return true;
    }



}
