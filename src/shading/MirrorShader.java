package shading;

import geom.Intersection;
import geom.Ray;

import tracer.TraceResult;

public class MirrorShader extends Shader {

    @Override
    public TraceResult shade(Intersection x) {
        return null;
    }

    @Override
    public Ray[] reflectionRays(Intersection x) {
        Ray[] rs = new Ray[1];
        rs[0] = x.primaryReflection();
        return rs;
    }

}
