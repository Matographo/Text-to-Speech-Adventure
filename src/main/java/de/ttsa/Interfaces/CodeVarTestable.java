package de.ttsa.Interfaces;

import de.ttsa.Container.OpCodeVar;

public interface CodeVarTestable {
    
    /**
    * Test if the CodeVar is a valid OpCodeVar
    * @return true if the OpCodeVar is valid, false otherwise
    */
    public boolean test(String toTest, OpCodeVar opCodeVar);
}
