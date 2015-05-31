package mesh;

import geom.Intersection;
import geom.Ray;

public abstract class Primitive implements Intersectable {

    public abstract Intersection intersect(Ray r);

}
