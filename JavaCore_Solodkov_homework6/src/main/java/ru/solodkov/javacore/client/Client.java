package ru.solodkov.javacore.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;

    Client() {
        final String IP_ADRESS = "localhost";
        final int PORT = 9091;

            try {
                socket = new Socket(IP_ADRESS, PORT);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                            try {
                                while (true) {
                                    String str = in.readUTF();
                                    if (str.equals("/serverClosed")) {
                                        break;
                                    }
                                    ChatWindow.jta.append(str + "\n");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    socket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}