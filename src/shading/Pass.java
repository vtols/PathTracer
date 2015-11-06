package shading;

import geom.Ray;

public class Pass {
    public Shader s;
    public Ray r;
    public boolean save;

    public Pass(Shader s, Ray r, boolean sv) {
        this.s = s;
        this.r = r;
        this.save = sv;
    }
}
