package de.ttsa.Logic.Interfaces;

public interface OpCodeInnerBlockTestable {

    /**
     * Test the block of the command
     * @param args The arguments of the command
     * @param ifPosition The position of the command in the code
     * @param endOfRoom The end of the Structure in which the command is
     * @return true if the block is correct
     */
    public boolean test(String args, int position, int endOfStruct);
}
