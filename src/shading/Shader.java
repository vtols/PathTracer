package shading;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import tracer.TraceResult;

public abstract class Shader {

    private Color c = Color.WHITE;

    public abstract TraceResult shade(Intersection x);

    public abstract Ray[] reflectionRays(Intersection x);

    public TraceResult shadeReflection(Intersection x, Ray[] r, TraceResult[] tr) {
        Color[] cs = new Color[tr.length];
        float[] ws = new float[tr.length];
        float w = 0.0f;
        for (int i = 0; i < tr.length; i++) {
            cs[i] = tr[i].color;
            ws[i] = tr[i].strength;
            w += ws[i];
        }
        Color mix = ColorUtils.mix(cs, ws);
        float[] a = mix.getColorComponents(null),
                b = c.getColorComponents(null);
        for (int i = 0; i < a.length; i++)
            a[i] *= b[i] * r[i].direction.dot(x.norm);
        Color sub = new Color(a[0], a[1], a[2]);
        return new TraceResult(sub, w);
    }

}
