

package spaceinvaders;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SpaceInvaders extends Canvas {
    
    public SpaceInvaders() {
        
        JFrame frame = new JFrame("SpaceInvaders");
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setLayout(null);
        
        setBounds(0, 0, 800, 600);
        panel.add(this);
        setIgnoreRepaint(true);
        
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SpaceInvaders spaceinvaders = new SpaceInvaders();
    }
    
}
