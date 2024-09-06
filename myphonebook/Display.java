package myphonebook;

import javax.swing.*;
import myphonebook.Contacts.Node;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Display {
    JFrame frame3;
    JTextArea displayArea;
    // static int offset = 50;
    JButton back;

    public void addToDisplay(Node list) {

        frame3 = new JFrame("_Contacts_");
        displayArea = new JTextArea("      NAME\t-        NUMBER       -   ADDRESS     -   PINCODE \n", 10, 30);

        back = new JButton("BACK");
        // Create a custom JPanel for the background image
        JPanel displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load the background image
                    BufferedImage backgroundImage = ImageIO.read(new File("D:\\Henotic\\Display.png"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        while (list != null) {
            displayArea.append("      " + list.name + "\t-        " + list.number + "       -   " + list.address
                    + "     -   " + list.pincode + " \n");
            list = list.next;
        }
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(false);
            }
        });
        back.setBounds(630, 500, 120, 37);
        back.setBackground(Color.RED);
        back.setForeground(Color.white);
        displayArea.setEditable(true);
        displayArea.setBounds(27, 220, 733, 280);
        displayArea.setFont(new Font("Times New Roman", Font.BOLD, 25));
        displayPanel.add(displayArea);
        displayPanel.add(back);
        displayPanel.setLayout(null);
        frame3.setLocation(250, 100);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setContentPane(displayPanel);
        frame3.setSize(800, 600);
        frame3.setVisible(true);

    }
}
