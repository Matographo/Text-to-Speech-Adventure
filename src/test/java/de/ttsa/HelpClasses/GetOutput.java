package de.ttsa.HelpClasses;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GetOutput {
    
    private PrintStream originalOut = System.out;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public void init() {
        System.setOut(new PrintStream(outputStream));
    }

    public String getTerminalOutput() {
        return outputStream.toString().trim();
    }

    public void reinit() {
        System.setOut(originalOut);
    }
}
