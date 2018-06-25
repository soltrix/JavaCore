package ru.solodkov.javacore;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 9180);

            final Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner console = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String string = in.nextLine();
                        System.out.println(string);
                    }
                }
            }).start();

            while (true) {
                System.out.println("Ваше сообщение");
                String string = console.nextLine();
                out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
