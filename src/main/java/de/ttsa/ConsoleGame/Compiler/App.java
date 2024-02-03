package de.ttsa.ConsoleGame.Compiler;

import de.ttsa.ConsoleGame.Compiler.Compiler.StartCompiler;
import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;


public class App 
{

// ---------------------------- Attributes ----------------------------



    private static final String COMPILED_FILE_EXTENSION = "ttsa";
    private static final String COMPILER_COMMAND = "ttsac";
    private static final String COMPILER_VERSION = "0.0.1";



// -------------------------- Main Method ----------------------------



    public static void main( String[] args ) {
        new App().start(args);
    }


// ----------------------- Start of Compiler -------------------------



    public void start(String[] args) {
        int     length      = args.length;
        boolean noArgs      = length == 0;
        boolean help        = length == 1 && (args[0].equals("-help") || args[0].equals("-h"));
        boolean version     = length == 1 && (args[0].equals("-version") || args[0].equals("-v"));
        boolean compile     = length == 2 && (args[0].equals("-compile") || args[0].equals("-c"));
        boolean test        = length == 2 && (args[1].endsWith("." + COMPILED_FILE_EXTENSION) && (args[0].equals("test") || args[0].equals("-t")));
        boolean hideExecute = length == 2 && (args[0].equals("-x") || !args[1].endsWith("." + COMPILED_FILE_EXTENSION));


        if(noArgs) noArgs();
        else if (help) help();
        else if (version) version();
        else if (compile || hideExecute) {
            if(hideExecute) {
                compile(args[1], true);
            } else {
                compile(args[1], false);
            }
        } else if (test) test(args[1]);
        else {
            throw new IllegalArgumentException("There are troubles with your arguments. Tipe the extention -h or -help for more information."); 
        }
    }



// ------------------------ Argument Options ------------------------


    /**
     * No arguments given.
     */
    private void noArgs() {
        System.out.println("No arguments given. Type the extention -h or -help for more information.");
    }

    /**
     * Print help message.
     */
    private void help() {
        System.out.println("\nUsage: " + COMPILER_COMMAND + " [options] [file]\n\n" +
                           "Options:\n" +                
                           "  -h, -help     Print help message.\n" +
                           "  -v, -version  Print the version.\n" +
                           "  -c, -compile  Compile the given file.\n" +
                           "  -t, -test     Test the given file.\n" +
                           "  -x            Hide the execution of the given file.\n");
    }

    /**
     * Print the version.
     */
    private void version() {
        System.out.println("Version: " + COMPILER_VERSION + "\n");
    }

    /**
     * Compile the given file.
     * @param file path to the file
     * @param isHidden hide the Compilation output
     */
    private void compile(String file, boolean isHidden) {
        try {
            StartCompiler compiler = new StartCompiler(file, isHidden);


            compiler.compile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test the given file.
     * @param file path to the file
     */
    private void test(String file) {
        try {
            OpCodeTest test = new OpCodeTest(file);


            test.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
