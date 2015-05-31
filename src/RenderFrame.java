import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RenderFrame extends JFrame {

    private Image im;
    private Timer tm;
    int w, h;
    ActionListener lis = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

    };

    public RenderFrame(int w, int h, Image im) {
        super("Rendering Scene...");
        this.w = w;
        this.h = h;
        this.im = im;

        tm = new Timer(1000, lis);
        tm.start();
        setContentPane(new DrawPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(w, h);
        setVisible(true);
    }

    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
            g.fillRect(20, 20, 100, 200);
            g.drawImage(im, 0, 0, w, h, null);
        }
    }

}