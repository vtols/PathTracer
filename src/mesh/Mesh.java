package mesh;

import geom.Intersection;
import geom.Ray;
import shading.IncidenceShader;
import shading.Shader;

public abstract class Mesh implements Intersectable {

    private Shader s = new IncidenceShader();

    public Shader getShader() {
        return s;
    }

    public void setShader(Shader s) {
        this.s = s;
    }

    public abstract Intersection intersect(Ray r);

}
