package geom;

public class Vector3 {

    public float x, y, z;

    public Vector3() {
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
    }

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 v) {
        x = v.x;
        y = v.y;
        z = v.z;
    }

    public Vector3 add(Vector3 v) {
        return new Vector3(x + v.x, y + v.y, z + v.z);
    }

    public Vector3 sub(Vector3 v) {
        return new Vector3(x - v.x, y - v.y, z - v.z);
    }

    public Vector3 scale(float k) {
        return new Vector3(x * k, y * k, z * k);
    }

    public Vector3 addDirection(Vector3 v, float k) {
        return add(v.scale(k / v.norm()));
    }

    public float dot(Vector3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3 vec(Vector3 v) {
        return new Vector3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y
                * v.x);
    }

    public float norm() {
        return (float) Math.sqrt(dot(this));
    }

    public Vector3 orth() {
        return scale(1.0f / norm());
    }
}
