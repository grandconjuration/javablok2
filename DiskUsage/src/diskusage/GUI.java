/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskusage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
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

    private JPanel controlPanel, panel_1, panel_2, panel_3;
    private JTextArea input;
    private JButton process, loadExample;
    private JScrollPane scrollPane;
    private JProgressBar progressBar;
    private GridBagConstraints c;
    private String defaultExample;

    public GUI() {

        controlPanel = new JPanel();
        add(controlPanel);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        panel_1 = new JPanel(new FlowLayout());
        panel_2 = new JPanel(new FlowLayout());
        panel_3 = new JPanel(new FlowLayout());

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

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        progressBar.setStringPainted(true);
        Dimension prefSize = progressBar.getPreferredSize();
        prefSize.width = 300;
        progressBar.setPreferredSize(prefSize);
        panel_3.add(progressBar);

        defaultExample = "Filesystem 1K-blocks Used Available Use% Mounted on\n"
                + "/dev/sda6 29640780 4320704 23814388 16% /\n"
                + "udev 1536756 4 1536752 1% /dev\n"
                + "tmpfs 617620 888 616732 1% /run\n"
                + "none 5120 0 5120 0% /run/lock\n"
                + "none 1544044 156 1543888 1% /run/shm";

        controlPanel.add(panel_1, c);
        controlPanel.add(panel_2, c);
        controlPanel.add(panel_3, c);

        setSize(550, 850);
        setTitle("Disk Usage");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == process) {

        }

        if (e.getSource() == loadExample) {
            
            input.setText(defaultExample);
            
        }

    }

}
