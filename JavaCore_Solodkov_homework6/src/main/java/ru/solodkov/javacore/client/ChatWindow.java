package ru.solodkov.javacore.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ChatWindow extends JFrame {
    static final JTextArea jta = new JTextArea();
    static final JTextField jtf = new JTextField();

    ChatWindow() {
        setTitle("Chat");
        setBounds(400,400,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        bottomPanel.setBackground(Color.lightGray);

        bottomPanel.setPreferredSize(new Dimension(1,40));

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        centerPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JButton jButton = new JButton("Send");

        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);

        bottomPanel.add(jtf);
        bottomPanel.add(jButton);

        jtf.setPreferredSize(new Dimension(300,28));
        jta.setEditable(false);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client.out.writeUTF(jtf.getText());
                    jtf.setText("");
                    jtf.requestFocus();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//                jta.append(jtf.getText() + "\n");
//                jtf.setText("");
//                jtf.grabFocus();
            }
        });

        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // super.keyReleased(e);
                if (e.getKeyText(e.getKeyCode()).equals("Enter")) {
                    jta.append(jtf.getText() + "\n");
                    jtf.setText("");
                    jtf.grabFocus();
                }
            }
        });

        setVisible(true);
    }
}
