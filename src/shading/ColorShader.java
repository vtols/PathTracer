package shading;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import tracer.TraceResult;

public class ColorShader extends Shader {

    private Color c;
    private float strength = 30.0f;

    public ColorShader(Color c) {
        this.c = c;
    }

    @Override
    public TraceResult shade(Intersection x, Ray pass, TraceResult tr) {
        return new TraceResult(c, strength);
    }

    @Override
    public Ray pass(Intersection x) {
        return null;
    }

}
