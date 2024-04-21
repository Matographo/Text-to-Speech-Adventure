package de.ttsa.Logic.Features.Room;

import java.util.List;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerStructMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;
import de.ttsa.Logic.Enums.OpCodeSeperators;

public class RoomCompiler extends CompilerStructMethods {

    @Override
    public String compile(List<String> lines, int blockStart) {
        String commands = lines.get(blockStart).substring(lines.get(blockStart).indexOf(SYNTAX_ROOM) + SYNTAX_ROOM.length()).strip();
        lines.remove(blockStart);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(SYNTAX_BLOCK_START)).strip();
        }

        StringBuilder compiled = getStartCode(OpCodeIndex.ROOM);
        compiled.append(commands);
        compiled.append(OpCodeSeperators.ROOM.getSeperator());

        compiled.append(getBlockContentSize(lines, blockStart));
        return compiled.toString();
    }


    private int getBlockContentSize(List<String> lines, int blockStart) {
        int size = 0;
        int blockCount = 1;
        for (int i = blockStart; i < lines.size(); i++) {
            if(lines.get(i).contains(SYNTAX_BLOCK_START)) {
                blockCount++;
            }
            if (lines.get(i).contains(SYNTAX_BLOCK_END)) {
                size--;
                blockCount--;
            }
            if (blockCount == 0) {
                size++;
                lines.remove(i);
                break;
            }
            size++;
        }
        return size;
    }

}
