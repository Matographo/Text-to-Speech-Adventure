package de.ttsa.Interfaces;

import java.util.List;

public interface CodeBlockTestable {
    /**
     * Test the Block of the Code
     * @param args The arguments of the command
     * @param lines The lines of the code
     * @return true if the syntax is correct
     */
    int testCode(String args, List<String> lines);
}
