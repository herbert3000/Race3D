public class d
{

    public final void k()
    {
        if(j && i)
        {
            i = false;
            f += System.currentTimeMillis() - g;
        }
    }

    public final long l()
    {
        if(!j)
            return -1L;
        if(i)
            return g - h - f;
        else
            return System.currentTimeMillis() - h - f;
    }

    public final void m(long l1)
    {
        f += l1;
    }

    public final void n()
    {
        j = true;
        i = false;
        h = System.currentTimeMillis();
        f = 0L;
    }

    public final void o(boolean flag)
    {
        if(flag)
            p();
        else
            k();
    }

    public final void p()
    {
        if(j && !i)
        {
            i = true;
            g = System.currentTimeMillis();
        }
    }

    public final boolean q()
    {
        return i;
    }

    public d()
    {
        j = false;
        i = true;
    }

    public boolean j;
    public boolean i;
    public long h;
    public long g;
    public long f;
}
