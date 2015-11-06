package shading;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import tracer.TraceResult;

public interface Shader {

    TraceResult shade(Intersection x, Ray pass, TraceResult tr);

    Pass pass(Intersection x);

}
