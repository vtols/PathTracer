package tracer;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import mesh.Mesh;
import view.Scene;

public class Tracer {

    private Scene s;

    public Tracer(Scene s) {
        this.s = s;
    }

    public TraceResult trace(Ray from) {
        TraceResult tr = new TraceResult(Color.BLACK, 0.0f);
        Intersection near = Intersection.nearest(s.obj, from);
        if (near != null) {
            Mesh m = (Mesh) near.obj;
            Ray[] refl = m.getShader().reflectionRays(near);
            if (refl != null) {
                TraceResult[] cs = new TraceResult[refl.length];
                for (int i = 0; i < refl.length; i++) {
                    cs[i] = trace(refl[i]);
                }
                tr = m.getShader().shadeReflection(cs);
            } else
                tr = m.getShader().shade(near);
        }
        return tr;
    }

}
