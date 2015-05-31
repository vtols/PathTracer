import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import render.FrameSampler;
import shading.DiffuseShader;

//import mesh.ObjectLoader;

public class Main {

    static final int w = 640, h = 480;
    static final Random r = new Random();

    public static void main(String[] args) {
        File out = new File("out.png");
        BufferedImage im = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        RenderFrame rframe = new RenderFrame(w, h, im);

        FrameSampler fs = new FrameSampler(new SceneA().generate());
        fs.setSubsampling(2);
        DiffuseShader.setRaysCount(10);
        fs.render(im);

        rframe.setTitle("out.png");

        try {
            ImageIO.write(im, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
