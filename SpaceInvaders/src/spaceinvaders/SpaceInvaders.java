package spaceinvaders;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javafx.application.Application.launch;
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

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        
      

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
