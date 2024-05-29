package de.ttsa.Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OpCodeVar {


// --------------------------------- Attributes ---------------------------------------- //



    private Set<String> roomNames;
    private Set<String> varNames;
    private Set<String> numNames;
    private Set<String> strNames;
    private Set<String> actionNames;
    private Set<String> setNames;
    private Set<String> musicNames;

    private Map<String, String> actionArgs = new HashMap<>();
    private Map<String, List<String>> actionArgsCode = new HashMap<>();



// --------------------------------- Constructor ---------------------------------------- //



    public OpCodeVar() {
        roomNames   = new HashSet<>();
        varNames    = new HashSet<>();
        numNames    = new HashSet<>();
        strNames    = new HashSet<>();
        actionNames = new HashSet<>();
        setNames    = new HashSet<>();
        musicNames  = new HashSet<>();
    }

    public OpCodeVar(HashSet<String> roomNames, HashSet<String> varNames, HashSet<String> numNames, HashSet<String> strNames, HashSet<String> actionNames, HashSet<String> setNames, HashSet<String> musicNames) {
        this.roomNames = roomNames;
        this.varNames = varNames;
        this.numNames = numNames;
        this.strNames = strNames;
        this.actionNames = actionNames;
        this.setNames = setNames;
        this.musicNames = musicNames;
    }



// --------------------------------- Methods ---------------------------------------- //


//********************************** Adder *****************************************//
    public boolean addRoomName(String name) {
        return roomNames.add(name);
    }

    public boolean addNumName(String name) {
        return varNames.add(name) && numNames.add(name);
    }

    public boolean addStrName(String name) {
        return varNames.add(name) && strNames.add(name);
    }

    public boolean addActionName(String name) {
        return actionNames.add(name);
    }

    public boolean addSetName(String name) {
        return setNames.add(name);
    }

    public void addActionArgs(String name, String args) {
        actionArgs.put(name, args);
    }

    public boolean addActionNameCode(String name) {
        if(actionArgsCode.put(name, new ArrayList<String>()) != null) return false;
        return actionNames.add(name);
    }
    
    
    public boolean addActionArgsCode(String actionName, String arg) {
        if(!actionArgsCode.containsKey(actionName)) return false;
        return actionArgsCode.get(actionName).add(arg);
    }

    public boolean addMusicName(String name) {
        return musicNames.add(name);
    }

//********************************** Asker ****************************************//
    public boolean isRoomName(String name) {
        return roomNames.contains(name);
    }

    public boolean isVarName(String name) {
        return varNames.contains(name);
    }

    public boolean isNumName(String name) {
        return numNames.contains(name);
    }

    public boolean isStrName(String name) {
        return strNames.contains(name);
    }

    public boolean isActionName(String name) {
        return actionNames.contains(name);
    }

    public boolean isSetName(String name) {
        return setNames.contains(name);
    }

    public String getActionArgs(String name) {
        return actionArgs.get(name);
    }

    public List<String> getActionArgsCode(String action) {
        return actionArgsCode.get(action);
    }

    public boolean isMusicName(String name) {
        return musicNames.contains(name);
    }

}
