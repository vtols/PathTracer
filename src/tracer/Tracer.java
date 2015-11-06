package tracer;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import mesh.Mesh;
import view.Scene;

public class Tracer {

    private static int maxRefl = 5;

    public static void setMaxRefl(int k) {
        maxRefl = k;
    }

    private Scene s;

    public Tracer(Scene s) {
        this.s = s;
    }

    private TraceResult trace(Ray from, int reflCount) {
        TraceResult tr = new TraceResult(Color.BLACK, 0.0f);
        if (reflCount > maxRefl)
            return tr;
        Intersection near = Intersection.nearest(s.obj, from);
        if (near != null) {
            Mesh m = (Mesh) near.obj;
            Ray pass = m.getShader().pass(near);
            if (pass != null)
                tr = trace(pass, reflCount + 1);
            tr = m.getShader().shade(near, pass, tr);
        }
        return tr;
    }

    public TraceResult trace(Ray from) {
        return trace(from, 0);
    }

}
