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
        long a = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}
