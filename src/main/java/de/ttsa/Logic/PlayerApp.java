package de.ttsa.Logic;

import java.io.IOException;

import de.ttsa.Logic.Player.PlayerLogic.Player;
import de.ttsa.Tools.Formater;
import de.ttsa.Tools.SimpleLog;

public class PlayerApp {
    
    public static SimpleLog log = SimpleLog.getLogger("Player");

// -------------------------- Main Method --------------------------



    public static void main(String[] args) throws IOException, InterruptedException {
/*         args = new String[1];
        args[0] = "/home/leodora/Tester/Tester.ta";
  */       new PlayerApp().start(args[0]);
    }



// ----------------------- Start of Player -----------------------



    public void start(String path) {
        Player player = new Player(path);
        player.play();
    }


}
