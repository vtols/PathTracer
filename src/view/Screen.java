package view;

import geom.Ray;
import geom.Vector3;

public class Screen {

    Vector3 origin, planeOrigin;
    float focalLength, width, height;

    public Screen(float w, float h) {
        origin = new Vector3();
        focalLength = 1400.0f;
        width = w;
        height = h;
        Vector3 dir = new Vector3(0.0f, 0.0f, focalLength);
        Vector3 px = new Vector3(-w / 2.0f, 0.0f, 0.0f);
        Vector3 py = new Vector3(0.0f, h / 2.0f, 0.0f);
        planeOrigin = origin.add(dir).add(px).add(py);
    }

    public Ray rayAt(float x, float y) {
        Vector3 px = new Vector3(x * width, 0.0f, 0.0f);
        Vector3 py = new Vector3(0.0f, -y * height, 0.0f);
        Vector3 phit = planeOrigin.add(px).add(py);
        return new Ray(origin, phit.sub(origin));
    }

}
