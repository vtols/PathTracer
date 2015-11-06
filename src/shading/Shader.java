package shading;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import tracer.TraceResult;

public abstract class Shader {

    private Color c = Color.WHITE;

    public abstract TraceResult shade(Intersection x, Ray pass, TraceResult tr);

    public abstract Ray pass(Intersection x);

}
