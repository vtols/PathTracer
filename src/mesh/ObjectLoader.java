package mesh;

import geom.Vector3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectLoader {

    public static Mesh load(File file) {
        ArrayList<Vector3> v = new ArrayList<>();
        ArrayList<TrianglePrimitive> f = new ArrayList<>();

        FileReader fr;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        BufferedReader br = new BufferedReader(fr);
        String s, ln[];
        try {
            while ((s = br.readLine()) != null) {
                ln = s.split("(\\ )+");
                switch (ln[0]) {
                case "v":
                    float x,
                    y,
                    z;
                    x = Float.parseFloat(ln[1]);
                    y = Float.parseFloat(ln[2]);
                    z = Float.parseFloat(ln[3]) + 20.0f;
                    Vector3 u = new Vector3(x, y, z);
                    v.add(u);
                    break;
                case "f":
                    int i, j, k;
                    i = Integer.parseInt(ln[1]);
                    j = Integer.parseInt(ln[2]);
                    k = Integer.parseInt(ln[3]);
                    Vector3 a, b, c;
                    a = v.get(i - 1);
                    b = v.get(j - 1);
                    c = v.get(k - 1);
                    TrianglePrimitive t = new TrianglePrimitive(a, b, c);
                    f.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        TrianglePrimitive[] ta = new TrianglePrimitive[f.size()];
        return new MeshTriangles(f.toArray(ta));
    }

}
