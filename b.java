import java.io.*;

public class b extends BufferedInputStream
{

    public final synchronized long skip(long l) throws IOException
    {
        long l1 = super.skip(l);
        if(l1 != -1L)
            e += l1;
        return l1;
    }

    public static final void g(InputStream inputstream, byte abyte0[], int j, int k) throws IOException
    {
        char c = '\u2000';
        int i1;
        for(int l = 0; l < k; l += i1)
        {
            i1 = inputstream.read(abyte0, j + l, Math.min(k - l, c));
            if(i1 < 0)
                throw new EOFException();
            Thread.yield();
        }

    }

    public static final void g(InputStream inputstream, byte abyte0[]) throws IOException
    {
        g(inputstream, abyte0, 0, abyte0.length);
    }

    public final synchronized int read(byte abyte0[], int j, int k) throws IOException
    {
        int l = super.read(abyte0, j, k);
        if(l > 0)
            e += l;
        return l;
    }

    public final synchronized int read() throws IOException
    {
        int j = super.read();
        if(j != -1)
            e++;
        return j;
    }

    public final long h()
    {
        return d;
    }

    public final double i()
    {
        if(d < 0L)
            return -1D;
        else
            return (100D * (double)e) / (double)d;
    }

    public b(InputStream inputstream, long l)
    {
        super(inputstream, 8192);
        d = l;
        e = 8192L;
    }

    public long e;
    public long d;
}
