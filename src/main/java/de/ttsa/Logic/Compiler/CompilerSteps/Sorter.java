package de.ttsa.Logic.Compiler.CompilerSteps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import de.ttsa.Enums.CompilerSyntax;

public class Sorter {

    // ---------------------------------------------- Attributes
    // -------------------------------------------------- //

    LinkedList<String> fileContent;

    ArrayList<String> setContent;
    ArrayList<String> roomContent;
    ArrayList<String> varContent;
    ArrayList<String> actionContent;

    // ---------------------------------------------- Constructor
    // -------------------------------------------------- //

    public Sorter(ArrayList<String> fileContent) {
        this.fileContent = new LinkedList<>(fileContent);
        setContent       = new ArrayList<String>();
        roomContent      = new ArrayList<String>();
        varContent       = new ArrayList<String>();
        actionContent    = new ArrayList<String>();
    }

    // ---------------------------------------------- Methods
    // -------------------------------------------------- //

    public ArrayList<String> sort() {
        collectBlocks();
        return getSortedContent();
    }

    private ArrayList<String> getSortedContent() {
        ArrayList<String> result = new ArrayList<>();

        result.addAll(varContent);
        result.addAll(setContent);
        result.addAll(actionContent);
        result.addAll(roomContent);

        return result;
    }

    private void collectBlocks() {
        boolean isSet = false;
        boolean isAction = false;
        boolean isRoom = false;
        String line = "";
        ArrayList<String> block = new ArrayList<String>();

        Iterator<String> iterator = fileContent.iterator();
        while (iterator.hasNext()) {
            line = iterator.next().strip();
            block.add(line);
            iterator.remove();
            
            if (line.equals(CompilerSyntax.BLOCK_END.toString())) {
                if (isSet) {
                    setContent.addAll(block);
                } else if (isAction) {
                    actionContent.addAll(block);
                } else if (isRoom) {
                    roomContent.addAll(block);
                }
                block.clear();
                isSet = false;
                isAction = false;
                isRoom = false;
            } else if (line.startsWith(CompilerSyntax.ROOM.toString())) {
                isRoom = true;
            } else if (line.startsWith(CompilerSyntax.ACTION.toString())) {
                isAction = true;
            } else if (line.startsWith(CompilerSyntax.SET.toString())) {
                isSet = true;
            } else if (line.startsWith(CompilerSyntax.NUM_DEC.toString()) &&
                    !line.startsWith(CompilerSyntax.NUM_INIT.toString()) ||
                    line.startsWith(CompilerSyntax.STR_DEC.toString()) &&
                    !line.startsWith(CompilerSyntax.STR_INIT.toString()) ||
                    line.startsWith(CompilerSyntax.MUSIC_DEC.toString()) &&
                    !line.startsWith(CompilerSyntax.MUSIC_STARTER.toString())){
                varContent.add(line);
                block.remove(block.size()-1);
            }
       }
    }
}
