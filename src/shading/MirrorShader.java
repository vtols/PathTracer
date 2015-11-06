package shading;

import geom.Intersection;
import geom.Ray;

import tracer.TraceResult;

public class MirrorShader implements Shader {

    @Override
    public TraceResult shade(Intersection x, Ray pass, TraceResult tr) {
        tr.multiply(0.85f);
        return tr;
    }

    @Override
    public Ray pass(Intersection x) {
        return x.primaryReflection();
    }

}
