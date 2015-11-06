package shading;

import geom.Ray;

public class Pass {
    public Shader s;
    public Ray r;

    public Pass(Shader s, Ray r) {
        this.s = s;
        this.r = r;
    }
}
