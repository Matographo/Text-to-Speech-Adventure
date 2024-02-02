package de.ttsa.TestClasses;

import de.ttsa.ConsoleGame.Player.GameManager;

public class OpCodePlayerTesterClass {
    
    protected final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/";

    protected void resetTest() {
        GameManager.clear();
    }
}
