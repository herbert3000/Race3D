import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;

public class y
    implements c
{

    public final void b_(int i)
    {
        es = i & 0xfff;
        eq = a.c[es];
        ep = a.b[es];
    }

    public final void readFile(InputStream inputstream)
    {
		try {
			DataInputStream datainputstream;
			if(inputstream instanceof DataInputStream)
				datainputstream = (DataInputStream)inputstream;
			else
				datainputstream = new DataInputStream(inputstream);
			ev = datainputstream.readInt();
			eu = datainputstream.readInt();
			et = datainputstream.readInt();
			es = datainputstream.readInt();
			er = datainputstream.readInt();
		} catch (IOException e) {}
    }

    public final int b0()
    {
        return es;
    }

    public final void b1(y y1)
    {
        long l = ev - y1.ev;
        long l1 = eu - y1.eu;
        eo = (int)(l * (long)y1.eq + l1 * (long)y1.ep >> 16);
    }

    public y()
    {
        b_(0);
    }

    public int ev;
    public int eu;
    public int et;
    public int es;
    public int er;
    public volatile transient int eq;
    public volatile transient int ep;
    public volatile transient int eo;
}
