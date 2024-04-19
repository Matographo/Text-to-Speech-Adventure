package de.ttsa.Logic;

import de.ttsa.App;
import de.ttsa.Logic.Player.Player;

public class ConsoleGame {
    
    public static void main(String[] args) {
        new ConsoleGame().start(args);
    }

    public void start(String[] args) {
        if(args.length == 0) {
            System.err.println("Unvalid arguments. Type help or -h for help.");
            System.exit(1);
        }
        String mode = args[0];
        if(mode.equals("player") || mode.equals("p") || mode.equals("-p")) {
            startPlayer(removeFirst(args));
        } else if(mode.equals("compiler") || mode.equals("c") || mode.equals("-c")) {
            startCompiler(removeFirst(args));
        } else if(mode.equals("help") || mode.equals("h") || mode.equals("-h")) {
            startHelp();
        } else if(mode.equals("gui")) {
            App.main(args);
        }else {
            System.err.println("Unvalid arguments. Type help or -h for help.");
        }
    }



    public void startPlayer(String[] args) {
        new PlayerApp().start(args[0]);
    }

    public void startCompiler(String[] args) {
        new CompilerApp().start(args);
    }

    public void startHelp() {
        out("Welcome to TTSAs ConsoleGame!\n");
        out("\nUsage: (this command) [options] [file]\n");
        out("Modes: ");
        out("  Player:");
        out("    player, p, -p: Start the player mode.\n");
        out("  Compiler:");
        out("    compiler, c, -c: Start the compiler mode.\n");
        out("  Help:");
        out("    help, h, -h: Show help.\n");
        out("\n\n");
        out("Options Compiler: ");
        out(CompilerApp.getHelp());
        out("\n\n");
        out("Options Player: ");
        out(Player.getHelp());
        out("\n\n");
    }




    public void out(String message) {
        System.out.println(message);
    }










    public String[] removeFirst(String[] args) {
        String[] newArgs = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            newArgs[i - 1] = args[i];
        }
        return newArgs;
    }


        
}
