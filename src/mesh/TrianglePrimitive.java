package mesh;

import geom.Intersection;
import geom.Ray;
import geom.Vector3;

public class TrianglePrimitive extends Primitive {

    private Vector3 p0, p1, p2, n;

    public TrianglePrimitive(Vector3 a, Vector3 b, Vector3 c) {
        p0 = a;
        p1 = b;
        p2 = c;
        if (p1.sub(p0).dot(p2.sub(p1)) > 0.0f) {
            Vector3 t = p1;
            p1 = p2;
            p2 = t;
        }
        n = b.sub(a).vec(c.sub(a)).orth();
    }

    @Override
    public Intersection intersect(Ray r) {
        Vector3 vx = r.origin.sub(p0), d0 = r.direction.scale(-1.0f),
                d1 = p1.sub(p0), d2 = p2.sub(p0);
        float u = d0.x * d1.y * d2.z + d0.y * d1.z * d2.x + d0.z * d1.x * d2.y
                - d0.z * d1.y * d2.x - d0.x * d1.z * d2.y - d0.y * d1.x * d2.z;
        if (Math.abs(u - 0.0f) < 1e-6)
            return null;
        float s = vx.x * d1.y * d2.z + vx.y * d1.z * d2.x + vx.z * d1.x * d2.y
                - vx.z * d1.y * d2.x - vx.x * d1.z * d2.y - vx.y * d1.x * d2.z;
        float t = s / u;
        Vector3 hit = r.origin.addDirection(r.direction, t);
        Vector3 norm = n;
        if (r.direction.dot(n) > 0.0f)
            norm = norm.scale(-1.0f);
        float za = norm.dot(p1.sub(p0).vec(hit.sub(p0))) + 1e-6f,
              zb = norm.dot(p2.sub(p1).vec(hit.sub(p1))) + 1e-6f,
              zc = norm.dot(p0.sub(p2).vec(hit.sub(p2))) + 1e-6f;
        if (za >= 0.0f && zb >= 0.0f && zc >= 0.0f)
            return new Intersection(this, r, hit, norm);
        return null;
    }

}
