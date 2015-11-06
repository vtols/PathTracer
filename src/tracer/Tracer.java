package tracer;

import geom.Intersection;
import geom.Ray;

import java.awt.Color;

import mesh.Mesh;
import shading.Pass;
import shading.Shader;
import view.Scene;

public class Tracer {

    private int maxRefl;

    private Scene s;
    private boolean useLast = false;
    private boolean saveLast = true;

    private Pass[] passStack = new Pass[maxRefl];
    private Intersection[] intersectionStack = new Intersection[maxRefl];
    private TraceResult[] traceStack = new TraceResult[maxRefl];
    private int stackTop = 0, lastTop;

    public Tracer(Scene s) {
        this.s = s;
        setMaxRefl(5);
    }

    public void setMaxRefl(int k) {
        maxRefl = k;
        passStack = new Pass[maxRefl];
        intersectionStack = new Intersection[maxRefl];
        traceStack = new TraceResult[maxRefl + 1];
        reset();
    }

    public void reset() {
        useLast = false;
        saveLast = false;
    }

    public void canSave() {
        saveLast = true;
    }

    public TraceResult trace(Ray from) {
        stackTop = 0;
        Ray current = from;

        if (useLast)
            while (stackTop < lastTop && passStack[stackTop].save) {
                current = passStack[stackTop].r;
                stackTop++;
            }

        if (useLast && stackTop == lastTop)
            return traceStack[0];

        for (int i = stackTop; i < maxRefl; i++) {
            Intersection near = Intersection.nearest(s.obj, current);
            if (near == null)
                break;
            Mesh m = (Mesh) near.obj;
            Pass pass = m.getShader().pass(near);
            passStack[i] = pass;
            intersectionStack[i] = near;
            stackTop++;
            if (pass.r == null)
                break;
            current = pass.r;
        }

        TraceResult tr = new TraceResult(Color.BLACK, 0.0f);
        traceStack[stackTop] = tr;
        lastTop = stackTop;
        while (stackTop > 0) {
            stackTop--;
            Shader shader = passStack[stackTop].s;
            Ray ray = passStack[stackTop].r;
            Intersection inter = intersectionStack[stackTop];
            tr = shader.shade(inter, ray, tr);
            traceStack[stackTop] = tr;
        }

        if (saveLast)
            useLast = true;
        return tr;
    }

}
