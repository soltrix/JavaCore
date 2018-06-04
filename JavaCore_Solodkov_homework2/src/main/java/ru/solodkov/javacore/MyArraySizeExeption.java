package ru.solodkov.javacore;

public class MyArraySizeExeption extends RuntimeException {
    public MyArraySizeExeption() {
        super("invalid array size");
    }
}
