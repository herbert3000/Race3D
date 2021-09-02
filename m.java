import java.awt.Point;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.zip.GZIPInputStream;

public class m implements c
{

    public final void readFile(InputStream inputstream)
    {
		try {
			DataInputStream datainputstream = new DataInputStream(new GZIPInputStream(inputstream));
			if(point == null)
				point = new Point(-1, -1);
			int i = datainputstream.readInt();
			str0 = "";
			for(int k = 0; k < i; k++)
				str0 += datainputstream.readChar();

			int l = datainputstream.readInt();
			str1 = "";
			for(int i1 = 0; i1 < l; i1++)
				str1 += datainputstream.readChar();

			for(int j1 = 0; j1 < aw.length; j1++)
				aw[j1].readFile(datainputstream);

			point.x = datainputstream.readInt();
			point.y = datainputstream.readInt();
			int0 = datainputstream.readInt();
			int1 = datainputstream.readInt();
			int2 = datainputstream.readInt();
			int3 = datainputstream.readInt();
			int k1 = datainputstream.readInt();
			vector = new Vector(k1);
			for(int l1 = 0; l1 < k1; l1++)
			{
				y y1 = new y();
				y1.readFile(datainputstream);
				vector.addElement(y1);
			}

			ar.readFile(datainputstream);
		} catch (IOException e) {}
    }

    public final n aw(int i, int k)
    {
        return aw[i | k << 5];
    }

    public m()
    {
        str0 = null;
        str1 = null;
        point = null;
        int0 = 0;
        vector = new Vector();
        ar = new n((byte)0, (byte)0);
        int2 = 0;
        int3 = 0;
        aw = new n[1024];
        for(int i = 0; i < 1024; i++)
            aw[i] = new n();

    }

    public String str0;
    public String str1;
    public n aw[];
    public Point point;
    public int int0;
    public int int1;
    public Vector vector;
    public n ar;
    public int int2;
    public int int3;
}
