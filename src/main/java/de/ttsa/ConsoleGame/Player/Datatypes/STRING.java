package de.ttsa.ConsoleGame.Player.Datatypes;

public class STRING implements Printablable {


// ---------------------------- Attributes ----------------------------



    private String value;



// --------------------------- Constructor ---------------------------


    /**
     * Constructor for STRING
     * @param value the value of the STRING
     */
    public STRING(String value) {
        this.value = value;
    }



// ----------------------------- Methods -----------------------------


    /**
     * Get the value of the STRING
     * @return the value of the STRING
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of the STRING
     * @param newValue the new value of the STRING
     */
    public void setValue(String newValue) {
        this.value = newValue;
    }


    @Override
    public String print() {
        return value;
    }

    
    @Override
    public String toString() {
        return print();
    }
    
}
