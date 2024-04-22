package de.ttsa.HelpClasses;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;

public class OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/FeatureTest/";
    protected final String PATH;
    private final String TEST_PATH = "/TestFiles/OpCode/";



// ------------------------------ CONSTRUCTOR ------------------------------



    public OpCodePlayerTesterClass(String featureName) {
        PATH = TEST_FILE_PATH + featureName + TEST_PATH;
    }


    
// ------------------------------ METHODS ------------------------------



    protected void resetTest() {
        GameManager.clear();
    }


    
}
