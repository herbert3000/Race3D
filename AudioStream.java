import java.io.ByteArrayInputStream;
import java.util.Vector;

public class AudioStream extends ByteArrayInputStream
{

    public final void o(boolean flag)
    {
        i = flag;
    }

    public final void ba()
    {
        if(bg != null)
        {
            int j = bg.ck(bd);
            if(j == -1)
                close();
            else
            if(j != bc)
            {
                super.buf = (byte[])bh.elementAt(j);
                super.count = super.buf.length;
                reset();
                bc = j;
            }
        }
    }

    public final int read(byte abyte0[], int j, int k)
    {
        if(be)
            return -1;
        if(q())
        {
            for(int l = 0; l < k; l++)
                abyte0[j + l] = 127;

            return k;
        }
        ba();
        int i1 = 0;
        do
        {
            int j1 = super.read(abyte0, j + i1, k - i1);
            if(j1 >= 0)
                i1 += j1;
            else
            if(!bf)
            {
                be = true;
                i1 = j1;
            } else
            {
                bd++;
                ba();
                reset();
            }
        } while(bf && i1 < k);
        return i1;
    }

    public final int read()
    {
        if(be)
            return -1;
        if(q())
            return 127;
        ba();
        int j = super.read();
        if(bf && j == -1)
        {
            ba();
            reset();
            bd++;
            j = super.read();
        }
        if(!bf && j == -1)
            be = true;
        return j;
    }

    public final boolean q()
    {
        return i;
    }

    public final boolean bb()
    {
        return be;
    }

    public final void close()
    {
        be = true;
    }

    public AudioStream(byte abyte0[], boolean flag)
    {
        super(abyte0);
        be = false;
        i = false;
        bd = 0;
        bc = -1;
        bg = null;
        bh = null;
        bf = flag;
    }

    public AudioStream(ac ac1, Vector vector, boolean flag)
    {
        super(new byte[1]);
        be = false;
        i = false;
        bd = 0;
        bc = -1;
        bg = ac1;
        bh = vector;
        bf = flag;
    }

    public Vector bh;
    public ac bg;
    public boolean bf;
    public boolean be;
    public boolean i;
    public int bd;
    public int bc;
}
