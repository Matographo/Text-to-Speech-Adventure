package de.ttsa.Container;

import de.ttsa.Enums.InputChecker;

public class Range {
    
    private int begin;
    private int end;
    private int current;
    private final int FAILED = -1;

    public Range(String string) {
        StringBuilder range = new StringBuilder(string);
        if (Character.isDigit(string.charAt(1))) {
            int ranges = Integer.parseInt(string.substring(1));
            begin = ranges;
            end = ranges;
        } else {
            range.delete(0, 2);
            range.deleteCharAt(range.length() -1);
            String[] rangeArray = range.toString().split(InputChecker.RANGE.toString());
            if(rangeArray[0].equals("")) {
                begin = FAILED;
            } else {
                begin = Integer.parseInt(rangeArray[0]);
            }

            if(rangeArray.length == 1) {
                end = FAILED;
            } else {
                end = Integer.parseInt(rangeArray[1]);
            }

            if(this.begin == FAILED && this.end == -1) {
                this.begin = 1;
                this.end = 1;
            } else if(this.begin == FAILED) {
                this.begin = 0;
            } else if(this.end == FAILED) {
                this.end = Integer.MAX_VALUE;
            }
        }
    }

    public Range() {
        this.begin = 1;
        this.end = 1;
    }

    public void decrease() {
        current--;
    }

    public boolean isInRange() {
        return current > 0;
    }

    @Override
    public String toString() {
        if(begin == end) {
            return "*(" + begin + ")";
        } else {
            return "*(" + begin + "-" + end + ")";
        }
    }

    
}
