package shading;

import geom.Intersection;
import geom.Ray;
import tracer.TraceResult;

import java.util.Random;

public class MixShader implements Shader {

    private Random random = new Random(1777);
    private Shader first, second;
    private float mixCoefficient;

    public MixShader(Shader a, Shader b) {
        setMix(a, b, 0.5f);
    }

    public MixShader(Shader a, Shader b, float mix) {
        setMix(a, b, mix);
    }

    private void setMix(Shader a, Shader b, float mix) {
        first = a;
        second = b;
        mixCoefficient = mix;
    }

    @Override
    public TraceResult shade(Intersection x, Ray pass, TraceResult tr) {
        return null;
    }

    @Override
    public Pass pass(Intersection x) {
        float selection = random.nextFloat();
        Pass result;
        if (selection < mixCoefficient)
            result = first.pass(x);
        else
            result = second.pass(x);
        result.save = false;
        return result;
    }
}
