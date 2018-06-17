package ru.solodkov.javacore;

public class App 
{
    static final int size = 10000000;
    static final int h = size / 2;
    static final float[] arr = new float[size];

    public static void main( String[] args )
    {
        oneThread();
        twoThread();
    }

    public static void oneThread() {
        for (int i = 0; i < size; i++) {
            arr[i]=1f;
        }
        long a = System.currentTimeMillis();
        //System.out.println(a);
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        //System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void twoThread() {
        new Thread(new ThreadOne());
        new Thread(new ThreadTwo());
    }
}
