package de.ttsa.console.compiler.Compiler;

import java.io.File;

public class Compiler {

    File file;
    String errorText;
    boolean hidden = false;

    public Compiler(String file, boolean hidden) {
        this.hidden = hidden;
        this.file = new File(file);
        if(!this.file.exists()) {
            errorText = "The file " + file + " does not exist.";
            throwError();
        }
    }

    public void compile() {


    }

    private void throwError() {
        throw new IllegalArgumentException(errorText);
    }

    public void isFile() {
        if(file.isDirectory()) {
            
        }
    }















    public void output(String output) {
        if(!hidden) {
            System.out.println(output);
        }
    }

}
