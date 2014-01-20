/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {

    private JPanel jp;

    private JTextArea klassenLijst;
    private JScrollPane scrollPane;
    private JButton leesIn;
    private ArrayList<String> namenArray = new ArrayList<String>();

    public GUI() {

        // LAYOUT && JPANEL
        setLayout(new FlowLayout());
        klassenLijst = new JTextArea(15, 10);
        add(klassenLijst);

        scrollPane = new JScrollPane(klassenLijst, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
        //  jp = new JPanel();
        //   jp.setPreferredSize(new Dimension(450, 610));
        //   jp.setBackground(new Color(0, 128, 255));
        //  add(jp);

        leesIn = new JButton("Lees in");
        add(leesIn);
        leesIn.addActionListener(this);

        setSize(550, 850);
        setTitle("Round Robin");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        GUI RoundRobin = new GUI();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == leesIn) {

            BufferedReader br = new BufferedReader(new StringReader(klassenLijst.getText()));
          //  System.out.println(klassenLijst.getText());

            try {

                while (true) {

                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                       System.out.println(line);
                       namenArray.add(line);
                    System.out.println(namenArray);

                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());

            }
            

        }

    }

}

