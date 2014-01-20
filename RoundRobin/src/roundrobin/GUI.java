/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import java.awt.*;
import java.awt.event.*;
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

    public GUI() {

        
        // LAYOUT && JPANEL
        setLayout(new GridBagLayout());
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
        
        

        setSize(550, 850);
        setTitle("Round Robin");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
   
    
    	public static void main(String[] args) {

		GUI RoundRobin = new GUI();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
