package mesh;

import geom.Intersection;
import geom.Ray;

public class MeshPrimitive extends Mesh {

    private Primitive s;

    public MeshPrimitive(Primitive p) {
        s = p;
    }

    @Override
    public Intersection intersect(Ray r) {
        Intersection x = s.intersect(r);
        if (x != null)
            x.obj = this;
        return x;
    }

}
