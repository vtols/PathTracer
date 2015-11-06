package tracer;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import mesh.Mesh;
import shading.Pass;
import shading.Shader;
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
            Pass pass = m.getShader().pass(near);
            Shader shader = pass.s;
            Ray ray = pass.r;
            if (ray != null)
                tr = trace(ray, reflCount + 1);
            tr = shader.shade(near, ray, tr);
        }
        return tr;
    }

    public TraceResult trace(Ray from) {
        return trace(from, 0);
    }

}
