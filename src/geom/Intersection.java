package geom;

import mesh.Intersectable;

public class Intersection {

    public Ray ray;
    public float distance;
    public Vector3 hit, norm;
    public Intersectable obj;

    public static Intersection nearest(Intersectable[] m, Ray r) {
        Intersection near = null;
        for (int k = 0; k < m.length; k++) {
            Intersection x = m[k].intersect(r);
            if (x != null && (near == null || near.distance > x.distance))
                near = x;
        }
        return near;
    }

    public Intersection(Intersectable x, Ray of, Vector3 h, Vector3 n) {
        obj = x;
        ray = of;
        hit = h;
        norm = n;
        distance = h.sub(of.origin).norm();
    }

    public Ray primaryReflection() {
        Vector3 d = ray.direction;
        float k = d.dot(norm);
        Vector3 xd = d.addDirection(norm, -2.0f * k);
        return new Ray(hit, xd);
    }

}
