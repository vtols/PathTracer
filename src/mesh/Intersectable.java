package mesh;

import geom.Intersection;
import geom.Ray;

public interface Intersectable {

    public Intersection intersect(Ray r);

}
