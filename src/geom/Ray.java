package geom;

public class Ray {

    public Vector3 origin, direction;

    public Ray(Vector3 origin, Vector3 direction) {
        this.origin = origin;
        this.direction = direction.orth();
    }

}
