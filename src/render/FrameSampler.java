package render;

import geom.Ray;

import java.awt.Color;
import java.awt.image.BufferedImage;

import tracer.TraceResult;
import tracer.Tracer;
import view.Scene;

public class FrameSampler {

    Scene s;
    Tracer t;
    int aa = 1;
    int rays = 10;

    public FrameSampler(Scene s) {
        this.s = s;
        t = new Tracer(s);
    }

    public void setSubsampling(int k) {
        if (k < 1)
            aa = 1;
        else if (k > 10)
            aa = 10;
        aa = k;
    }

    public void setRaysCount(int k) {
        rays = k;
    }

    public void setMaxRefl(int k) {
        t.setMaxRefl(k);
    }

    public void render(BufferedImage im) {
        int w = im.getWidth(), h = im.getHeight();

        for (int i = 0; i < w; i++) {
            System.out.println(i);
            for (int j = 0; j < h; j++) {
                int c = pixelAt(w, h, i, j).getRGB();
                im.setRGB(i, j, c);
            }
        }
    }

    private Color pixelAt(int w, int h, int i, int j) {
        float dx = 1.0f / aa;
        float sr = 0, sg = 0, sb = 0;
        for (int si = 0; si < aa; si++)
            for (int sj = 0; sj < aa; sj++) {
                t.canSave();
                Ray from = getRay(w, h, i + si * dx, j + sj * dx);
                for (int k = 0; k < rays; k++) {
                    TraceResult tr = t.trace(from);
                    sr += tr.getRed();
                    sg += tr.getGreen();
                    sb += tr.getBlue();
                }
                t.reset();
            }
        float r = sr / (aa * aa * rays),
              g = sg / (aa * aa * rays),
              b = sb / (aa * aa * rays);
        if (r > 1.0f)
            r = 1.0f;
        if (g > 1.0f)
            g = 1.0f;
        if (b > 1.0f)
            b = 1.0f;
        return new Color(r, g, b);
    }

    private Ray getRay(int w, int h, float x, float y) {
        float sx = x / w;
        float sy = y / h;
        return s.sc.rayAt(sx, sy);
    }

}
