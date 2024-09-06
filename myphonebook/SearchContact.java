package myphonebook;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import myphonebook.Contacts.Node;

public class SearchContact implements ActionListener {
    JFrame frame4;
    JButton search, back1;
    JPanel searchpanel;
    JTextField searchbar;
    JLabel lname, lnumber;
    Node nodeOb;
    public void searchNumber(Node nodeOb1) {
        frame4 = new JFrame("_SEARCH CONTACT_");
        search = new JButton("SEARCH");
        searchbar = new JTextField("");
        back1 = new JButton("BACK");
        lname = new JLabel("");
        lnumber = new JLabel("");
        nodeOb=nodeOb1;

        searchpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage backgroundImage = ImageIO.read(new File("D:\\Henotic\\Searchbg.jpg"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        search.setBounds(460, 110, 89, 40);
        searchbar.setFont(new Font("Arial", Font.BOLD, 25));
        searchbar.setBounds(250, 110, 200, 40);
        back1.setBounds(710, 5, 70, 20);
        back1.setForeground(Color.white);
        back1.setBackground(Color.RED);
        searchpanel.add(back1);
        searchpanel.add(search);
        searchpanel.add(searchbar);
        searchpanel.setLayout(null);

        search.addActionListener(this);
        back1.addActionListener(this);
        search.setActionCommand("Searchname");
        back1.setActionCommand("Return");
        lname.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lnumber.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lname.setForeground(Color.BLUE);
        lnumber.setForeground(Color.BLUE);
        lname.setBounds(50, 370, 350, 40);
        lnumber.setBounds(50, 450, 350, 40);
        searchpanel.add(lname);
        searchpanel.add(lnumber);
        frame4.setLocation(250, 100);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setContentPane(searchpanel);
        frame4.setSize(800, 600);
        frame4.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Searchname".equals(command)) {
            String name1= searchbar.getText();
            System.out.println(name1);
            while (nodeOb != null && !nodeOb.name.equals(name1)) {
                nodeOb = nodeOb.next;
            }
            String n2 = (nodeOb != null) ? nodeOb.number : "*****";
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lname.setText("NAME  : " + name1);
                    lnumber.setText("Number   : " + n2);
                }
            });
            
        }
        else if ("Return".equals(command)) {
            frame4.setVisible(false);
        }
    }

}
