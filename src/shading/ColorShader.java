package shading;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import tracer.TraceResult;

public class ColorShader extends Shader {

    private Color c;

    public ColorShader(Color c) {
        this.c = c;
    }

    @Override
    public TraceResult shade(Intersection x) {
        return new TraceResult(c, 1.0f);
    }

    @Override
    public Ray[] reflectionRays(Intersection x) {
        return null;
    }

}
