package tracer;

import java.awt.Color;

public class TraceResult {

    private float strengthMultiplier = 1.0f;
    private float[] strengthRGB;

    public TraceResult(Color c, float s) {
        strengthRGB = c.getColorComponents(null);
        strengthMultiplier = s;
    }

    public TraceResult(float[] strength, float mul) {
        strengthRGB = strength;
        strengthMultiplier = mul;
    }

    public TraceResult multiply(float value) {
        TraceResult tr = new TraceResult(strengthRGB, strengthMultiplier);
        tr.strengthMultiplier *= value;

        return tr;
    }

    public float getRed() {
        return strengthRGB[0] * strengthMultiplier;
    }

    public float getGreen() {
        return strengthRGB[1] * strengthMultiplier;
    }

    public float getBlue() {
        return strengthRGB[2] * strengthMultiplier;
    }

}
