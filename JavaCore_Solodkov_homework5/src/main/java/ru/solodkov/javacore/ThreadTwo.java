package ru.solodkov.javacore;

import static ru.solodkov.javacore.App.arr;
import static ru.solodkov.javacore.App.h;

public class ThreadTwo implements Runnable {
    static final float[] a2 = new float[h];
    public void run() {
        System.arraycopy(arr, h, a2, 0, h);
        for (int i = 0; i < h; i++) {
            a2[i]=1f;
        }
    }
}
