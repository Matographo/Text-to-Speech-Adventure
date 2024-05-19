package de.ttsa.Frontend.Terminal;

import java.io.File;

import de.ttsa.Frontend.Terminal.Dialogs.ProjectConfigerator;
import de.ttsa.Frontend.Terminal.Dialogs.ProjectCreator;
import de.ttsa.Logic.Compiler.StartCompiler;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.Logic.Player.PlayerLogic.Player;


public class CompilerApp 
{

// ---------------------------- Attributes ----------------------------



    private static final String COMPILED_FILE_EXTENSION = "ta";
    private static final String COMPILER_COMMAND = "tacc";
    private static final String COMPILER_VERSION = "0.0.1";



// -------------------------- Main Method ----------------------------



    public static void main( String[] args ) {
        // args = new String[] {"-cp", "."};
        new CompilerApp().start(args);
    }
    


// ----------------------- Start of Compiler -------------------------



    public void start(String[] args) {
        int     length        = args.length;
        boolean noArgs        = length == 0;
        boolean help          = length == 1 && (args[0].equals("-help") || args[0].equals("-h"));
        boolean version       = length == 1 && (args[0].equals("-version") || args[0].equals("-v"));
        boolean compile       = length == 2 && (args[0].equals("-compile") || args[0].equals("-c"));
        boolean newProject    = (length == 2 || length == 3) && (args[0].equals("-new") || args[0].equals("-n") || args[0].equals("-np"));
        boolean test          = length == 2 && (args[1].endsWith("." + COMPILED_FILE_EXTENSION) && ((args[0].equals("test") || args[0].equals("-t"))));
        boolean hideExecute   = length == 2 && (args[0].equals("-x") && !args[1].endsWith("." + COMPILED_FILE_EXTENSION));
        boolean configProject = length == 2 && (args[0].equals("-config") || args[0].equals("-cfg"));
        boolean properties    = length == 2 && (args[0].equals("-properties") || args[0].equals("-p"));
        boolean compilePlay   = length == 2 && (args[0].equals("-compilePlay") || args[0].equals("-cp"));


        if      (noArgs)        noArgs();
        else if (help)          help();
        else if (newProject)    createProject(args);
        else if (version)       version();
        else if (configProject) configurateProject(args[1]);
        else if (properties)    showProperties(args[1]);
        else if (test)          test(args[1]);
        else if (compilePlay)   compileAndPlay(args);
        else if (compile || hideExecute) {
            if(args.length == 2) compile(args[1], "", hideExecute);
            else compile(args[1], args[2], hideExecute);
        } else throw new IllegalArgumentException("There are troubles with your arguments. Tipe the extention -h or -help for more information."); 
    }



// ------------------------ Argument Options ------------------------


    /**
     * No arguments given.
     */
    private void noArgs() {
        System.out.println("No arguments given. Type the extention -h or -help for more information.");
    }


    private void help() {
        System.out.println(getHelp());
    }


    /**
     * return the help message.
     */
    public static String getHelp() {
        return "Options:\n" +                
               "  -h,   -help        Print help message.\n" +
               "  -v,   -version     Print the version.\n" +
               "  -c,   -compile     Compile the given file.\n" +
               "  -n,   -new, -np    Create a new project.\n" +
               "  -t,   -test        Test the given file.\n" +
               "  -cfg, -config      Configurate the project Data.\n" +
               "  -p,   -properties  Show the project properties.\n" +
               "  -x                 Hide the output of the Compiler from the given file.\n";
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
    private boolean compile(String fileSource, String fileDestination, boolean isHidden) {
        try {
            StartCompiler compiler = new StartCompiler(fileSource, fileDestination, isHidden);

            return compiler.compile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Test the given file.
     * @param file path to the file
     */
    private void test(String file) {
        try {
            OpCodeTest test = new OpCodeTest(file);

            long startTime = System.currentTimeMillis();
            if(test.start()) {
                long endTime = System.currentTimeMillis();
                System.out.println("Test passed.");
                System.out.println("Time: " + (endTime - startTime) + "ms");
            } else {
                System.out.println("Test failed.");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create a new project.
     * @param args the arguments
     */
    private void createProject(String[] args) {
        new ProjectCreator(args).create();
    }
    
    /**
     * Configurate the project.
     * @param args the arguments
     */
    private void configurateProject(String arg) {
        new ProjectConfigerator().configurate(getRealPath(arg));
    }
    
    private void showProperties(String arg) {
        new ProjectConfigerator().showProperties(getRealPath(arg));
    }
    

    private String getRealPath(String path) {
        File file = new File(path);
        if(file.getAbsolutePath().endsWith(".")) {
            file = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - 2));
        }
        if(file.exists() && file.isDirectory()) {
            return file.getAbsolutePath();
        } else if(!file.exists() && !file.getAbsolutePath().isBlank()) {
            file = new File((System.getProperty("user.dir") + "/" + path));
            if(file.exists() && file.isDirectory()) {
                return file.getAbsolutePath();
            }
        }
        throw new IllegalArgumentException("The path '" + file.getAbsolutePath() + "' is not a directory.");
    }
    

    private void compileAndPlay(String[] args) {
        String fileSource = getRealPath(args[1]);
        String fileDestination;

        if (args.length == 3) {
            fileDestination = getRealPath(args[2]);
        } else {
            fileDestination = "";
        }

        if (compile(fileSource, fileDestination, false)) {
            Player player;
            if (fileDestination.isBlank()) {
                player = new Player(findGameFile(fileSource));
            } else {
                player = new Player(fileDestination);
            }
            player.play();
        }
    }
    
    private String findGameFile(String file) {
        File f = new File(file);
        if(f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();
            for(File fileInDir : files) {
                if(fileInDir.isDirectory()) {
                    String result = findGameFile(fileInDir.getAbsolutePath());
                    if(result != null && !result.isBlank()) {
                        return result;
                    } else {
                        continue;
                    }
                }
                if(fileInDir.getName().endsWith("." + COMPILED_FILE_EXTENSION)) {
                    return fileInDir.getAbsolutePath();
                }
            }
        }
        return "";
    }

}
