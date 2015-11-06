package shading;

import geom.Intersection;
import geom.Ray;
import geom.Vector3;

import java.util.Random;

import tracer.TraceResult;

public class DiffuseShader implements Shader {

    private static final Random random = new Random(1777);

    @Override
    public TraceResult shade(Intersection x, Ray pass, TraceResult tr) {
        tr.multiply(0.85f * pass.direction.dot(x.norm));
        return tr;
    }

    @Override
    public Ray pass(Intersection g) {
        float u = random.nextFloat();
        float v = random.nextFloat();

        float th = (float) (2.0f * Math.PI * u);
        float ph = (float) Math.acos(2.0f * v - 1.0f);

        /* Check this, maybe ph and th need to swap */
        float x = (float) (Math.sin(ph) * Math.cos(th));
        float y = (float) (Math.sin(ph) * Math.sin(th));
        float z = (float) Math.cos(ph);

        Vector3 w = new Vector3(x, y, z);
        if (w.dot(g.norm) < 0.0f)
            w = w.scale(-1);

        return new Ray(g.hit, w);
    }

}
