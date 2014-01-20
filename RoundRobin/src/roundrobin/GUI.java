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
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {

    //  private JPanel jp;
    private JTextArea input, output;
    private JScrollPane scrollPane, scrollPane2;
    private JButton leesIn, produceerKoppels, copy, checkKoppels, selectFile;
    private JPanel controlPanel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6;
    private Lijsten lijsten = new Lijsten();

    public GUI() {

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
        panel_6 = new JPanel(new FlowLayout());

        selectFile = new JButton("Blader naar tekstbestand");
        selectFile.addActionListener(this);
        panel_1.add(selectFile);

        input = new JTextArea(15, 10);
        panel_2.add(input);

        scrollPane = new JScrollPane(input, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_2.add(scrollPane);

        leesIn = new JButton("Lees in");
        panel_3.add(leesIn);
        leesIn.addActionListener(this);

        produceerKoppels = new JButton("Produceer koppels");
        panel_4.add(produceerKoppels);

        checkKoppels = new JButton("Check koppels");
        panel_4.add(checkKoppels);

        output = new JTextArea(15, 10);
        panel_5.add(output);
        scrollPane2 = new JScrollPane(output, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_5.add(scrollPane2);

        copy = new JButton("Kopieer output");
        copy.addActionListener(this);
        panel_6.add(copy);

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

    private String readFile(File file) {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }

        } catch (FileNotFoundException ex) {
         //   Logger.getLogger(JavaFX_OpenFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
       //     Logger.getLogger(JavaFX_OpenFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
         //       Logger.getLogger(JavaFX_OpenFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {

        GUI RoundRobin = new GUI();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == selectFile) {

            JFileChooser fc = new JFileChooser();
            int returnValue = fc.showOpenDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();

                if (file.exists() && file.isFile()) {

                    FileReader fr = null;
                    BufferedReader br =  null;

                    try {
                        fr = new FileReader(file);
                        br = new BufferedReader(fr);
                        
                        
                        System.out.println(br.readLine());

                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex.getMessage());

                    }

                }

            }

        }

        if (e.getSource() == copy) {
            String myCopy = output.getText();
            StringSelection stringSelection = new StringSelection(myCopy);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        }

        if (e.getSource() == leesIn) {

            BufferedReader br = new BufferedReader(new StringReader(input.getText()));

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
