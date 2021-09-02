// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JAX

import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.io.InputStream;
import java.io.IOException;

public final class h
    implements c
{

    public final void ab(int i, int k, int l, int i1, boolean flag)
    {
        v[i * 3] = (byte)k;
        v[i * 3 + 1] = (byte)l;
        v[i * 3 + 2] = (byte)i1;
        if(flag)
            ah();
    }

    public final void ab(int i, int k, int l, int i1)
    {
        ab(i, k, l, i1, false);
    }

    public final void readFile(InputStream inputstream)
    {
		try {
			b.g(inputstream, v);
		} catch (IOException e) {};
    }

    public final int ac(int i)
    {
        return v[i * 3] & 0xff;
    }

    public final int ad(int i)
    {
        return v[i * 3 + 1] & 0xff;
    }

    public final int ae(int i)
    {
        return v[i * 3 + 2] & 0xff;
    }

    public final ColorModel af()
    {
        return w;
    }

    public final int ag(int i, int k, int l)
    {
        int i1 = 768;
        int j1 = 0;
        for(int k1 = 1; k1 < 256; k1++)
        {
            int l1 = Math.abs(i - ac(k1)) + Math.abs(k - ad(k1)) + Math.abs(l - ae(k1));
            if(l1 < i1)
            {
                i1 = l1;
                j1 = k1;
            }
        }

        return j1;
    }

    public final void ah()
    {
        w = new IndexColorModel(8, 256, v, 0, false);
    }

    public h()
    {
        w = null;
        v = null;
        v = new byte[768];
        ah();
    }

    public ColorModel w;
    public byte v[];
}
