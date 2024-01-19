package de.ttsa.ConsoleGame.Player.Datatypes;

import java.util.ArrayList;
import java.util.Arrays;

public class Script implements Scriptable{

    private ArrayList<Scriptable> script;
    
    public Script() {
        script = new ArrayList<>();
    }

    public Script(Scriptable script) {
        this.script = new ArrayList<>();
        this.script.add(script);
    }

    public Script(ArrayList<Scriptable> script) {
        this.script = script;
    }

    public Script(Scriptable... script) {
        this.script = new ArrayList<>();
        this.script.addAll(Arrays.asList(script));
    }

    public void add(Scriptable script) {
        this.script.add(script);
    }

    @Override
    public boolean run() {
        for (Scriptable subScript : script) {
            if(!subScript.run()) return false;
        }
        return true;
    }
}
