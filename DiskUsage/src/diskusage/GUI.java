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

/**
 *
 * @author simon_000
 */
public class GUI extends JFrame implements ActionListener {
    
    private JPanel controlPanel, panel_1;
    private JButton process;
    
    
    public GUI() {
        
        controlPanel = new JPanel();
        add(controlPanel);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        
        panel_1 = new JPanel(new FlowLayout());
        
        process = new JButton("Process");
        panel_1.add(process);
        
        controlPanel.add(panel_1, c);
        
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
