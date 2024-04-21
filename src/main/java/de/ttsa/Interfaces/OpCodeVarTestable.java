package de.ttsa.Interfaces;

import de.ttsa.Container.OpCodeVar;

public interface OpCodeVarTestable {
        
    /**
    * Test if the OpCodeVar is a valid OpCodeVar
    * @return true if the OpCodeVar is valid, false otherwise
    */
    public boolean test(String toTest, OpCodeVar opCodeVar);
}
