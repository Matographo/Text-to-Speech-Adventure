package de.ttsa.ConsoleGame.Player.Datatypes;

public class INT implements Printablable {
    
// ---------------------------- Attributes ----------------------------



    private int value;



// --------------------------- Constructor ---------------------------


    /**
     * Constructor for INT
     * @param value the value of the INT
     */
    public INT(int value) {
        this.value = value;
    }



// ----------------------------- Methods -----------------------------


    /**
     * Set the value of the INT
     * @param value the new value of the INT
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Get the value of the INT
     * @return the value of the INT
     */
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
