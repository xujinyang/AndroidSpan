package me.jamesxu.androidspan;

public class WordPosition {
    int start;
    int end;

    public WordPosition(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "WordPosition{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}