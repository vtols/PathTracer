package mesh;

import geom.Intersection;
import geom.Ray;
import geom.Vector3;

public class SpherePrimitive extends Primitive {

    Vector3 origin;
    float radius;

    public SpherePrimitive(Vector3 origin, float radius) {
        this.origin = origin;
        this.radius = radius;
    }

    public Intersection intersect(Ray r) {
        Vector3 l = r.direction.orth();
        Vector3 d = origin.sub(r.origin);
        float m = l.dot(d);
        if (m < 0.0)
            return null;
        float d2 = d.dot(d) - m * m;
        float r2 = radius * radius;
        if (d2 > r2)
            return null;
        float x = (float) Math.sqrt(r2 - d2);
        float dist = m - x;
        Vector3 h = r.origin.addDirection(r.direction, dist);
        Vector3 n = h.sub(origin).orth();
        return new Intersection(this, r, h, n);
    }

}
