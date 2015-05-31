package shading;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import tracer.TraceResult;

public class IncidenceShader extends Shader {

    @Override
    public TraceResult shade(Intersection x) {
        float col = 1.0f - Math.abs(x.norm.dot(x.ray.direction));
        col = 1.0f - col * col;
        return new TraceResult(new Color(col, col, col), 1.0f);
    }

    @Override
    public Ray[] reflectionRays(Intersection x) {
        return null;
    }

}
