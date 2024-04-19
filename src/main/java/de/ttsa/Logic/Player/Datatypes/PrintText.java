package de.ttsa.Logic.Player.Datatypes;

public class PrintText implements Printablable{


// ---------------------------- Attributes ----------------------------



    private final String text;



// --------------------------- Constructor ---------------------------
    


    /**
     * Constructor for PrintText
     * @param text the String to print
     */
    public PrintText(String text) {
        this.text = text;
    }



// ----------------------------- Methods -----------------------------



    @Override
    public String print() {
        return text;
    }

    @Override
    public String toString() {
        return print();
    }


    
}
