package de.ttsa.Logic.Interfaces;

import java.util.List;

public interface OpCodeBlockTestable {
    /**
     * Test the Block of the Code
     * @param args The arguments of the command
     * @param lines The lines of the code
     * @return true if the syntax is correct
     */
    boolean testOpCode(String args, List<String> lines);
}
