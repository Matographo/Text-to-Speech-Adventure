package de.ttsa.Logic.Features.Room;

import java.util.List;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerStructMethods;

public class RoomCompiler extends CompilerStructMethods {

    @Override
    public String compile(List<String> lines, int blockStart) {
        String commands = lines.get(blockStart).substring(lines.get(blockStart).indexOf(CompilerSyntax.ROOM.toString()) + CompilerSyntax.ROOM.toString().length()).strip();
        lines.remove(blockStart);
        if (commands.contains("{")) {
            commands = commands.substring(0, commands.indexOf(CompilerSyntax.BLOCK_START.toString())).strip();
        }

        StringBuilder compiled = getStartCode(Index.ROOM);
        compiled.append(commands);
        compiled.append(Seperators.ROOM.getSeperator());

        compiled.append(getBlockContentSize(lines, blockStart));
        return compiled.toString();
    }


    private int getBlockContentSize(List<String> lines, int blockStart) {
        int size = 0;
        int blockCount = 1;
        for (int i = blockStart; i < lines.size(); i++) {
            if(lines.get(i).contains(CompilerSyntax.BLOCK_START.toString())) {
                blockCount++;
            }
            if (lines.get(i).contains(CompilerSyntax.BLOCK_END.toString())) {
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
