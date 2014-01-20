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
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {

    //  private JPanel jp;
    private JTextArea klassenLijst, test;
    private JScrollPane scrollPane, scrollPane2;
    private JButton leesIn, produceerKoppels, copy, checkKoppels;
    private JPanel controlPanel, panel_1, panel_2, panel_3, panel_4, panel_5;
    private Lijsten lijsten = new Lijsten();
    //   private ArrayList<String> namenArray = new ArrayList<String>();

    public GUI() {

        // LAYOUT && JTextArea
        controlPanel = new JPanel();
        add(controlPanel);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        panel_1 = new JPanel(new FlowLayout());
        panel_2 = new JPanel(new FlowLayout());
        panel_3 = new JPanel(new FlowLayout());
        panel_4 = new JPanel(new FlowLayout());
        panel_5 = new JPanel(new FlowLayout());
        
        klassenLijst = new JTextArea(15, 10);
        panel_1.add(klassenLijst);

        scrollPane = new JScrollPane(klassenLijst, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_1.add(scrollPane);

        leesIn = new JButton("Lees in");
        panel_2.add(leesIn);
        leesIn.addActionListener(this);
        
        produceerKoppels = new JButton("Produceer koppels");
        panel_3.add(produceerKoppels);
        
        checkKoppels = new JButton("Check koppels");
        panel_3.add(checkKoppels);
        
        test = new JTextArea(15, 10);
        panel_4.add(test);
        scrollPane2 = new JScrollPane(test, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_4.add(scrollPane2);
        
        copy = new JButton("Kopieer output");
        panel_5.add(copy);

        controlPanel.add(panel_1, c);
        controlPanel.add(panel_2, c);
        controlPanel.add(panel_3, c);
        controlPanel.add(panel_4, c);
        controlPanel.add(panel_5, c);

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

            try {

                while (true) {

                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                    Kandidaat kandidaat = new Kandidaat(line);
                    lijsten.voegKandidaatToe(kandidaat);

                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());

            }

        }

    }

}
