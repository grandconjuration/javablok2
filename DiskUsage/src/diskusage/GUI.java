/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskusage;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {
    
    private JPanel controlPanel, panel_1, panel_2;
    private JTextArea input;
    private JButton process, loadExample;
    private JScrollPane scrollPane;
    
    
    public GUI() {
        
        controlPanel = new JPanel();
        add(controlPanel);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        
        panel_1 = new JPanel(new FlowLayout());
        panel_2 = new JPanel(new FlowLayout());
        
        input = new JTextArea(10, 40);
        panel_1.add(input);
        
        scrollPane = new JScrollPane(input, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_1.add(scrollPane);        
        
        loadExample = new JButton("Load default example");
        panel_2.add(loadExample);
        process = new JButton("Process");
        panel_2.add(process);
        
        controlPanel.add(panel_1, c);
        controlPanel.add(panel_2, c);
        
        setSize(550, 850);
        setTitle("Disk Usage");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
