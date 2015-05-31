import geom.Vector3;

import java.awt.Color;

import mesh.Mesh;
import mesh.MeshPrimitive;
import mesh.SpherePrimitive;
import mesh.TrianglePrimitive;
import shading.ColorShader;
import shading.DiffuseShader;
import shading.MirrorShader;
import view.Scene;
import view.Screen;

public class SceneA implements SceneGenerator {

    @Override
    public Scene generate() {
        Scene z = new Scene();
        z.obj = new Mesh[4];

        z.obj[0] = new MeshPrimitive(new TrianglePrimitive(new Vector3(700.0f,
                -700.0f, 2000.0f), new Vector3(-700.0f, -700.0f, 2000.0f),
                new Vector3(0.0f, 700.0f, 2000.0f)));
        z.obj[3] = new MeshPrimitive(new SpherePrimitive(new Vector3(0.0f,
                0.0f, 1000.0f), 60));
        z.obj[2] = new MeshPrimitive(new SpherePrimitive(new Vector3(-150.0f,
                0.0f, 1400.0f), 60));
        z.obj[1] = new MeshPrimitive(new SpherePrimitive(new Vector3(0.0f,
                50.0f, 1500.0f), 60));

        // z.obj[4] = ObjectLoader.load(new File("icosphere.obj"));

        z.obj[2].setShader(new MirrorShader());
        z.obj[2].setShader(new DiffuseShader());

        z.obj[1].setShader(new ColorShader(new Color(0.0f, 1.0f, 0.0f)));
        z.obj[3].setShader(new ColorShader(new Color(1.0f, 0.0f, 0.0f)));
        z.obj[0].setShader(new ColorShader(new Color(0.0f, 0.0f, 0.0f)));

        z.sc = new Screen(640, 480);

        return z;
    }

}
