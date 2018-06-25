package ru.solodkov.javacore;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main( String[] args ) {

        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(9180);
            System.out.println("Запуск сервера");

            socket = server.accept();
            System.out.println("Подключение клиента");

            final Scanner in = new Scanner(socket.getInputStream());
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner console = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String string = in.nextLine();
                        if(string.equals("/quit")) {
                            break;
                        }
                        System.out.println(string);
                        out.println("echo " + string);
                    }
                }
            }).start();

            while (true) {
                System.out.println("Ваше сообщение");
                String string = console.nextLine();
                System.out.println("Сообщение отправлено");
                out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
