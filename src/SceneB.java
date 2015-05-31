import java.awt.Color;

import geom.Vector3;
import mesh.Mesh;
import mesh.MeshPrimitive;
import mesh.SpherePrimitive;
import mesh.TrianglePrimitive;
import shading.ColorShader;
import shading.DiffuseShader;
import view.Scene;
import view.Screen;

public class SceneB implements SceneGenerator {

    @Override
    public Scene generate() {
        Scene z = new Scene();
        z.obj = new Mesh[4];

        z.obj[1] = new MeshPrimitive(new TrianglePrimitive(new Vector3(-500.0f,
                -100.0f, 800.0f), new Vector3(-500.0f, -100.0f, 4000.0f),
                new Vector3(500.0f, -100.0f, 800.0f)));
        z.obj[1].setShader(new DiffuseShader());
        
        z.obj[2] = new MeshPrimitive(new TrianglePrimitive(new Vector3(500.0f,
                -100.0f, 4000.0f), new Vector3(500.0f, -100.0f, 800.0f),
                new Vector3(-500.0f, -100.0f, 4000.0f)));
        z.obj[2].setShader(new DiffuseShader());
        
        z.obj[3] = new MeshPrimitive(new SpherePrimitive(new Vector3(-5.0f,
                -60.0f, 1200.0f), 40));
        z.obj[3].setShader(new DiffuseShader());
        
        z.obj[0] = new MeshPrimitive(new SpherePrimitive(new Vector3(0.0f,
                100.0f, 1500.0f), 60));
        z.obj[0].setShader(new ColorShader(Color.WHITE));

        z.sc = new Screen(640, 480);

        return z;
    }

}
