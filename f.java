// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JAX


public class f
{

    public final String toString()
    {
        return new String(s, 0, r);
    }

    public final void u(int i)
    {
        if(i > s.length || i < 0)
        {
            throw new StringIndexOutOfBoundsException(i);
        } else
        {
            r = i;
            return;
        }
    }

    public final f v()
    {
        for(int i = 0; i < r >> 1; i++)
        {
            char c = s[i];
            s[i] = s[r - i - 1];
            s[r - i - 1] = c;
        }

        return this;
    }

    public final int w()
    {
        return r;
    }

    public final int x(int i, int j)
    {
        if(j < 0)
            j = 0;
        else
        if(j >= r)
            return -1;
        for(int k = j; k < r; k++)
            if(s[k] == i)
                return k;

        return -1;
    }

    public final void y(int i, int j, char ac[], int k)
    {
        if(i < 0)
            throw new StringIndexOutOfBoundsException(i);
        if(j > r)
            throw new StringIndexOutOfBoundsException(j);
        if(i > j)
        {
            throw new StringIndexOutOfBoundsException(j - i);
        } else
        {
            System.arraycopy(s, i, ac, k, j - i);
            return;
        }
    }

    public final char[] y()
    {
        return s;
    }

    public final f z()
    {
        u(0);
        return this;
    }

    public final f aa(String s1)
    {
        int i = s1.length();
        if(s.length - r < i)
            i = r - s.length;
        if(i > 0)
        {
            s1.getChars(0, i, s, r);
            r += i;
        }
        return this;
    }

    public final f aa(f f1)
    {
        int i = f1.w();
        if(s.length - r < i)
            i = r - s.length;
        if(i > 0)
        {
            f1.y(0, i, s, r);
            r += i;
        }
        return this;
    }

    public final f aa(long l, int i, int j, char c)
    {
        boolean flag = l < 0L;
        if(flag)
            l = -l;
        q.u(0);
        for(; l >= (long)i; l /= i)
            q.aa(Character.forDigit((int)(l % (long)i), i));

        q.aa(Character.forDigit((int)l, i));
        int k = j - q.r - (flag ? 1 : 0);
        for(int i1 = 0; i1 < k; i1++)
            q.aa(c);

        if(flag)
            q.aa('-');
        return aa(q.v());
    }

    public final f aa(long l, int i, char c)
    {
        return aa(l, 10, i, c);
    }

    public final f aa(long l)
    {
        return aa(l, 10, 0, ' ');
    }

    public final f aa(int i)
    {
        return aa(i, 10, 0, ' ');
    }

    public final f aa(double d, int i, int j)
    {
        long l = Math.round(d * Math.pow(j, i));
        int k = 0;
        boolean flag = l < 0L;
        if(flag)
            l = -l;
        q.u(0);
        for(; l >= (long)j; l /= j)
        {
            q.aa(Character.forDigit((int)(l % (long)j), j));
            if(++k == i)
                q.aa('.');
        }

        q.aa(Character.forDigit((int)l, j));
        if(++k == i)
        {
            q.aa('.');
            q.aa('0');
        }
        if(flag)
            q.aa('-');
        return aa(q.v());
    }

    public final f aa(double d, int i)
    {
        return aa(d, i, 10);
    }

    public final f aa(double d)
    {
        return aa(d, 6, 10);
    }

    public final f aa(char c)
    {
        if(r < s.length)
        {
            s[r] = c;
            r++;
        }
        return this;
    }

    public f(int i)
    {
        r = 0;
        s = new char[i];
    }

    public f()
    {
        this(1024);
    }

    public char s[];
    public int r;
    public static f q = new f();

}
