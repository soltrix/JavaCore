package ru.solodkov.javacore;

public class MyArrayDataException extends RuntimeException {
    int line;
    int column;

    public MyArrayDataException(int line, int column) {
        super(line + " " + column);
        this.line = line;
        this.column = column;
    }
}
