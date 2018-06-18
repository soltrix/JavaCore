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
        long a = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}
