package de.ttsa.ConsoleGame.Player.Datatypes;

import java.util.HashSet;

public class Set {

    HashSet<String> str;
    HashSet<String> var;

    public Set(HashSet<String> str, HashSet<String> var) {
        this.str = str;
        this.var = var;
    }

    public HashSet<String> getStr() {
        return str;
    }

    public HashSet<String> getVar() {
        return var;
    }

}
