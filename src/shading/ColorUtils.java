package shading;

import java.awt.Color;

public class ColorUtils {

    public static Color mix(Color[] c) {
        return mix(c, null);
    }

    public static Color mix(Color[] c, float[] w) {
        float sr = 0.0f, sg = 0.0f, sb = 0.0f, sw = 0.0f;
        int k = c.length;
        for (int i = 0; i < k; i++) {
            float[] comp = c[i].getColorComponents(null);
            if (w == null) {
                sr += comp[0];
                sg += comp[1];
                sb += comp[2];
                sw += 1.0f;
            } else {
                sr += comp[0] * w[i];
                sg += comp[1] * w[i];
                sb += comp[2] * w[i];
                sw += w[i];
            }
        }
        if (sw == 0.0f)
            return Color.BLACK;
        return new Color(sr / sw, sg / sw, sb / sw);
    }

}
