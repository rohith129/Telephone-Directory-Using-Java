package myphonebook;

import javax.swing.*;

import myphonebook.Contacts.Node;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class OutLook implements ActionListener {
    String s = "";
    int a=0;
    JFrame frame;
    JPanel backgroundPanel;
    JLabel l[] = new JLabel[6];
    JTextField t;
    JButton b;
    Display displayob;
    AddContact addContactob;
    SearchContact searchob;

    public OutLook() {
        displayob = new Display();
        addContactob = new AddContact();
        searchob = new SearchContact();
        SwingUtilities.invokeLater(() -> {

            frame = new JFrame("_MENU_");

            // Create a custom JPanel for the background image
            backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    try {
                        // Load the background image
                        BufferedImage backgroundImage = ImageIO.read(new File("D:\\Henotic\\Mainbackground.jpg"));
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            l[0] = new JLabel("PHONE BOOK MANAGEMENT");
            l[1] = new JLabel("1.ADD CONTACT");
            l[2] = new JLabel("2.SEARCH CONTACT");
            l[3] = new JLabel("3.DISPLAY ALL CONTACT");
            l[4] = new JLabel("4.EXIT");
            l[5] = new JLabel("Enter your choice:");
            t = new JTextField(16);
            b = new JButton("Submit");

            l[0].setBounds(150, -48, 500, 250);
            l[0].setFont(new Font("Times New Roman", Font.BOLD, 30));
            l[1].setBounds(100, 10, 250, 250);
            l[1].setFont(new Font("Arial", Font.BOLD, 25));
            l[2].setBounds(100, 70, 280, 250);
            l[2].setFont(new Font("Arial", Font.BOLD, 25));
            l[3].setBounds(100, 130, 350, 250);
            l[3].setFont(new Font("Arial", Font.BOLD, 25));
            l[4].setBounds(100, 190, 250, 250);
            l[4].setFont(new Font("Arial", Font.BOLD, 25));
            l[5].setBounds(100, 250, 300, 230);
            l[5].setFont(new Font("Arial", Font.BOLD, 23));
            t.setBounds(100, 400, 300, 45);
            t.setFont(new Font("Arial", Font.BOLD, 25));
            b.setBounds(150, 480, 150, 50);
            b.setFont(new Font("Arial", Font.BOLD, 30));
            b.addActionListener(this);

            backgroundPanel.add(l[0]);
            backgroundPanel.add(l[1]);
            backgroundPanel.add(l[2]);
            backgroundPanel.add(l[3]);
            backgroundPanel.add(l[4]);
            backgroundPanel.add(l[5]);
            backgroundPanel.add(t);
            backgroundPanel.add(b);
            backgroundPanel.setLayout(null);

            frame.setLocation(250, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(backgroundPanel);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }

    static Node list = null;

    public void actionPerformed(ActionEvent e) {
        s = t.getText();
        t.setText("");
        switch (s) {
            case "1":
                addContactob.addTOBook();
                list = AddContact.getNode();
                break;
            case "2":
                searchob.searchNumber(list);
                break;
            case "3":
                displayob.addToDisplay(list);
                break;
            case "4":
                System.out.println("Exiting the telephone directory.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

}