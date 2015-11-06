package shading;

import geom.Intersection;
import geom.Ray;

import tracer.TraceResult;

public class MirrorShader implements Shader {

    @Override
    public TraceResult shade(Intersection x, Ray pass, TraceResult tr) {
        return tr.multiply(0.85f);
    }

    @Override
    public Pass pass(Intersection x) {
        return new Pass(this, x.primaryReflection(), true);
    }

}
