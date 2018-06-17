package ru.solodkov.javacore;

import static ru.solodkov.javacore.App.arr;
import static ru.solodkov.javacore.App.h;

public class ThreadOne implements Runnable {
    static final float[] a1 = new float[h];
    public void run() {
        System.arraycopy(arr, 0, a1, 0, h);
        for (int i = 0; i < h; i++) {
            a1[i]=1f;
        }
    }
}
