package de.ttsa.HelpClasses;

public class OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/FeatureTest/";
    protected final String PATH;
    private final String TEST_PATH = "/TestFiles/OpCode/";

    public OpCodeTestTesterClass(String featureName) {
        PATH = TEST_FILE_PATH + featureName + TEST_PATH;
    }




}
