/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskusage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {

    private JPanel controlPanel, panel_1, panel_2, output_panel;
    private JTextArea input;
    private JButton process, loadExample, clearBars;
    private JScrollPane scrollPane;
    private GridBagConstraints c;
    private String defaultExample;
    ArrayList<JPanel> newPanels = new ArrayList<>();
    ArrayList<JLabel> newLabels = new ArrayList<>();
    ArrayList<JProgressBar> newBars = new ArrayList<>();
    private boolean processed = false;

    public GUI() {

        controlPanel = new JPanel();
        add(controlPanel);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        panel_1 = new JPanel(new FlowLayout());
        panel_2 = new JPanel(new FlowLayout());
        output_panel = new JPanel(new GridBagLayout());

        input = new JTextArea(10, 40);
        panel_1.add(input);

        scrollPane = new JScrollPane(input, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_1.add(scrollPane);

        loadExample = new JButton("Load default example");
        panel_2.add(loadExample);
        loadExample.addActionListener(this);

        process = new JButton("Process");
        panel_2.add(process);
        process.addActionListener(this);

        clearBars = new JButton("Clear");
        clearBars.addActionListener(this);
        
        newArrayLists();

        defaultExample = "Filesystem 1K-blocks Used Available Use% Mounted on\n"
                + "/dev/sda6 29640780 4320704 23814388 16% /\n"
                + "udev 1536756 4 1536752 1% /dev\n"
                + "tmpfs 617620 888 616732 1% /run\n"
                + "none 5120 0 5120 0% /run/lock\n"
                + "none 1544044 156 1543888 1% /run/shm";

        controlPanel.add(panel_1, c);
        controlPanel.add(panel_2, c);
        controlPanel.add(output_panel, c);
        //          controlPanel.add(panel_3, c);

        setSize(550, 900);
        setTitle("Disk Usage");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void newArrayLists() {

        newPanels = new ArrayList<>();
        newLabels = new ArrayList<>();
        newBars = new ArrayList<>();
        Parser.resetDisks();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearBars) {

            output_panel.removeAll(); 
            output_panel.revalidate();
            output_panel.repaint();
            processed = false;
            newArrayLists();
      //      controlPanel.revalidate();
    //        controlPanel.repaint();
      

        }

        if (e.getSource() == process) {
            if (!processed) {
                boolean isParsed = Parser.parseOutput(input.getText());
                ArrayList<Disk> disks = Parser.getDisks();

                if (isParsed) {
                    GridBagConstraints a = new GridBagConstraints();
                    a.gridwidth = GridBagConstraints.REMAINDER;
                    output_panel.add(clearBars, a);
                    int i = 0;
                    while (disks.size() > i) {
                        newPanels.add(new JPanel(new FlowLayout()));
                        newLabels.add(new JLabel(disks.get(i).getNaam()));
                        Dimension prefSizeLabels = newLabels.get(i).getPreferredSize();
                        prefSizeLabels.width = 100;
                        newLabels.get(i).setPreferredSize(prefSizeLabels);
                        newBars.add(new JProgressBar(0, 100));

                        newPanels.get(i).add(newLabels.get(i));
                        newBars.get(i).setValue(disks.get(i).getPercentUsed());
                        newBars.get(i).setStringPainted(true);
                        Dimension prefSizeBars = newBars.get(i).getPreferredSize();
                        prefSizeBars.width = 400;
                        newBars.get(i).setPreferredSize(prefSizeBars);
                        newPanels.get(i).add(newBars.get(i));

                        GridBagConstraints d = new GridBagConstraints();
                        d.gridwidth = GridBagConstraints.REMAINDER;
                        output_panel.add(newPanels.get(i), d);
                        i++;

                    }
                }
                controlPanel.validate();
                controlPanel.repaint();
                processed = true;
            }
        }

        if (e.getSource() == loadExample) {

            input.setText(defaultExample);

        }

    }

}
