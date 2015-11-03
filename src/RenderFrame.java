import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RenderFrame extends JFrame {

    private Image im;
    private Timer tm;
    int w, h;

    public RenderFrame(int w, int h, Image im) {
        super("Rendering Scene...");
        this.w = w;
        this.h = h;
        this.im = im;

        tm = new Timer(1000, e -> repaint());
        tm.start();
        setContentPane(new DrawPane());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(w, h);
        setVisible(true);
    }

    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
            g.drawImage(im, 0, 0, w, h, null);
        }
    }

}