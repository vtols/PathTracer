package mesh;

import geom.Intersection;
import geom.Ray;

public class MeshTriangles extends Mesh {

    TrianglePrimitive[] tr;

    public MeshTriangles(TrianglePrimitive[] tr) {
        this.tr = tr;
    }

    @Override
    public Intersection intersect(Ray r) {
        if (tr == null)
            return null;
        Intersection x = Intersection.nearest(tr, r);
        if (x != null)
            x.obj = this;
        return x;
    }

}
