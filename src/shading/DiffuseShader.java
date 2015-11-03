package shading;

import geom.Intersection;
import geom.Ray;
import geom.Vector3;

import java.util.Random;

import tracer.TraceResult;

public class DiffuseShader extends Shader {

    private static int raysCount = 16;

    public static void setRaysCount(int k) {
        raysCount = k;
    }

    @Override
    public TraceResult shade(Intersection x) {
        return null;
    }

    @Override
    public Ray[] reflectionRays(Intersection g) {
        Ray[] rays = new Ray[raysCount];
        Random r = new Random();
        for (int i = 0; i < raysCount; i++) {
            float u = r.nextFloat();
            float v = r.nextFloat();
            float th = (float) (2.0f * Math.PI * u);
            float ph = (float) Math.acos(2.0f * v - 1.0f);

            /* Check this, maybe ph and th need to swap */
            float x = (float) (Math.sin(ph) * Math.cos(th));
            float y = (float) (Math.sin(ph) * Math.sin(th));
            float z = (float) Math.cos(ph);
            Vector3 w = new Vector3(x, y, z);
            if (w.dot(g.norm) < 0.0f)
                w = w.scale(-1);
            rays[i] = new Ray(g.hit, w);
        }
        return rays;
    }

}
