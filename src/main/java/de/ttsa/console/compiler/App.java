package de.ttsa.console.compiler;

import de.ttsa.console.compiler.Compiler.StartCompiler;
import de.ttsa.console.compiler.Tester.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String COMPILED_FILE_EXTENSION = "ttsa";
    private static final String COMPILER_COMMAND = "ttsac";
    private static final String COMPILER_VERSION = "0.0.1";


    public static void main( String[] args ) {
        new App().start(args);
    }

    public void start(String[] args) {
        int length = args.length;
        boolean noArgs = length == 0;
        boolean help = length == 1 && (args[0].equals("-help") || args[0].equals("-h"));
        boolean version = length == 1 && (args[0].equals("-version") || args[0].equals("-v"));
        boolean compile = length == 2 && (args[0].equals("-compile") || args[0].equals("-c"));
        boolean test = length == 2 && (args[1].endsWith("." + COMPILED_FILE_EXTENSION) && (args[0].equals("test") || args[0].equals("-t")));
        boolean hideExecute = length == 2 && (args[0].equals("-x") || !args[1].endsWith("." + COMPILED_FILE_EXTENSION));


        if(noArgs) {
            noArgs();
        } else if (help) {
            help();
        } else if (version) {
            version();
        } else if (compile || hideExecute) {
            if(hideExecute) {
                compile(args[1], true);
            } else {
                compile(args[1], false);
            }
        } else if (test) {
            test(args[1]);
        } else {
            throw new IllegalArgumentException("There are troubles with your arguments. Tipe the extention -h or -help for more information."); 
        }
    }

    private void noArgs() {
        System.out.println("No arguments given. Type the extention -h or -help for more information.");
    }

    private void help() {
        System.out.println("\nUsage: " + COMPILER_COMMAND + " [options] [file]\n\n" +
                           "Options:\n" +                
                           "  -h, -help     Print this help message.\n" +
                           "  -v, -version  Print the version.\n" +
                           "  -c, -compile  Compile the given file.\n" +
                           "  -t, -test     Test the given file.\n" +
                           "  -x            Hide the execution of the given file.\n");
    }

    private void version() {
        System.out.println("Version: " + COMPILER_VERSION + "\n");
    }

    private void compile(String file, boolean isHidden) {
        try {
            StartCompiler compiler = new StartCompiler(file, isHidden);
            compiler.compile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void test(String file) {
        Test test = new Test(file);
        test.start();
        System.out.println(test.getOutput());
    }

}
