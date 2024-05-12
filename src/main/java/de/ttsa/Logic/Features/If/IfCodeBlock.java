package de.ttsa.Logic.Features.If;

import java.util.List;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Interfaces.CodeBlockTestable;

public class IfCodeBlock implements CodeBlockTestable {

    @Override
    public int testCode(String args, List<String> lines) {
        return getBlockContentSize(lines, 0);
    }

    private int getBlockContentSize(List<String> lines, int blockStart) {
        int size = -1;
        int blockCount = 0;
        for (int i = blockStart; i < lines.size(); i++) {
            if(lines.get(i).strip().endsWith(CompilerSyntax.BLOCK_START.toString())) {
                blockCount++;
            }
            if (lines.get(i).strip().startsWith(CompilerSyntax.BLOCK_END.toString())) {
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
