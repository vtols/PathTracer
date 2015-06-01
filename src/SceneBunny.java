import java.io.File;

import mesh.Mesh;
import mesh.ObjectLoader;
import view.Scene;
import view.Screen;


public class SceneBunny implements SceneGenerator {

    @Override
    public Scene generate() {
        Scene z = new Scene();
        z.obj = new Mesh[1];

        z.obj[0] = ObjectLoader.load(new File("bunny.obj"));

        z.sc = new Screen(640, 480);

        return z;
    }

}
