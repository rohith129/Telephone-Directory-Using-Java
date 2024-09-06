package myphonebook;

import javax.swing.*;

import myphonebook.Contacts.Node;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class AddContact implements ActionListener {
    JFrame frame1;
    JTextField tt1, tt2, tt3, tt4;
    JLabel ll1, ll2, ll3, ll4, ll;
    JButton clear, next, submit;
    static boolean b;
    Contacts contacts = new Contacts();
    static Node nodeOb = null;

    public void addTOBook() {
        b = true;
        frame1 = new JFrame("ADD CONTACT");
        tt1 = new JTextField(15);
        tt1.setBounds(550, 145, 180, 28);
        tt1.setFont(new Font("Arial", Font.BOLD, 23));
        tt2 = new JTextField(15);
        tt2.setBounds(550, 182, 180, 28);
        tt2.setFont(new Font("Arial", Font.BOLD, 23));
        tt3 = new JTextField(15);
        tt3.setBounds(550, 225, 180, 28);
        tt3.setFont(new Font("Arial", Font.BOLD, 23));
        tt4 = new JTextField(15);
        tt4.setBounds(550, 258, 180, 28);
        tt4.setFont(new Font("Arial", Font.BOLD, 23));
        ;
        ll = new JLabel("__NEW CONTACT DETAILS__");
        ll.setBounds(150, 35, 550, 100);
        ll.setFont(new Font("Arial", Font.BOLD, 37));
        ll1 = new JLabel("NAME     :");
        ll1.setBounds(400, 145, 180, 20);
        ll1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ll2 = new JLabel("NUMBER :");
        ll2.setBounds(400, 185, 180, 20);
        ll2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ll3 = new JLabel("ADDRESS:");
        ll3.setBounds(400, 225, 180, 20);
        ll3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ll4 = new JLabel("PINCODE:");
        ll4.setBounds(400, 265, 180, 20);
        ll4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        clear = new JButton("CLEAR");
        clear.setBounds(400, 330, 110, 35);
        clear.setFont(new Font("Arial", Font.BOLD, 20));
        next = new JButton("SAVE & NEXT");
        next.setBounds(580, 330, 140, 35);
        next.setFont(new Font("Arial", Font.BOLD, 15));
        submit = new JButton("SUBMIT");
        submit.setBounds(480, 380, 140, 35);
        submit.setFont(new Font("Arial", Font.BOLD, 23));

        // Create a custom JPanel for the background image
        JPanel newContactPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load the background image
                    BufferedImage backgroundImage = ImageIO.read(new File("D:\\Henotic\\AddContactbg.png"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        newContactPane.add(tt1);
        newContactPane.add(tt2);
        newContactPane.add(tt3);
        newContactPane.add(tt4);
        newContactPane.add(ll1);
        newContactPane.add(ll2);
        newContactPane.add(ll3);
        newContactPane.add(ll4);
        newContactPane.add(ll);
        newContactPane.add(clear);
        newContactPane.add(next);
        newContactPane.add(submit);
        newContactPane.setLayout(null);

        clear.addActionListener(this);
        next.addActionListener(this);
        submit.addActionListener(this);

        clear.setActionCommand("Clear");
        next.setActionCommand("Next");
        submit.setActionCommand("Submit");

        frame1.setLocation(250, 100);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setContentPane(newContactPane);
        frame1.setSize(800, 600);
        frame1.setVisible(b);
    }

    public static Node getNode() {
        return nodeOb;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Clear".equals(command)) {
            tt1.setText("");
            tt2.setText("");
            tt3.setText("");
            tt4.setText("");
        } else if ("Next".equals(command)) {
            nodeOb = contacts.addContact(tt1.getText(), tt2.getText(), tt3.getText(), tt4.getText());
            // contacts1.addToDisplay(tt1.getText(),tt2.getText(),tt3.getText(),tt4.getText());
            tt1.setText("");
            tt2.setText("");
            tt3.setText("");
            tt4.setText("");
        } else if ("Submit".equals(command)) {
            // ob1.addToDisplay(tt1.getText(),tt2.getText(),tt3.getText(),tt4.getText());
            b = false;
            frame1.setVisible(b);
        }
    }

}
