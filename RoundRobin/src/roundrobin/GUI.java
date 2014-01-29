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
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {

    private JTextArea input, output;
    private JScrollPane scrollPane, scrollPane2;
    private JButton leesIn, produceerKoppels, copy, checkKoppels, selectFile;
    private JPanel controlPanel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7, panel_8;
    private JLabel checkKoppelsLabel, personCountLabel, coupleCountLabel;
    private int personCount = 0, coupleCount = 0;

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
        panel_7 = new JPanel(new FlowLayout());
        panel_8 = new JPanel(new FlowLayout());

        selectFile = new JButton("Blader naar tekstbestand");
        selectFile.addActionListener(this);
        panel_1.add(selectFile);

        input = new JTextArea(15, 30);
        panel_2.add(input);

        scrollPane = new JScrollPane(input, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_2.add(scrollPane);

        leesIn = new JButton("Lees in");
        panel_3.add(leesIn);
        leesIn.addActionListener(this);

        produceerKoppels = new JButton("Produceer koppels");
        panel_4.add(produceerKoppels);
        produceerKoppels.addActionListener(this);

        checkKoppels = new JButton("Check koppels");
        panel_4.add(checkKoppels);
        checkKoppels.addActionListener(this);
        
        checkKoppelsLabel = new JLabel("checkKoppels() returns: void");
        panel_5.add(checkKoppelsLabel);
        
        personCountLabel = new JLabel("Nog niemand ingeladen;");
        panel_8.add(personCountLabel);
        
        coupleCountLabel = new JLabel("Nog geen groepen gegenereerd");
        panel_8.add(coupleCountLabel);

        output = new JTextArea(15, 30);
        panel_6.add(output);
        scrollPane2 = new JScrollPane(output, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_6.add(scrollPane2);

        copy = new JButton("Kopieer output");
        copy.addActionListener(this);
        panel_7.add(copy);

        controlPanel.add(panel_1, c);
        controlPanel.add(panel_2, c);
        controlPanel.add(panel_3, c);
        controlPanel.add(panel_4, c);
        controlPanel.add(panel_5, c);
        controlPanel.add(panel_8, c);
        controlPanel.add(panel_6, c);
        controlPanel.add(panel_7, c);

        setSize(550, 850);
        setTitle("Round Robin");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == checkKoppels) {
            boolean bool = Scramble.checkKoppels();
            checkKoppelsLabel.setText("checkKoppels() returns: " + bool);
            
        }

        if (e.getSource() == produceerKoppels) {

            Lijsten.resetKoppels();
            Scramble.runGenerator();
            ArrayList<Koppel> koppels = Lijsten.getKoppels();
//            System.out.println(Lijsten.getKoppels());
            coupleCount++;
            StringBuilder sb = new StringBuilder();
            sb.append("Groep nummer: " + coupleCount + "\n");
            int i = 0;
            while(koppels.size() > i)
            {
                int koppelNummer = i + 1;
                sb.append("Koppel nummer " + koppelNummer + ": " + koppels.get(i).toString());
                i++;
            }
            
            
            coupleCountLabel.setText("Groep nummer: " + coupleCount);
            output.setText(sb.toString());

      //      System.out.println(koppels.get(1).toString());

        }

        if (e.getSource() == selectFile) {

            JFileChooser fc = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fc.setFileFilter(filter);
            int returnValue = fc.showOpenDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();

                if (file.exists() && file.isFile()) {

                    FileReader fr = null;
                    BufferedReader br = null;

                    try {
                        fr = new FileReader(file);
                        br = new BufferedReader(fr);

                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            sb.append("\n");
                            line = br.readLine();
                        }

                        input.setText(sb.toString());
                        //          System.out.println(numOfLines);

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
            personCount = 0;
            coupleCount = 0;
            BufferedReader br = new BufferedReader(new StringReader(input.getText()));

            try {

                while (true) {

                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    //   System.out.println(line);
                    Kandidaat kandidaat = new Kandidaat(line);
                    Lijsten.voegKandidaatToe(kandidaat);
                    personCount++;

                }
                br.close();
                personCountLabel.setText(Integer.toString(personCount) + " personen ingeladen;");
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());

            }

        }

    }

}
