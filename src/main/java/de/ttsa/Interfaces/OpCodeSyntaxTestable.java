package de.ttsa.Interfaces;

public interface OpCodeSyntaxTestable {

    /**
     * Test the syntax of the command
     * @param args The arguments of the command
     * @return true if the syntax is correct
     */
    boolean testOpCode(String arg);
}
